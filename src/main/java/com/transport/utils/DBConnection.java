package com.transport.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Properties props = new Properties();
                props.load(new FileInputStream("db.properties"));

                String url = props.getProperty("DB_URL");
                String user = props.getProperty("DB_USER");
                String password = props.getProperty("DB_PASSWORD");

                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Database Connected Successfully!");
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
