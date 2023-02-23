package com.main.database;
import java.sql.*;

public class Database {
    /*
     *  Get database of Books
     */
    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
    public static Connection getConnectionLibrary(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
}

class testdb{
    public static void main(String[] args) {
        Database.getConnection();
        Database.getConnectionLibrary();
    }
}
