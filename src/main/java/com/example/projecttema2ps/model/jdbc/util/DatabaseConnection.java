package com.example.projecttema2ps.model.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection = null;
    static {
        String url = "jdbc:mysql://localhost:3306/clinicdb";
        String user = "root";
        String pass = "ajrotq1w2e3";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Database connected!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() { return  connection; }
}
