package com.initial;

import java.sql.*;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws SQLException {
        CRUD sample = new CRUD();
        CreateBook createBook = new CreateBook();
        ReadBook   readBook   = new ReadBook();
        UpdateBook updateBook = new UpdateBook();
        DeleteBook deleteBook = new DeleteBook();
    }
}