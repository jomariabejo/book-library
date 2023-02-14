package com.database;
import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    /*
     *  Get Database of Books
     */
    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books","root","");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
