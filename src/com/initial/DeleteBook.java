package com.initial;

import java.sql.*;

public class DeleteBook {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/books";

    static final String USER = "root";
    static final String PASS = "";

    Connection conn = null;
    Statement stmt = null;
    public void ByID(String ID)
    {
        {
            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                String query = "DELETE FROM books1_0 WHERE id = '" + ID +"'";
                stmt.executeUpdate(query);
                stmt.close();
                conn.close();
            }
            catch (Exception se) {
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
            System.out.println("DeleteBook.ByID called...");
        }
    }
}
