package com.crud;

import com.database.Database;

import java.sql.*;
import java.text.ParseException;

public class UPDATE {
    READ r = new READ();
    private String UPDATE_PROCESS;

    public String getUPDATE_PROCESS() {
        return UPDATE_PROCESS;
    }

    public void setUPDATE_PROCESS(String UPDATE_PROCESS) {
        this.UPDATE_PROCESS = UPDATE_PROCESS;
    }

    public void UPDATE_USERPROFILE(String old_username, String n_username, String n_password, String fname, String lname, String email) throws SQLException {

        try {

            Connection conn = Database.getConnectionLibrary();
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
    public void UPDATE_RETURNBOOKDATE(String ISSUED_ID, String RETURN_DATE) throws SQLException, ClassNotFoundException {
        Connection c = Database.getConnectionLibrary();
        Statement s = c.createStatement();
        String updateReturnBookDate = "UPDATE `issued` SET " +
                "`RETURN_DATE` = '" + RETURN_DATE + "' WHERE IID = " + ISSUED_ID;
        s.executeUpdate(updateReturnBookDate);
        System.out.println(updateReturnBookDate);
    }
    public void UPDATE_FINE(String IID) throws SQLException, ClassNotFoundException, ParseException {
        Connection c = Database.getConnectionLibrary();
        String q1 = "SELECT * FROM ISSUED WHERE IID = '" + IID + "'";
        PreparedStatement ps = c.prepareStatement(q1);
        ResultSet rs = ps.executeQuery();
        String issuedDate = "", returnDate = "";
        int period = 0;
        while (rs.next()) {
            issuedDate = rs.getString("ISSUED_DATE");
            returnDate = rs.getString("RETURN_DATE");
            period = rs.getInt("PERIOD");
        }
        //  Execute the fine
        double fine = r.calculateFine(period, returnDate, issuedDate);
        String q2 = "UPDATE `issued` SET `FINE` = '" + fine + "' WHERE IID = '" + IID + "'";
        ps.executeUpdate(q2);
        System.out.println("1 -> " + issuedDate);
        System.out.println("2 -> " + returnDate);
        System.out.println("3 -> " + period);
        System.out.println("4 -> " + fine);
    }
    private final String resetPasswordMsg = "";

    public String getResetPasswordMsg() {
        return resetPasswordMsg;
    }

    private String resetpasswordMessage = "";

    public String getResetpasswordMessage() {
        return resetpasswordMessage;
    }

    public void setResetpasswordMessage(String resetpasswordMessage) {
        this.resetpasswordMessage = resetpasswordMessage;
    }

    public void resetpassword(String username, String secret_phrase) throws SQLException, ClassNotFoundException {
        Connection c = Database.getConnectionLibrary();
        Statement  s = c.createStatement();
        String     q = "SELECT USERNAME, secretRecoveryPhrase FROM `users`";
        PreparedStatement ps = c.prepareStatement(q);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            if (username.equals(rs.getString("USERNAME")) &&
                    secret_phrase.equals(rs.getString("secretRecoveryPhrase"))) {
                setResetpasswordMessage("Password has been reset, plase go to your profile and set the new password");
                s.executeUpdate("UPDATE `users` SET `PASSWORD`='' WHERE `USERNAME`= '" + username + "'");
            }
            if (!username.equals(rs.getString("USERNAME")) ||
                    !secret_phrase.equals(rs.getString("secretRecoveryPhrase"))){
                setResetpasswordMessage("username and secretphrase doesn't exist.");
            }
        }
        System.out.println(getResetpasswordMessage());
        c.close();
        s.close();
    }
}
class masdl{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UPDATE u = new UPDATE();
        u.resetpassword("jomsarabe","nothinglastforeverwecanchangethefuture");
    }
}