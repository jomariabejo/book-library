package com.read;
import com.database.*;
import java.sql.*;
public class READ {

    public void printBooks() throws SQLException {
        try {
            System.out.println("calling db ->>"+Database.getConnection());
            Connection conn      = Database.getConnection();
            System.out.println(conn);
            Statement stmt       = conn.createStatement();
            String query         = "SELECT * FROM books1_0";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs         = ps.executeQuery();
            boolean result       = stmt.execute(query);

            while (rs.next()){
                System.out.println(rs.getString("title"));
            }
            rs.  close();
            stmt.close();
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
