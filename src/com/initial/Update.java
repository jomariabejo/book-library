package com.initial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/books";

    static final String USER = "root";
    static final String PASS = "";


    public void UpdateBook(String updateID, String title, String author_fname , String author_lname,String released_year, String stock_quantity, String pages){
        Connection conn = null;
        Statement stmt = null;
        try {
            // Load driver class
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            // Obtain a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Creating statement...");
            // Obtain a statement
            stmt = conn.createStatement();
            String sql = "UPDATE `books1_0` SET `title` = '" + title + "' , `author_fname`='" + author_fname+"', `author_lname` = '" + author_lname +"', `released_year` = '"+ released_year +"', `stock_quantity`='"+ stock_quantity+"', `pages` = '" +pages+"' WHERE id = "+updateID;
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (Exception se) {
            se.printStackTrace();
        }
        finally {
            try {
                if (stmt != null) stmt.close();
            }
            catch (SQLException ignored) {}
            try {
                if (conn != null) conn.close();
            }
            catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("DATA has been UPDATED, Goodbye!");
    }
}
