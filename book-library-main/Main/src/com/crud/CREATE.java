package com.crud;

import com.main.database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public void insert_user(String username, String password, String secret_recovery_phrase){
        try {
            System.out.println("calling db ->>" + Database.getConnection());
            Connection conn = Database.getConnection();
            System.out.println(conn);
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO `users`(`USERNAME`, `PASSWORD`, `secretRecoveryPhrase`) VALUES " +
                    "('" + username + "'"+
                    "," +
                    "'" + password + "'"+
                    "," +
                    "'" + secret_recovery_phrase + "'"+")";
            PreparedStatement ps = conn.prepareStatement(query);
            boolean result = stmt.execute(query);


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
}

class testcreate{
    public static void main(String[] args) {
        CREATE c = new CREATE();
        c.insert_user("testing","helloworld","1234");
        System.out.println(c.isDuplicate());
    }
}
