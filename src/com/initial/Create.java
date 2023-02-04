package com.initial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/books";

    static final String USER = "root";
    static final String PASS = "";
    String title,
            author_fname,
            author_lname,
            released_year,
            stock_quantity,
            pages;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor_fname() {
        return author_fname;
    }

    public void setAuthor_fname(String author_fname) {
        this.author_fname = author_fname;
    }

    public String getAuthor_lname() {
        return author_lname;
    }

    public void setAuthor_lname(String author_lname) {
        this.author_lname = author_lname;
    }

    public String getReleased_year() {
        return released_year;
    }

    public void setReleased_year(String released_year) {
        this.released_year = released_year;
    }

    public String getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(String stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }
    public void InsertBook(){
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String fnal_start = "INSERT INTO `books1_0`(`title`, `author_fname`, `author_lname`, `released_year`, `stock_quantity`, `pages`) ";
            String fnal_end = " VALUES (" + "'" + getTitle() + "'" + ",'" + getAuthor_fname() + "'" + ',' + "'" + getAuthor_lname() + "'" + ",'" + getReleased_year() + "'" + ",'" + getStock_quantity() + "','" + getPages() + "'" + ")";
            String sql = fnal_start + fnal_end;

            int rowsAffected = stmt.executeUpdate(sql);
            System.out.println(rowsAffected + " row(s) affected.");
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally {
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
        System.out.println("Thank you for INSERTING new data, Goodbye!");
    }
    public void resetBooksAttributes(){
        setTitle(null);
        setPages(null);
        setAuthor_lname(null);
        setAuthor_fname(null);
        setPages(null);
        System.out.println("Attributes set to NULL");
    }
}
