package com.main;
import com.Admin.*;
import com.Users.*;
import com.create.CREATE;
import com.delete.DELETE;
import com.read.READ;
import com.update.UPDATE;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Type;
import java.sql.SQLException;

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
        READ   read = new READ();
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

                read.check_admin_or_user(username, password);

                if (read.isAdmin()) {
                    JOptionPane.showMessageDialog(login.getPanelMain(), "Welcome back admin");
                    admin_homepage.setVisible(true);
                    login.dispose();
                } else if (read.isUser()) {
                    JOptionPane.showMessageDialog(login.getPanelMain(), "Welcome back " + username);
                    users_homepage.setVisible(true);
                    login.dispose();
                } else {
                    JOptionPane.showMessageDialog(login.getPanelMain(), "The username you entered isn’t connected to an account.");
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
                if (e.getKeyCode() == 0) {
                    System.out.println("Login Pressed");

                    String username = login.getTxtField_username().getText();
                    String password = String.valueOf(login.getPwdField_password().getPassword());

                    read.check_admin_or_user(username, password);

                    if (login.getTxtField_username().equals("") ||
                            login.getPwdField_password().getPassword().equals("")) {
                        JOptionPane.showMessageDialog(login.getPanelMain(), "Ensure that every field has a value.");
                    }
                    if (read.isAdmin()) {
                        JOptionPane.showMessageDialog(login.getPanelMain(), "Welcome back admin");
                        admin_homepage.setVisible(true);
                        login.dispose();
                    }
                    else if (read.isUser()) {
                        JOptionPane.showMessageDialog(login.getPanelMain(), "Welcome back " + username);
                        users_homepage.setVisible(true);
                        login.dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(login.getPanelMain(), "The username you entered isn’t connected to an account.");
                        login.getTxtField_username().setText("");
                        login.getPwdField_password().setText("");
                    }
                }
            }
        });
        login.getBtn_register().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyCode() == 0) {
                    System.out.println("Register Pressed");
                    register.setVisible(true);
                    login.dispose();
                }
            }
        });

        /*
            LOGIN GUI END
         */





        /*
            REGISTER GUI START
         */


        register.getBtn_register().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Register Clicked");
                String username, password, recovery_phrase;

                username = register.getTxtField_username().getText();
                password = String.valueOf(register.getPwdField_password_confirm().getPassword());
                recovery_phrase = String.valueOf(register.getPwdField_recoveryphrase().getPassword());

                create.insert_user(register.getTxtField_username().getText(),
                        String.valueOf(register.getPwdField_password_confirm().getPassword()),
                        String.valueOf(register.getPwdField_recoveryphrase().getPassword()));

                if (register.getTxtField_username().getText().equals("") ||
                        String.valueOf(register.getPwdField_recoveryphrase().getPassword()).equals("") ||
                        String.valueOf(register.getPwdField_password_confirm().getPassword()).equals("")
                ) {
                    JOptionPane.showMessageDialog(register.getPanelMain(), "Fill in the fields");
                }

                if (!register.getTxtField_username().getText().equals("") &&
                        !String.valueOf(register.getPwdField_password_confirm().getPassword()).equals("") &&
                        !String.valueOf(register.getPwdField_recoveryphrase().getPassword()).equals("")) {

                    if (String.valueOf(register.getPwdField_password_confirm().getPassword()).
                            equals(String.valueOf(register.getPwdField_password().getPassword()))) {

                        if (create.isDuplicate() == true) {
                            JOptionPane.showMessageDialog(register.getPanelMain(),
                                    "Account already Exist");
                        }
                        else {
                            JOptionPane.showMessageDialog(register.getPanelMain(),
                                    "Registered Successfully");
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(register.getPanelMain(),
                                "Password and Confirm Password doesn't match");
                    }
                }
                create.reset_duplicate_password_phrase();
            }
        });

        register.getBtn_go_back().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Go back clicked");
                login.setVisible(true);
                register.dispose();
            }
        });

        register.getBtn_register().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                if (e.getKeyCode() == 0) {
                    System.out.println("Register pressed");
                    String username, password, recovery_phrase;

                    username = register.getTxtField_username().getText();
                    password = String.valueOf(register.getPwdField_password_confirm().getPassword());
                    recovery_phrase = String.valueOf(register.getPwdField_recoveryphrase().getPassword());

                    create.insert_user(register.getTxtField_username().getText(),
                            String.valueOf(register.getPwdField_password_confirm().getPassword()),
                            String.valueOf(register.getPwdField_recoveryphrase().getPassword()));

                    if (register.getTxtField_username().getText().equals("") ||
                            String.valueOf(register.getPwdField_recoveryphrase().getPassword()).equals("") ||
                            String.valueOf(register.getPwdField_password_confirm().getPassword()).equals("")
                    ) {
                        JOptionPane.showMessageDialog(register.getPanelMain(), "Fill in the fields");
                    }

                    if (!register.getTxtField_username().getText().equals("") &&
                            !String.valueOf(register.getPwdField_password_confirm().getPassword()).equals("") &&
                            !String.valueOf(register.getPwdField_recoveryphrase().getPassword()).equals("")) {

                        if (String.valueOf(register.getPwdField_password_confirm().getPassword()).
                                equals(String.valueOf(register.getPwdField_password().getPassword()))) {

                            if (create.isDuplicate() == true) {
                                JOptionPane.showMessageDialog(register.getPanelMain(),
                                        "Account already Exist");
                            }
                            else {
                                JOptionPane.showMessageDialog(register.getPanelMain(),
                                        "Registered Successfully");
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(register.getPanelMain(),
                                    "Password and Confirm Password doesn't match");
                        }
                    }
                    create.reset_duplicate_password_phrase();
                }
            }
        });
        register.getBtn_go_back().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                if (e.getKeyCode() == 0) {
                    System.out.println("Go back Clicked");
                    login.setVisible(true);
                    register.dispose();
                }

            }
        });

        /*
            REGISTER GUI END
         */




    }
}
