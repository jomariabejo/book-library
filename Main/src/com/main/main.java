package com.main;
import  com.Admin.*;
import  com.Users.*;
import  com.create.CREATE;
import  com.delete.DELETE;
import  com.read.READ;
import  com.update.UPDATE;
import  java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException {

    /*
        SQL METHODS
            CREATE
            READ
            UPDATE
            DELETE
    */
        CREATE create = new CREATE();
        READ     read = new READ();
        UPDATE update = new UPDATE();
        DELETE delete = new DELETE();

    /*
        GRAPHICAL USER INTERFACE
    */
        Admin admin = new Admin();
        Users users = new Users();

        admin.greeting("Jomari Abejo");
    }
}
