package com.initial;

import java.sql.*;
public class Main {
    public static void main(String[] args) throws SQLException {
        SelectAllExample sample = new SelectAllExample();
        sample.printBooksDetails();
    }
}