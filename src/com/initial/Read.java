package com.initial;

import java.sql.*;

public class Read {
    static Connection conn = null;
    static Statement stmt = null;
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/books";

    static final String USER = "root";
    static final String PASS = "";

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getDate() {
        return date;
    }

    public String getPassword() {
        return password;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // TO update profiles we need to get the data of user after it logged in, so basically
    // if the user click the profile, what will happen is that the labels their
    // will be updated to the user information...
    public int id;
    public String username, firstname, lastname, email, date, password;

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    private boolean admin = false;

    public void FindBookByTitle(String title_input) {
        {

            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                String query = "SELECT * FROM books1_0 WHERE title = '" + title_input + "'";
                PreparedStatement sql_start = conn.prepareStatement(query);
                ResultSet rs = sql_start.executeQuery();
                boolean result = stmt.execute(query);


                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    String author_fname = rs.getString("author_fname");
                    String author_lname = rs.getString("author_lname");
                    int released_year = rs.getInt("released_year");
                    int stock_quantity = rs.getInt("stock_quantity");
                    int pages = rs.getInt("pages");
                    System.out.println(
                            "MYSQL RESPONSE ->                            \n" +
                                    "ID            : " + id + ",           \n" +
                                    "TITLE         : " + title + ",         \n" +
                                    "First Name    : " + author_fname + ",   \n" +
                                    "Last Name     : " + author_lname + ",    \n" +
                                    "Released Year : " + released_year + ",    \n" +
                                    "Stock Quantity: " + stock_quantity + ",    \n" +
                                    "pages         : " + pages
                    );
                }
                if (result) {
                    System.out.println("Query executed successfully");
                } else {
                    System.out.println("Query failed to execute");
                }
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception se) {
                se.printStackTrace();
            } finally {
                try {
                    if (stmt != null) stmt.close();
                } catch (SQLException ignored) {}
                try {
                    if (conn != null) conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
            System.out.println("FindBookByTitle called...");
        }
    }
    public void FindBookByID(String ID) {
        {
            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                String query = "SELECT * FROM books1_0 WHERE id = " + ID;
                PreparedStatement sql_start = conn.prepareStatement(query);
                ResultSet rs = sql_start.executeQuery();
                boolean result = stmt.execute(query);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    String author_fname = rs.getString("author_fname");
                    String author_lname = rs.getString("author_lname");
                    int released_year = rs.getInt("released_year");
                    int stock_quantity = rs.getInt("stock_quantity");
                    int pages = rs.getInt("pages");

                }
                if (result) {
                    System.out.println("Query executed successfully");
                } else {
                    System.out.println("Query failed to execute");
                }
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception se) {
                se.printStackTrace();
            } finally {
                try {
                    if (stmt != null) stmt.close();
                } catch (SQLException ignored) {}
                try {
                    if (conn != null) conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
            System.out.println("FindBookByID called...");
        }
    }
    public void FindBookByAuthorFullName(String f_name, String l_name) {
        {
            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                String query = "SELECT * FROM books1_0 WHERE author_fname = '" + f_name+"' AND author_lname = '" + l_name+"'";
                PreparedStatement sql_start = conn.prepareStatement(query);
                ResultSet rs = sql_start.executeQuery();
                boolean result = stmt.execute(query);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    String author_fname = rs.getString("author_fname");
                    String author_lname = rs.getString("author_lname");
                    int released_year = rs.getInt("released_year");
                    int stock_quantity = rs.getInt("stock_quantity");
                    int pages = rs.getInt("pages");
                    System.out.println(
                            "MYSQL RESPONSE ->                            \n" +
                                    "ID            : " + id + ",           \n" +
                                    "TITLE         : " + title + ",         \n" +
                                    "First Name    : " + author_fname + ",   \n" +
                                    "Last Name     : " + author_lname + ",    \n" +
                                    "Released Year : " + released_year + ",    \n" +
                                    "Stock Quantity: " + stock_quantity + ",    \n" +
                                    "pages         : " + pages
                    );
                }
                if (result) {
                    System.out.println("Query executed successfully");
                } else {
                    System.out.println("Query failed to execute");
                }
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception se) {
                se.printStackTrace();
            } finally {
                try {
                    if (stmt != null) stmt.close();
                } catch (SQLException ignored) {}
                try {
                    if (conn != null) conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
            System.out.println("FindBookByAuthorFullName called...");
        }
    }
    public String FindUser(String username, String password) throws ClassNotFoundException, SQLException {
        {
            String resultConcat="";
            try {
//                Class.forName(JDBC_DRIVER);
//                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                conn = DBConnection.getConnection();
                stmt = conn.createStatement();
                String query = "SELECT username FROM users WHERE username = '" + username+"' AND password = '" + password+"'";
//                SELECT * FROM books1_0 WHERE username = 'jomariabejo' AND authorlname = 'helloworld';

                PreparedStatement sql_start = conn.prepareStatement(query);
                ResultSet rs = sql_start.executeQuery();
                boolean result = stmt.execute(query);
                while (rs.next()) {
                    resultConcat = rs.getString("username");
                }
                if (resultConcat.equals("user")){
                    System.out.println("it is the admin");
                    this.setAdmin(true);
                }
                else {
                    System.out.println("Not admin");
                    this.setAdmin(false);
                }
                if (result) {
                    System.out.println("Query executed successfully");
                } else {
                    System.out.println("Query failed to execute");
                }
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception se) {
                se.printStackTrace();
            } finally {
                try {
                    if (stmt != null) stmt.close();
                } catch (SQLException ignored) {
                }
                try {
                    if (conn != null) conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
            System.out.println("FindBookByAuthorFullName called...");
            if (resultConcat==null) resultConcat="!FOUND";
            else resultConcat = "FOUND";
            return resultConcat;
        }
    }
    public void setAccount(String input_username) {
        {
            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                String query = "SELECT * FROM users WHERE username = '" + input_username+"'";
                PreparedStatement sql_start = conn.prepareStatement(query);
                ResultSet rs = sql_start.executeQuery();
                boolean result = stmt.execute(query);
                while (rs.next()) {
                    // 02/06/2023
                    int id = rs.getInt("id");
                    String username = rs.getString("username");
                    String firstname= rs.getString("firstname");
                    String lastname = rs.getString("lastname");
                    String email    = rs.getString("email");
                    String date     = rs.getString("date");
                    String password = rs.getString("password");

                    setId(id);
                    setUsername(username);
                    setFirstname(firstname);
                    setLastname(lastname);
                    setEmail(email);
                    setDate(date);
                    setPassword(password);
                }

                if (result) {
                    System.out.println("Query executed successfully");
                } else {
                    System.out.println("Query failed to execute");
                }
                rs.close();
                stmt.close();
                conn.close();
            }
            catch (Exception se) {
                se.printStackTrace();
            }
            finally {
                try {
                    if (stmt != null) stmt.close();
                }

                catch (SQLException ignored) {}
                try {
                    if (conn != null) conn.close();
                }
                catch (SQLException se) {
                    se.printStackTrace();
                }
            }
            System.out.println("SetAccount called...");
        }
    }
    public void getAccount() {
        System.out.println("ID          = " + getId());
        System.out.println("Username    = " + getUsername());
        System.out.println("First Name  = " + getFirstname());
        System.out.println("Last Name   = " + getLastname());
        System.out.println("Email       = " + getEmail());
        System.out.println("Date Joined = " + getDate());
    }


    public String [][] globalVariable = null;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Read read = new Read();
//        read.FindBookByTitle("Boruto");
//        FindUser("jomariabejo","helloworld");
        read.FindUser("user","admin");
        read.FindUser("","");

    }

    public static class DBConnection {
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
}
class tesst{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Read rd = new Read();
        rd.FindUser("jomariabejo","helloworld");
    }
}