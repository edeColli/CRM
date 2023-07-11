package com.ultimaschool.java.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;

    private Connection connection;

    public DatabaseConnection(){
        try {
            this.createConnection();
        } catch (SQLException e){
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
    private void createConnection() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crm_db", "root", "mysql");
        this.connection.setAutoCommit(true);
    }

    public Connection getConnection(){
        return this.connection;
    }
    public static DatabaseConnection getInstance (){
        if (instance == null){
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void closeConnection(){
        try {
            this.connection.close();
        } catch (SQLException e){
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
}
