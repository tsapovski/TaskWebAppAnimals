package com.example.taskwebappanimals.database;

import java.sql.*;

public class ConnectDataBase {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/animals";
    private static final String USER_LOGIN = "root";
    private static final String USER_PASSWORD = "root";

    public static Connection getDBConnection() {
        Connection dbConnection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            dbConnection = DriverManager.getConnection(DB_URL, USER_LOGIN, USER_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }


}
