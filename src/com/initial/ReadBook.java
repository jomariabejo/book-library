package com.initial;
import java.sql.*;

public class ReadBook {
    Connection conn = null;
    Statement stmt = null;
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/books";

    static final String USER = "root";
    static final String PASS = "";

    public void FindBookByTitle(String title_input) {
        {
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
                String query = "SELECT * FROM books1_0 WHERE title = '" + title_input + "'";
                PreparedStatement sql_start = conn.prepareStatement(query);
                /**
                 * Execute the query
                 **/
                ResultSet rs = sql_start.executeQuery();
                boolean result = stmt.execute(query);


                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    String author_fname = rs.getString("author_fname");
                    String author_lname = rs.getString("author_lname");
                    int released_year = rs.getInt("released_year");
                    int stock_quantity = rs.getInt("stock_quantity");
                    int pages = rs.getInt("pages");
                    System.out.println(
                            "MYSQL RESPONSE ->                            \n" +
                                    "ID            : " + id + ",           \n" +
                                    "TITLE         : " + title + ",         \n" +
                                    "First Name    : " + author_fname + ",   \n" +
                                    "Last Name     : " + author_lname + ",    \n" +
                                    "Released Year : " + released_year + ",    \n" +
                                    "Stock Quantity: " + stock_quantity + ",    \n" +
                                    "pages         : " + pages
                    );
                }
                if (result) {
                    System.out.println("Query executed successfully");
                } else {
                    System.out.println("Query failed to execute");
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
            System.out.println("FindBookByTitle called...");
        }
    }
    public void FindBookByID(String ID) {
        {

            try {
                // Load driver class
                Class.forName(JDBC_DRIVER);
                System.out.println("Connecting to database...");
                // Obtain a connection
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("Creating statement...");
                // Obtain a statement
                stmt = conn.createStatement();
                String query = "SELECT * FROM books1_0 WHERE id = " + ID;
                PreparedStatement sql_start = conn.prepareStatement(query);
                /**
                 * Execute the query
                 **/
                ResultSet rs = sql_start.executeQuery();
                boolean result = stmt.execute(query);


                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    String author_fname = rs.getString("author_fname");
                    String author_lname = rs.getString("author_lname");
                    int released_year = rs.getInt("released_year");
                    int stock_quantity = rs.getInt("stock_quantity");
                    int pages = rs.getInt("pages");
                    System.out.println(
                            "MYSQL RESPONSE ->                            \n" +
                                    "ID            : " + id + ",           \n" +
                                    "TITLE         : " + title + ",         \n" +
                                    "First Name    : " + author_fname + ",   \n" +
                                    "Last Name     : " + author_lname + ",    \n" +
                                    "Released Year : " + released_year + ",    \n" +
                                    "Stock Quantity: " + stock_quantity + ",    \n" +
                                    "pages         : " + pages
                    );
                }
                if (result) {
                    System.out.println("Query executed successfully");
                } else {
                    System.out.println("Query failed to execute");
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
            System.out.println("Thank you for using FINDBYID, Goodbye!");
        }
    }
    public void FindBookByAuthorFullName(String f_name, String l_name) {
        {

            try {
                // Load driver class
                Class.forName(JDBC_DRIVER);
                System.out.println("Connecting to database...");
                // Obtain a connection
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("Creating statement...");
                // Obtain a statement
                stmt = conn.createStatement();
                String query = "SELECT * FROM books1_0 WHERE author_fname = '" + f_name+"' AND author_lname = '" + l_name+"'";
                PreparedStatement sql_start = conn.prepareStatement(query);
                /**
                 * Execute the query
                 **/
                ResultSet rs = sql_start.executeQuery();
                boolean result = stmt.execute(query);


                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    String author_fname = rs.getString("author_fname");
                    String author_lname = rs.getString("author_lname");
                    int released_year = rs.getInt("released_year");
                    int stock_quantity = rs.getInt("stock_quantity");
                    int pages = rs.getInt("pages");
                    System.out.println(
                            "MYSQL RESPONSE ->                            \n" +
                                    "ID            : " + id + ",           \n" +
                                    "TITLE         : " + title + ",         \n" +
                                    "First Name    : " + author_fname + ",   \n" +
                                    "Last Name     : " + author_lname + ",    \n" +
                                    "Released Year : " + released_year + ",    \n" +
                                    "Stock Quantity: " + stock_quantity + ",    \n" +
                                    "pages         : " + pages
                    );
                }
                if (result) {
                    System.out.println("Query executed successfully");
                } else {
                    System.out.println("Query failed to execute");
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
            System.out.println("Thank you for using FINDBYID, Goodbye!");
        }
    }
}