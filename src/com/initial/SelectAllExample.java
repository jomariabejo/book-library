package com.initial;

import java.sql.*;

public class SelectAllExample {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/books";

    static final String USER = "root";
    static final String PASS = "";

    public void printBooksDetails() {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM books1_0";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author_fname = rs.getString("author_fname");
                String author_lname = rs.getString("author_lname");
                int released_year = rs.getInt("released_year");
                int stock_quantity = rs.getInt("stock_quantity");
                int pages = rs.getInt("pages");
                System.out.println(
                        "ID: " + id + "," +
                        "TITLE: " + title + "," +
                        "First Name: " + author_fname + "," +
                        "Last Name: " + author_lname + "," +
                        "Released Year: " + released_year + "," +
                        "Stock Quantity: " + stock_quantity + "," +
                        "pages: " + pages
                );
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException ignored) {}
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}