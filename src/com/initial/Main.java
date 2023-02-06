package com.initial;

import com.initial.GUI_LoginandRegister.Login;
import com.initial.GUI_LoginandRegister.Profile;
import com.initial.GUI_LoginandRegister.Register;
import com.initial.GUI_LoginandRegister.UserHomepage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Methods
        Create create = new Create();
        Read read = new Read();
        Update update = new Update();
        Delete delete = new Delete();
        //  GUI
        Login login = new Login();
        Register register = new Register();
        Profile profile = new Profile();
        UserHomepage userHomepage = new UserHomepage();

        /*
         *  LOGIN START
         */

        login.pack();
        ImageIcon img = new ImageIcon("C:\\Users\\Prila\\jdbc\\src\\others\\icon.png");
        login.setIconImage(img.getImage());
        login.setContentPane(login.getPanelMain());
        login.setTitle("Jomari Abejo");
        login.setSize(400, 600);
        login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        login.setLocationRelativeTo(null);
        login.setVisible(true);

        login.loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = login.txtField_username.getText();
                String password = String.valueOf(login.txtField_password.getPassword());
                System.out.println("Login Clicked");
                try {
                    Read.FindUser(username, password);
                    if (Read.FindUser(username, password) == "!FOUND") {
                        JOptionPane.showMessageDialog(login.getPanelMain(), "ACCOUNT NOT FOUND");
                    } else {
                        JOptionPane.showMessageDialog(login.getPanelMain(), "ACCOUNT FOUND");
                        Read.setAccount(username);
                        login.setVisible(false);
                        userHomepage.setVisible(true);
                    }
                    System.out.println(Read.FindUser(username, password));
                } catch (ClassNotFoundException | SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        login.registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Register Clicked");
                register.setVisible(true);
                login.dispose();
            }
        });

        /*
         *  LOGIN END
         */









        /*
         *  REGISTER START
         */

        register.registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //All text fields must have values.
                //Passwords must be unique.
                //Check to see if an account exists.
                if (register.username_txtField.getText().equals("") || register.fName_txtField.getText().equals("") || register.lName_txtField.getText().equals("") || register.eMail_txtField.getText().equals("")) {
                    System.out.println("Please fill out all text fields.");
                }
                if (String.valueOf(register.passwordField_password.getPassword()).equals(String.valueOf(register.passwordField_Confirm.getPassword()))){
                    if (!register.username_txtField.getText().equals("") && !register.fName_txtField.getText().equals("") && !register.lName_txtField.getText().equals("") && !register.eMail_txtField.getText().equals("")) {
                        System.out.println("Query Here, Check if duplicated or not");
                    }
                }
                else {
                    System.out.println("The password did not match.");
                }
            }
        });

        register.backToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Back to Login");
                login.setVisible(true);
                register.dispose();
            }
        });

        /*
         *  REGISTER END
         */

    };
}