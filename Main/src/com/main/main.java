package com.main;
import  com.Admin.*;
import  com.Users.*;
import  com.create.CREATE;
import  com.delete.DELETE;
import  com.read.READ;
import  com.update.UPDATE;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Type;
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


        //  LOGIN GUI
        LOGIN login = new LOGIN();
        REGISTER register = new REGISTER();
        FORGOTPASSWORD forgotpassword = new FORGOTPASSWORD();


        //  USERS GUI
        USERS_HOMEPAGE users_homepage = new USERS_HOMEPAGE();


        //  ADMIN GUI
        ADMIN_HOMEPAGE admin_homepage = new ADMIN_HOMEPAGE();


        /*
         * The program will start to login page.
         */

    /*
        LOGIN GUI START
     */

        login.setVisible(true);
        login.getBtn_login().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Login Clicked");

                String username = login.getTxtField_username().getText();
                String password = String.valueOf(login.getPwdField_password().getPassword());

                read.check_admin_or_user(username,password);

                if (read.isAdmin()){
                    JOptionPane.showMessageDialog(login.getPanelMain(),"Welcome back admin");
                    admin_homepage.setVisible(true);
                    login.dispose();
                }
                else if (read.isUser()){
                    JOptionPane.showMessageDialog(login.getPanelMain(),"Welcome back " + username);
                    users_homepage.setVisible(true);
                    login.dispose();
                }
                else if (read.isPassword()){
                    JOptionPane.showMessageDialog(login.getPanelMain(),"Account not found");
                    login.getTxtField_username().setText("");
                    login.getPwdField_password().setText("");
                }
            }
        });
        login.getBtn_register().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Register Clicked");
                register.setVisible(true);
                login.dispose();
            }
        });
        login.getBtn_login().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyCode() == 0){
                    System.out.println("Enter Pressed");
                }
            }
        });
        login.getBtn_register().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyCode() == 0){
                    System.out.println("Enter Pressed");
                }
            }
        });

    /*
        LOGIN GUI END
     */




    /*
        REGISTER GUI END
     */


    /*
        REGISTER GUI END
     */




    }
}
