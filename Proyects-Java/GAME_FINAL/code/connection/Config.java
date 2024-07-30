package connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final String CONFIG_FILE = "code/resources/application.properties";

    private Properties properties;

    public Config() {
        this.properties = loadProperties();
    }

    private Properties loadProperties() {
        Properties props = new Properties();
        try (InputStream input = new FileInputStream(CONFIG_FILE)) {
            props.load(input);
        } catch (IOException e) {
            System.err.println("Error loading configuration file: " + e.getMessage());
            e.printStackTrace();
        }
        return props;
    }

    public String getDbDriver() {
        return properties.getProperty("db.driver");
    }

    public String getDbUrl() {
        return properties.getProperty("db.url");
    }

    public String getDbUser() {
        return properties.getProperty("db.user");
    }

    public String getDbPassword() {
        return properties.getProperty("db.password");
    }
}