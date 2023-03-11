package com.crud;

import com.database.Database;

import java.sql.*;

public class CREATE {

    private String username, password, secret_recovery_phrase;
    private boolean duplicate;

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
        return duplicate;
    }

    public void setDuplicate(boolean duplicate) {
        this.duplicate = duplicate;
    }

    public void reset_duplicate_password_phrase() {
        setDuplicate(false);
        setPassword("");
        setUsername("");
        setSecret_recovery_phrase("");
    }

    public void insert_user(String username, String password, String secret_recovery_phrase, String fname, String lname, String email) {
        try {
            Connection c = Database.getConnectionLibrary();
            System.out.println(c);
            Statement s = c.createStatement();
            String q = "INSERT INTO `users`(`USERNAME`, `PASSWORD`, `secretRecoveryPhrase`, `FNAME`, `LNAME`, `EMAIL`) VALUES " +
                    "('" + username + "'" +
                    "," +
                    "'" + password + "'" +
                    "," +
                    "'" + secret_recovery_phrase + "'" +
                    "," +
                    "'" + fname + "'" +
                    "," +
                    "'" + lname + "'" +
                    "," +
                    "'" + email + "'" + ")";
            PreparedStatement ps = c.prepareStatement(q);
            ps.execute();
            s.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            if (e.getMessage().equals("Duplicate entry '" + username + "' for key 'USERNAME'")) {
                setDuplicate(true);
            } else setDuplicate(false);
        }
    }
    public void createUser(String uname, String fname, String lname, String email) {
        try {
            Connection c = Database.getConnectionLibrary();
            Statement  s = c.createStatement();
            String     q = "INSERT INTO `users`(`USERNAME`,`FNAME`, `LNAME`, `PASSWORD` ,`EMAIL`) VALUES " +
                    "('" + uname + "'" +
                    "," +
                    "'" + fname + "'" +
                    "," +
                    "'" + lname + "'" +
                    "," +
                    "'" + "" + "'" +
                    "," +
                    "'" + email + "'" + ")";

            PreparedStatement ps = c.prepareStatement(    q);
            ps.execute();
            s.close();
            c.close();
        } catch (Exception e) {
            if (e.getMessage().equals("Duplicate entry '" + username + "' for key 'USERNAME'")) {
                setDuplicate(true);
            } else setDuplicate(false);
        }
    }
    public void addNewBook(String bname, String genre, String price) {
        try {
            System.out.println("Executing AddNewBook()");
            Connection connection = Database.getConnectionLibrary();
            Statement statement = connection.createStatement();
            String query = "INSERT INTO `books`(`BNAME`, `GENRE`, `PRICE`) VALUES " +
                    "('" + bname + "'" +
                    "," +
                    "'" + genre + "'" +
                    "," +
                    "'" + price + "'" + ")";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void issueBook(String UID, String BID, String ISSUED_DATE, String PERIOD) throws SQLException, ClassNotFoundException {
        try {

            Connection c = Database.getConnectionLibrary();
            String str = "INSERT INTO `issued`(`UID`, `BID`, `ISSUED_DATE`,`RETURN_DATE`,`FINE`, `PERIOD`) VALUES " +
                    "('" + UID + "'" +
                    "," +
                    "'" + BID + "'" +
                    "," +
                    "'" + ISSUED_DATE + "'" +
                    "," +
                    "'" + "" + "'" +
                    "," +
                    "'" + 0 + "'" +
                    "," +
                    "'" + PERIOD + "'" + ")";
            PreparedStatement ps = c.prepareStatement(str);
            ps.execute();
            ps.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void insertAdmin() throws SQLException, ClassNotFoundException {
        try {
            Connection c = Database.getConnectionLibrary();
            //        ALTER TABLE tablename AUTO_INCREMENT = value;
            String q = "INSERT INTO " +
                    "`users`(`USERNAME`, `PASSWORD`, `FNAME`,`LNAME`,`EMAIL`,`secretRecoveryPhrase`) VALUES ('admin','admin','admin','admin','admin@gmail.com','useradmin'" + ")";
            PreparedStatement ps = c.prepareStatement(q);
            System.out.println(q);
            ps.execute();
            ps.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}