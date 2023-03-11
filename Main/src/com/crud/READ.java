package com.crud;

import com.database.Database;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class READ {

    private boolean admin;
    private boolean user;
    private boolean isPassword;
    private String getUsername;
    private String getPassword;
    private String getFirstName;
    private String getLastName;
    private String getEmail;
    private String ID;

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isUser() {
        return user;
    }

    public void setUser(boolean user) {
        this.user = user;
    }

    public boolean isPassword() {
        return isPassword;
    }

    public void setPassword(boolean password) {
        isPassword = password;
    }

    public String getGetUsername() {
        return getUsername;
    }

    public void setGetUsername(String getUsername) {
        this.getUsername = getUsername;
    }

    public String getGetPassword() {
        return getPassword;
    }

    public void setGetPassword(String getPassword) {
        this.getPassword = getPassword;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getGetFirstName() {
        return getFirstName;
    }

    public void setGetFirstName(String getFirstName) {
        this.getFirstName = getFirstName;
    }

    public String getGetLastName() {
        return getLastName;
    }

    public void setGetLastName(String getLastName) {
        this.getLastName = getLastName;
    }

    public String getGetEmail() {
        return getEmail;
    }

    public void setGetEmail(String getEmail) {
        this.getEmail = getEmail;
    }

    public void check_admin_or_user(String username, String password) {
        try {
            Connection c = Database.getConnectionLibrary();
            Statement  s = c.createStatement();
            String     q = "SELECT * FROM users WHERE USERNAME = '" + username + "' AND PASSWORD ='" + password + "'";
            PreparedStatement pr = c.prepareStatement(q);
            ResultSet rs = pr.executeQuery();

            resetUserAdminPassword();
            while (rs.next()) {
                if (username.equals(rs.getString("USERNAME")) &&
                        password.equals(rs.getString("PASSWORD"))
                ) {
                    setGetUsername(rs.getString("USERNAME"));
                    setGetPassword(rs.getString("PASSWORD"));
                    setGetFirstName(rs.getString("FNAME"));
                    setGetLastName(rs.getString("LNAME"));
                    setGetEmail(rs.getString("EMAIL"));

                    setUser(true);
                    setPassword(true);
                    if (rs.getString("USERNAME").equals("admin")) {
                        setUser(false);
                        setAdmin(true);
                    }
                    setID(rs.getString("UID"));
                    break;
                }
                else {
                    if (username.equals(rs.getString("USERNAME")) &&
                            !password.equals(rs.getString("PASSWORD"))) {
                        setPassword(false);
                    }
                    else if (!username.equals(rs.getString("USERNAME")) &&
                            !password.equals(rs.getString("PASSWORD"))) {
                        setPassword(false);
                    }
                }

            }
            c.close();
            s.close();
            rs.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void resetUserAdminPassword() {
        setPassword(false);
        setAdmin(false);
        setUser(false);
    }

    public DefaultTableModel booksDTM = new DefaultTableModel();

    public DefaultTableModel getUsersBooksDTM() {
        return usersBooksDTM;
    }

    public void setUsersBooksDTM(DefaultTableModel usersBooksDTM) {
        this.usersBooksDTM = usersBooksDTM;
    }

    public void showBooks() {
        try {
            Connection c = Database.getConnectionLibrary();
            Statement  s = c.createStatement();
            String     q = "SELECT * FROM books";
            PreparedStatement ps = c.prepareStatement(q, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            rs.last();
            int numRow = rs.getRow();
            rs.beforeFirst();
            int row = 0;
            String[] headerBooks = {
                    "ID",
                    "NAME",
                    "GENRE",
                    "PRICE"
            };
            String[][] dataBooks = new String[numRow][4];
            while (rs.next()) {
                dataBooks[row][0] = (rs.getString("BID"));
                dataBooks[row][1] = (rs.getString("BNAME"));
                dataBooks[row][2] = (rs.getString("GENRE"));
                dataBooks[row][3] = (rs.getString("PRICE"));
                row++;
            }
            setBooksDTM(new DefaultTableModel(dataBooks, headerBooks));
            rs.close();
            s.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public DefaultTableModel borrowedBooksDTM = new DefaultTableModel();

    public DefaultTableModel getBorrowedBooksDTM() {
        return borrowedBooksDTM;
    }

    public void setBorrowedBooksDTM(DefaultTableModel borrowedBooksDTM) {
        this.borrowedBooksDTM = borrowedBooksDTM;
    }

    public void userBorrowedBooks(String UID) {
        try {
            Connection c = Database.getConnectionLibrary();
            Statement  s = c.createStatement();
            String     q = "SELECT `IID`,`RETURN_DATE`,`ISSUED_DATE`,`PERIOD` FROM `issued` WHERE `UID`="+UID+" AND "+ "`RETURN_DATE`= ''";
            PreparedStatement ps = c.prepareStatement(q,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            rs.last();
            int numRow = rs.getRow();
            rs.beforeFirst();
            int row = 0;
            String[] headerBooks = {
                    "IID",
                    "ISSUED_DATE",
                    "PERIOD"
            };
            String[][] dataBooks = new String[numRow][3];
            while (rs.next()) {
                dataBooks[row][0] = (rs.getString("IID"));
                dataBooks[row][1] = (rs.getString("ISSUED_DATE"));
                dataBooks[row][2] = (rs.getString("PERIOD"));
                row++;
            }
            setBorrowedBooksDTM(new DefaultTableModel(dataBooks,headerBooks));
            rs.close();
            s.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DefaultTableModel usersBooksDTM = new DefaultTableModel();

    public DefaultTableModel getBooksDTM() {
        return usersBooksDTM;
    }

    public void setBooksDTM(DefaultTableModel booksDTM) {
        this.usersBooksDTM = booksDTM;
    }
    public DefaultTableModel listUsersDTM = new DefaultTableModel();

    public DefaultTableModel getListUsersDTM() {
        return listUsersDTM;
    }

    public void setListUsersDTM(DefaultTableModel listUsersDTM) {
        this.listUsersDTM = listUsersDTM;
    }

    public void usersBooks(String UID) throws SQLException {
        try {
            Connection c = Database.getConnectionLibrary();
            Statement  s = c.createStatement();
            String     q = "SELECT * FROM ISSUED WHERE UID = " + UID;
            PreparedStatement ps = c.prepareStatement(q, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            rs.last();
            int numRow = rs.getRow();
            rs.beforeFirst();
            int row = 0;
            String[] headerBooks = {
                    "IID",
                    "ISSUED_DATE",
                    "PERIOD"
            };
            String[][] dataBooks = new String[numRow][3];
            System.out.println("OUTSIDE");
            while (rs.next()) {
                System.out.println("INSIDE");
                dataBooks[row][0] = (String.valueOf(rs.getInt("IID")));
                dataBooks[row][1] = (String.valueOf(rs.getString("ISSUED_DATE")));
                dataBooks[row][2] = (String.valueOf(rs.getInt("PERIOD")));
                row++;
            }
            for (int out = 0; out < dataBooks.length; out++) {
                for (int ins = 0; ins < dataBooks[out].length; ins++) {
                    System.out.println(dataBooks[out][ins]);
                }
            }
            setUsersBooksDTM(new DefaultTableModel(dataBooks, headerBooks));
            rs.close();
            s.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showUsers() {
        try {
            Connection c = Database.getConnectionLibrary();
            Statement  s = c.createStatement();
            String     q = "SELECT * FROM users";
            PreparedStatement ps = c.prepareStatement(q, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            rs.last();
            int numRow = rs.getRow();
            int row = 0;
            rs.beforeFirst();

            String[] headerBooks = {
                    "UID",
                    "USERNAME",
                    "FNAME",
                    "LNAME",
                    "EMAIL",
            };
            String[][] dataBooks = new String[numRow][5];
            while (rs.next()) {
                if (rs.getString("USERNAME").equals("admin")) {
                    continue;
                }
                dataBooks[row][0] = (rs.getString("UID"));
                dataBooks[row][1] = (rs.getString("USERNAME"));
                dataBooks[row][2] = (rs.getString("FNAME"));
                dataBooks[row][3] = (rs.getString("LNAME"));
                dataBooks[row][4] = (rs.getString("EMAIL"));
                row++;
            }
            setListUsersDTM(new DefaultTableModel(dataBooks, headerBooks));

            rs.close();
            s.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private DefaultTableModel issuedBooksDTM;

    public DefaultTableModel getIssuedBooksDTM() {
        return issuedBooksDTM;
    }

    public void setIssuedBooksDTM(DefaultTableModel issuedBooksDTM) {
        this.issuedBooksDTM = issuedBooksDTM;
    }

    public void showIssuedBooks() throws SQLException, ClassNotFoundException, ParseException {
        Connection c = Database.getConnectionLibrary();
        String     q = "SELECT * FROM issued";
        PreparedStatement ps = c.prepareStatement(q, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = ps.executeQuery();
        rs.last();
        int row = 0;
        int numRow = rs.getRow();
        String[] header = {
                "IID",
                "BID",
                "UID",
                "ISSUED_DATE",
                "RETURN_DATE",
                "PERIOD",
                "FINE"
        };
        String[][] data = new String[numRow][7];
        rs.beforeFirst();
        while (rs.next()) {
            data[row][0] = String.valueOf(rs.getInt("IID"));
            data[row][1] = String.valueOf(rs.getInt("BID"));
            data[row][2] = String.valueOf(rs.getInt("UID"));
            data[row][3] = rs.getString("ISSUED_DATE");
            data[row][4] = rs.getString("RETURN_DATE");
            data[row][5] = rs.getString("PERIOD");
            data[row][6] = String.valueOf(rs.getInt("FINE"));
            row++;
        }
        setIssuedBooksDTM(new DefaultTableModel(data, header));
        c.close();
        rs.close();
    }
    public double calculateFine(int period, String rtrnDate, String issuedDate) throws ParseException {
        //  Parse the date strings into Date objects
        Date issued = new SimpleDateFormat("MM-dd-yyyy").parse(issuedDate);
        Date rtrn = new SimpleDateFormat("MM-dd-yyyy").parse(rtrnDate);
        int periodToMilleseconds = period * 24 * 60 * 60 * 1000;
        //  Calculate the difference between the return date and the issued date in milliseconds
        long timeDifference = Math.abs(rtrn.getTime() - issued.getTime());
        long diffRtrnAndIssuedToDay = Math.abs((timeDifference - periodToMilleseconds) / 1000 / 60 / 60 / 24);
        //  Initialize the fine to 0
        double fine = 0d;
        //
        if (timeDifference > periodToMilleseconds) {
            double finePerDay = 5;
            //calculate the new value to theFine
            fine = Math.abs(finePerDay *
                    (diffRtrnAndIssuedToDay));
            return fine;
        } else {
            return fine;
        }
    }
    public String getCurrentDate() {
        // Get the current date
        LocalDate currentDate = LocalDate.now();
        // Define the date format
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        // Format the current date using the defined format
        String formattedDate = currentDate.format(dateFormat);
        return formattedDate;
    }
}
class asdf{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        READ r = new READ();
        CREATE c = new CREATE();
//        r.userBorrowedBooks("10","");
//        c.issueBook("10","1","03-10-2023","10");
        r.showBooks();
    }
}