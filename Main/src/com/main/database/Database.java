package com.main.database;
import java.sql.*;

public class Database {
    /*
     *  Get database of Books
     */
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