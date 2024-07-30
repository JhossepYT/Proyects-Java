package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler {
    private static DatabaseHandler instance;
    private Connection connection;

    private DatabaseHandler() {
        Config config = new Config();
        String dbUrl = config.getDbUrl();
        String dbUser = config.getDbUser();
        String dbPassword = config.getDbPassword();

        try {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized DatabaseHandler getInstance() {
        if (instance == null) {
            instance = new DatabaseHandler();
        }
        return instance;
    }

    public Connection connect() {
        if (connection == null) {
            Config config = new Config();
            String dbUrl = config.getDbUrl();
            String dbUser = config.getDbUser();
            String dbPassword = config.getDbPassword();

            try {
                connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
