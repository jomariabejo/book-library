import java.sql.*;
public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/books";
        String username = "root";
        String password = "";

        Connection con = DriverManager.getConnection(url, username, password);
        if (con != null) {
            System.out.println("Connection established");
        } else {
            System.out.println("Failed to make connection");
        }


    }
}
