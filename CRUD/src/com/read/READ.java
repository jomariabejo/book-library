package com.read;
import com.database.*;
import java.sql.*;
public class READ {

    private boolean isAdmin;
    private boolean isUser;
    private boolean isPassword;

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
            String query = "SELECT username, password, admin FROM users";
            PreparedStatement pr = conn.prepareStatement(query);
            ResultSet rs = pr.executeQuery();
            boolean result = stmt.execute(query);

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
                    setUser(true);
                    setPassword(true);
                    if (rs.getString("USERNAME").equals("admin")) {
                        setUser(false);
                        setAdmin(true);
                        System.out.println("THIS.ADMIN.FOUND");
                    }
                    System.out.println("THIS.USER.FOUND");
                } else {
                    if (username.equals(rs.getString("USERNAME")) &&
                            !password.equals(rs.getString("PASSWORD"))
                    ){
                        System.out.println("USERNAME PASSWORD INCORRECT");
                    }
                    else if(!username.equals(rs.getString("USERNAME")) &&
                            !password.equals(rs.getString("PASSWORD"))){
                        System.out.println("USERNAME DOESN'T EXIST TO DB");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
class testRead {
    public static void main(String[] args) throws SQLException {
        READ r = new READ();
        r.printBooks();
        r.check_admin_or_user("jomariabejo", "helloworld");
    }
}