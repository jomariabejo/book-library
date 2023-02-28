package com.crud;

import com.main.database.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UPDATE {
    private String UPDATE_PROCESS;

    public String getUPDATE_PROCESS() {
        return UPDATE_PROCESS;
    }

    public void setUPDATE_PROCESS(String UPDATE_PROCESS) {
        this.UPDATE_PROCESS = UPDATE_PROCESS;
    }

    public void UPDATE_USERPROFILE(String old_username, String n_username, String n_password, String fname, String lname, String email) throws SQLException {


        try {

            Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();

            String query = "UPDATE `users` SET " +
                    "`USERNAME`='" + n_username +
                    "',`PASSWORD`='" + n_password +
                    "',`FNAME`='" + fname +
                    "',`LNAME`='" + lname +
                    "',`EMAIL`='" + email +
                    "' WHERE USERNAME ='" + old_username + "'";
            stmt.executeUpdate(query);
            stmt.close();
            conn.close();
            this.UPDATE_PROCESS = "success";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.UPDATE_PROCESS = "failed";
        }
    }
}

class testUps{
    public static void main(String[] args) throws SQLException {
        READ r = new READ();
        UPDATE u = new UPDATE();
        u.UPDATE_USERPROFILE("jjoommaarriiaabbeejjoo","jomariabejo","helloworld","Jomari","Abejo","jomariabejo@gmail.com");
        System.out.println(u.getUPDATE_PROCESS());
    }
}
