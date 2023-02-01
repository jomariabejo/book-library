package com.initial;

import java.sql.*;

public class CRUD {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL      = "jdbc:mysql://localhost:3306/books";

    static final String USER        = "root";
    static final String PASS        = "";

    /**
     * Print Entire Database
     **/
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
                int id              = rs.getInt("id");
                String title        = rs.getString("title");
                String author_fname = rs.getString("author_fname");
                String author_lname = rs.getString("author_lname");
                int released_year   = rs.getInt("released_year");
                int stock_quantity  = rs.getInt("stock_quantity");
                int pages           = rs.getInt("pages");
                System.out.println(
                        "ID: "             + id + "," +
                        "TITLE: "          + title + "," +
                        "First Name: "     + author_fname + "," +
                        "Last Name: "      + author_lname + "," +
                        "Released Year: "  + released_year + "," +
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
        System.out.println("Thank you for PRINT ALL, Goodbye!");
    }
    public void INSERT(
            String title,
            String author_fname,
            String author_lname,
            String released_year,
            String stock_quantity,
            String pages) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String fnal_start = "INSERT INTO `books1_0`(`title`, `author_fname`, `author_lname`, `released_year`, `stock_quantity`, `pages`) ";
            String fnal_end = " VALUES (" + "'" + title + "'" + ",'" + author_fname + "'" + ',' + "'" + author_lname + "'" + ",'" + released_year + "'" + ",'" + stock_quantity + "','" + pages + "'" + ")";
            String sql = fnal_start + fnal_end;

            int rowsAffected = stmt.executeUpdate(sql);
            System.out.println(rowsAffected + " row(s) affected.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thank you for INSERT, Goodbye!");
    }
    public String insertstatementExample() {
        String title        = "test8:25";
        String author_fname = "test_first_name";
        String author_lname = "test_last_name";
        int released_year   = 2001;
        int stock_quantity  = 200;
        int pages           = 467;
        String fnal_start   = "INSERT INTO `books1_0`(`title`, `author_fname`, `author_lname`, `released_year`, `stock_quantity`, `pages`) ";
        String fnal_end     = " VALUES (" + "'" + title + "'" + ",'" + author_fname + "'" + ',' + "'" + author_lname + "'" + ",'" + released_year + "'" + ",'" + stock_quantity + "','" + pages + "'" + ")";

        return fnal_start + fnal_end;
    };
}