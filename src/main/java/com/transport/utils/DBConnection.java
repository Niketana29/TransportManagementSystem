package com.transport.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.IOException;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Properties props = new Properties();
                props.load(DBConnection.class.getClassLoader().getResourceAsStream("db.properties"));
    
                String url = props.getProperty("db.url");
                String user = props.getProperty("db.username");
                String password = props.getProperty("db.password");
                String driver = props.getProperty("db.driver");
    
                // Load the MySQL JDBC driver class
                Class.forName(driver);
    
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Database Connected Successfully!");
            } catch (IOException | SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    
}
