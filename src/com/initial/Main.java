package com.initial;

import com.initial.GUI_LoginandRegister.Login;
import com.initial.GUI_LoginandRegister.Register;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Create create = new Create();
        Read   read   = new Read();
        Update update = new Update();
        Delete delete = new Delete();
        Login login = new Login();
    }
}