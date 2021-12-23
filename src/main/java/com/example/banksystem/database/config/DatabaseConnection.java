package com.example.banksystem.database.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String HOST = "localhost";
    private static final Integer PORT = 3306;
    private static final String DB_NAME = "bank_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    static Connection connection;

    public static Connection getConnection() throws SQLException {

        connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", HOST, PORT, DB_NAME), USER, PASSWORD);

        return connection;

    }

}
