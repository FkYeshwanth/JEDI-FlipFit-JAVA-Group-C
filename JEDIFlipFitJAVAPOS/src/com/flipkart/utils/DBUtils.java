/**
 * Utility class for managing database connections using JDBC.
 */
package com.flipkart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Utility class for managing database connections using JDBC.
 */
public class DBUtils {
    private static Connection connection = null;

    /**
     * Obtains a database connection using the properties specified in the config.properties file.
     *
     * @return A Connection object representing the database connection.
     */
    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                Properties prop = new Properties();

                // Load properties from the config.properties file
                InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("");
                FileInputStream fileInputStream = new FileInputStream("");
                prop.load(fileInputStream);

                // Get database connection properties
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");

                // Establish a database connection
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return connection;
        }
    }
}
