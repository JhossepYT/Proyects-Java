package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.DatabaseHandler;
import model.User;

public class UserInfoDAO {
    private DatabaseHandler dbHandler;

    public UserInfoDAO() {
        dbHandler = DatabaseHandler.getInstance();
    }

    public User getUserInfoByName(String username) {
        String query = "SELECT * FROM gameUsers WHERE user = ?";
        try (Connection connect = dbHandler.connect();
                PreparedStatement statement = connect.prepareStatement(query)) {

            statement.setString(1, username);

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
            throw new RuntimeException("Error al obtener información del usuario: " + username, e);
        }
        return null;
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

    public boolean verifyUser(String username, String password) {
        String query = "SELECT * FROM gameUsers WHERE user = ? AND password = ?";
        try (Connection connect = dbHandler.connect();
                PreparedStatement statement = connect.prepareStatement(query)) {

            statement.setString(1, username);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al verificar usuario: " + username, e);
        }
    }

    public User verifyAndGetUser(String username, String password) {
        String query = "SELECT * FROM gameUsers WHERE user = ? AND password = ?";
        try (Connection connect = dbHandler.connect();
                PreparedStatement statement = connect.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String user = resultSet.getString("user");
                String pass = resultSet.getString("password");
                return new User(user, pass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void reconnect() {
        DatabaseHandler.getInstance().disconnect();
        DatabaseHandler.getInstance().connect();
    }

    public void addPlusOneWin(User user) {
        String selectQuery = "SELECT wins FROM gameUsers WHERE user = ?";
        String updateQuery = "UPDATE gameUsers SET wins = wins + 1 WHERE user = ?";

        try (Connection connect = dbHandler.connect();
                PreparedStatement selectStatement = connect.prepareStatement(selectQuery);
                PreparedStatement updateStatement = connect.prepareStatement(updateQuery)) {

            // Obtener la cantidad actual de victorias
            selectStatement.setString(1, user.getUsername());
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                int currentWins = resultSet.getInt("wins");
                System.out.println("User: " + user.getUsername() + ", Current Wins: " + currentWins);

                // Actualizar la cantidad de victorias sumándole 1
                updateStatement.setString(1, user.getUsername());
                int rowsAffected = updateStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Win count updated successfully for user: " + user.getUsername());
                } else {
                    System.out.println("No user found with username: " + user.getUsername());
                }
            } else {
                System.out.println("No user found with username: " + user.getUsername());
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while updating win count for user: " + user.getUsername(), e);
        }
    }

    public void saveAttempts(User user, int attempts) {
        String selectQuery = "SELECT attempts FROM gameUsers WHERE user = ?";
        String updateQuery = "UPDATE gameUsers SET attempts = ? WHERE user = ?";

        try (Connection connect = dbHandler.connect();
                PreparedStatement selectStatement = connect.prepareStatement(selectQuery);
                PreparedStatement updateStatement = connect.prepareStatement(updateQuery)) {

            // Obtener la cantidad actual de intentos
            selectStatement.setString(1, user.getUsername());
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                int currentAttempts = resultSet.getInt("attempts");
                System.out.println("User: " + user.getUsername() + ", Current Attempts: " + currentAttempts);

                // Sumar los intentos actuales a los intentos recuperados
                int newAttempts = currentAttempts + attempts;

                // Actualizar la base de datos con el nuevo total de intentos
                updateStatement.setInt(1, newAttempts);
                updateStatement.setString(2, user.getUsername());
                int rowsAffected = updateStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Attempt count updated successfully for user: " + user.getUsername());
                } else {
                    System.out.println("No user found with username: " + user.getUsername());
                }
            } else {
                System.out.println("No user found with username: " + user.getUsername());
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while updating attempt count for user: " + user.getUsername(), e);
        }
    }
}
