package com.crud;

import com.main.database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CREATE {

    private String username, password, secret_recovery_phrase;
    private boolean isDuplicate;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecret_recovery_phrase() {
        return secret_recovery_phrase;
    }

    public void setSecret_recovery_phrase(String secret_recovery_phrase) {
        this.secret_recovery_phrase = secret_recovery_phrase;
    }

    public boolean isDuplicate() {
        return isDuplicate;
    }

    public void setDuplicate(boolean duplicate) {
        isDuplicate = duplicate;
    }

    public void reset_duplicate_password_phrase(){
        setDuplicate(false);
        setPassword("");
        setUsername("");
        setSecret_recovery_phrase("");
    }

    public void insert_user(String username, String password, String secret_recovery_phrase, String fname, String lname, String email){
        try {
            System.out.println("calling db ->>" + Database.getConnectionLibrary());
            Connection conn = Database.getConnectionLibrary();
            System.out.println(conn);
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO `users`(`USERNAME`, `PASSWORD`, `secretRecoveryPhrase`, `FNAME`, `LNAME`, `EMAIL`) VALUES " +
                    "('" + username              + "'"+
                    "," +
                    "'" + password               + "'"+
                    "," +
                    "'" + secret_recovery_phrase + "'"+
                    "," +
                    "'" + fname                  + "'"+
                    "," +
                    "'" + lname                  + "'"+
                    "," +
                    "'" + email                  +"'"+")";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            if (e.getMessage().equals("Duplicate entry '"+username+"' for key 'USERNAME'"
            )){
                setDuplicate(true);
            }
            else setDuplicate(false);
        }
    }
    public void admin_create_user(String uname, String fname, String lname, String email){
        try {
            System.out.println("calling db ->>" + Database.getConnectionLibrary());
            Connection conn = Database.getConnectionLibrary();
            System.out.println(conn);
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO `users`(`USERNAME`,`FNAME`, `LNAME`, `EMAIL`) VALUES " +
                    "('" + uname              + "'"+
                    "," +
                    "'" + fname                  + "'"+
                    "," +
                    "'" + lname                  + "'"+
                    "," +
                    "'" + email                  +"'"+")";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            if (e.getMessage().equals("Duplicate entry '"+username+"' for key 'USERNAME'"
            )){
                setDuplicate(true);
            }
            else setDuplicate(false);
        }
    }
    public void addNewBook(String bname, String genre, String price) {
        try{
            System.out.println("Executing AddNewBook()");
            Connection connection = Database.getConnectionLibrary();
            Statement statement   = connection.createStatement();
            String query = "INSERT INTO `books`(`BNAME`, `GENRE`, `PRICE`) VALUES " +
                    "('" + bname+ "'"+
                    "," +
                    "'" + genre + "'"+
                    "," +
                    "'" + price +"'"+")";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.execute();
            statement.close();
            connection.close();
            System.out.println("Green");
        }
        catch (Exception e){
            System.out.println("Red");
            System.out.println(e.getMessage());
        }
    }
}