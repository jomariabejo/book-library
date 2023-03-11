package com.database;
import java.sql.*;

public class Database {
    public static Connection getConnectionLibrary() throws ClassNotFoundException, SQLException {
        Connection connection;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.
                getConnection(
                        "jdbc:mysql://localhost:3306/library",
                        "root",
                        "");

        return connection;
    }
}