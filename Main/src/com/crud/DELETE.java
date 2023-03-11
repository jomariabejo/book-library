package com.crud;

import com.database.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DELETE {
    public void BOOKS() throws SQLException, ClassNotFoundException {
        Connection c = Database.getConnectionLibrary();
        Statement s = c.createStatement();
        s.executeUpdate("DELETE FROM books");
        s.execute("ALTER TABLE books  AUTO_INCREMENT = 0;");
        c.close();
        s.close();
    }
    public void ISSUED() throws SQLException, ClassNotFoundException {
        Connection c = Database.getConnectionLibrary();
        Statement s = c.createStatement();
        s.executeUpdate("DELETE FROM issued");
        s.execute("ALTER TABLE issued AUTO_INCREMENT = 0;");
        c.close();
        s.close();
    }

    public void USERS() throws SQLException, ClassNotFoundException {
        Connection c = Database.getConnectionLibrary();
        Statement s = c.createStatement();
        s.executeUpdate("DELETE FROM users");
        s.execute("ALTER TABLE users  AUTO_INCREMENT = 0;");
        c.close();
        s.close();
    }
}