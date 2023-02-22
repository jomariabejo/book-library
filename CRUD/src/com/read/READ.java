package com.read;

import com.Users.MyBooks;
import com.database.Database;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class READ {

    private boolean isAdmin;
    private boolean isUser;
    private boolean isPassword;
    private String getUsername;
    private String getPassword;
    private int ID;

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isUser() {
        return isUser;
    }

    public void setUser(boolean user) {
        isUser = user;
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void printBooks() throws SQLException {
        try {
            System.out.println("calling db ->>" + Database.getConnection());
            Connection conn = Database.getConnection();
            System.out.println(conn);
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM books";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            boolean result = stmt.execute(query);

            while (rs.next()) {
                System.out.println(rs.getString("BNAME"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void check_admin_or_user(String username, String password) {
        try {
            System.out.println("calling the check_admin_or_user");
            Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
//            String query = "SELECT username, password, admin FROM users";
            String query = "SELECT * FROM users WHERE USERNAME = '"+username+"' AND PASSWORD ='"+ password+"'";
            PreparedStatement pr = conn.prepareStatement(query);
            ResultSet rs = pr.executeQuery();
            boolean result = stmt.execute(query);

            reset_isUser_isAdmin_isPassword();
            while (rs.next()) {
        /*
            Check if USERNAME AND PASSWORD EQUALS TO
            Database USERS TABLE
                IF
                    username == db.users.username
                    &&
                    password == db.users.password
                        setUser  = true
                        setAdmin = false
                        ACCOUNT USER FOUND
                ELSE IF
                    db.users.admin = true
                        setUser  = false
                        setAdmin = true
                        ACCOUNT ADMIN FOUND
                ELSE
                    IF
                        username == db.username
                        and
                        password != db.password
                            setUser  = false
                            setAdmin = false
                    ELSE
                        ACCOUNT NOT FOUND
        */
                if (username.equals(rs.getString("USERNAME")) &&
                        password.equals(rs.getString("PASSWORD"))
                ) {
                    setGetUsername(rs.getString("USERNAME"));
                    setGetPassword(rs.getString("PASSWORD"));
                    setUser(true);
                    setPassword(true);
                    setID(rs.getInt("UID"));
                    if (rs.getString("USERNAME").equals("admin")) {
                        setUser(false);
                        setAdmin(true);
                        System.out.println("THIS.ADMIN.FOUND");
                    }
                    System.out.println("THIS.USER.FOUND");
                } else {
                    if (username.equals(rs.getString("USERNAME")) &&
                            !password.equals(rs.getString("PASSWORD"))) {
                        setPassword(false);
                        System.out.println("USERNAME PASSWORD INCORRECT");
                    } else if (!username.equals(rs.getString("USERNAME")) &&
                            !password.equals(rs.getString("PASSWORD"))) {
                        setPassword(false);
                        System.out.println("USERNAME DOESN'T EXIST TO DB");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void reset_isUser_isAdmin_isPassword(){
        setPassword(false);
        setAdmin(false);
        setUser(false);
    }

    public DefaultTableModel booksDTM = new DefaultTableModel();

    public DefaultTableModel getBooksDTM() {
        return booksDTM;
    }

    public void setBooksDTM(DefaultTableModel booksDTM) {
        this.booksDTM = booksDTM;
    }

    public void showBooks(){
        try {
            System.out.println("calling db ->>" + Database.getConnection());
            Connection conn = Database.getConnection();
            System.out.println(conn);
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM books";
            PreparedStatement ps = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,
            ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            System.out.println(rs.last());
            int numRow = rs.getRow();
            rs.beforeFirst();
            int row = 0;
            String [] headerBooks = {"ID","NAME","GENRE","PRICE"};
            String [][] dataBooks = new String[numRow][4];
            while (rs.next()) {
                dataBooks[row][0] = (rs.getString("BID"));
                dataBooks[row][1] = (rs.getString("BNAME"));
                dataBooks[row][2] = (rs.getString("GENRE"));
                dataBooks[row][3] = (rs.getString("PRICE"));
                row++;
            }
            setBooksDTM(new DefaultTableModel(dataBooks,headerBooks));



            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class testRead {
    public static void main(String[] args) throws SQLException {
        READ r = new READ();
        MyBooks books = new MyBooks();
        r.check_admin_or_user("jomariabejo","helloworld");
        System.out.println(r.getID());
//        r.showBooks();
//        books.getMyBooksTable().setModel(r.getBooksDTM());
//        books.setVisible(true);
//
//        System.out.println(r.dataBooks[0][0]);
//        for (String[] st:
//             r.dataBooks) {
//            System.out.println(st);
//        }
//        DefaultTableModel dtm = new DefaultTableModel(r.dataBooks,r.headerBooks);
//        books.getMyBooksTable().setModel(dtm);
//        books.setVisible(true);
    }
}
