package com.initial;

import java.sql.*;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws SQLException {
        CRUD sample = new CRUD();
        sample.printBooksDetails();
        sample.INSERT("Clean Code: A Handbook of Agile Software Craftsmanship","Robert Cecil","Martin","2008","100","464");
        sample.FindByID("1");
        sample.FindByID("50");


    }
}