package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.DatabaseHandler;
import model.User;

public class LoginDAO {
  private DatabaseHandler dbHandler;

  public LoginDAO() {
    dbHandler = DatabaseHandler.getInstance();
  }

  public boolean addUser(String username, String password) {
    String query = "INSERT INTO gameUsers (user, password, wins) VALUES (?, ?, 0)";
    try (Connection connect = dbHandler.connect();
        PreparedStatement statement = connect.prepareStatement(query)) {

      statement.setString(1, username);
      statement.setString(2, password);

      int rowsAffected = statement.executeUpdate();
      return rowsAffected > 0;
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException("Error al agregar nuevo usuario: " + username, e);
    }
  }

  public User loginUser(String username, String password) {
    String query = "SELECT * FROM gameUsers WHERE user = ? AND password = ?";
    try (Connection connect = dbHandler.connect();
        PreparedStatement statement = connect.prepareStatement(query)) {

      statement.setString(1, username);
      statement.setString(2, password);

      try (ResultSet resultSet = statement.executeQuery()) {
        if (resultSet.next()) {
          int userId = resultSet.getInt("user_id");
          String name = resultSet.getString("user");
          int wins = resultSet.getInt("wins");
          return new User(userId, name, wins);
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException("Error al iniciar sesión para el usuario: " + username, e);
    }
    return null;
  }

  public boolean userExists(String username) {
    String query = "SELECT * FROM gameUsers WHERE user = ?";
    try (Connection connect = dbHandler.connect();
        PreparedStatement statement = connect.prepareStatement(query)) {

      statement.setString(1, username);

      try (ResultSet resultSet = statement.executeQuery()) {
        return resultSet.next();
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException("Error al verificar la existencia del usuario: " + username, e);
    }
  }
}
