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
        login.dispose();
        login.setVisible(true);

        login.loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = login.txtField_username.getText();
                String password = String.valueOf(login.txtField_password.getPassword());
                System.out.println("Login Clicked");
                try {
                    Read.FindUser(username, password);
                    if (Read.FindUser(username, password).equals("!FOUND")) {
                        JOptionPane.showMessageDialog(login.getPanelMain(), "Login Failed");
                    }
                    if (Read.FindUser(username, password).equals("FOUND")) {
                        JOptionPane.showMessageDialog(login.getPanelMain(), "Login Success");
                        read.setAccount(username);
                        userHomepage.getLabel_username().setText(username);
                        login.setVisible(false);
                        userHomepage.setVisible(true);
                    }
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


//********************************************************************************************

/*
 *  REGISTER START
 */

        register.registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                create.setUserUsername(register.username_txtField.getText());
                create.setUserFirstName(register.fName_txtField.getText());
                create.setUserLastName(register.lName_txtField.getText());
                create.setUserEmail(register.eMail_txtField.getText());
                create.setUserPassword(String.valueOf(register.passwordField_Confirm.getPassword()));
                //                1.)   All text fields must have values.
                //                2.)   Passwords must be the same.
                //                3.)   INSERT QUERY

                /*
                 *  ->  There should be no empty textfields.
                 */
                if (register.username_txtField.getText().equals("") || register.fName_txtField.getText().equals("") || register.lName_txtField.getText().equals("") || register.eMail_txtField.getText().equals("")) {
                    System.out.println("Please fill out all text fields.");
                    JOptionPane.showMessageDialog(login.getPanelMain(), "Please fill out all text fields.");
                }
                /*
                 *  ->  Check to see if the password and confirmation password fields have the same values.
                 */
                if (String.valueOf(register.passwordField_password.getPassword()).equals(String.valueOf(register.passwordField_Confirm.getPassword()))) {
                    /*
                     *  ->  Check to see if the user has already entered values into textfields.
                     */

                    if (!register.username_txtField.getText().equals("") && !register.fName_txtField.getText().equals("") && !register.lName_txtField.getText().equals("") && !register.eMail_txtField.getText().equals("")) {
                        System.out.println("Query Here, Check if duplicated or not");
                        /*
                         *  ->  INSERT QUERY
                         */
                        create.InsertUser();
                        /*
                         *  ->  Check to see if an account already exists; otherwise, register was successful.
                         */
                        if (create.getDuplicate().equals("Duplicate entry '" + create.getUserUsername() + "' for key 'username'")) {
                            System.out.println("Duplicate Entry");
                            JOptionPane.showMessageDialog(login.getPanelMain(), "Account Already Exist");
                        } else {
                            System.out.println("Success");
                            JOptionPane.showMessageDialog(login.getPanelMain(), "Registered Successfully");
                        }
//                        create.resetUsersAttributes();
                    }
                } else {
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


//********************************************************************************************


/*
 *  USER HOME PAGE START
 */
        //  Profile Button
        userHomepage.getProfileButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Profile Button Clicked");
                profile.getUsername_label().setText(read.getUsername());
                profile.getfName_label().setText(read.getFirstname());
                profile.getlName_label().setText(read.getLastname());
                profile.geteMail_label().setText(read.getEmail());
                profile.getPasswordField().setText(read.getPassword());
                profile.getUsername_label().setEditable(false);
                profile.getfName_label().setEditable(false);
                profile.getlName_label().setEditable(false);
                profile.geteMail_label().setEditable(false);
                profile.getPasswordField().setEditable(false);
                profile.setVisible(true);
                userHomepage.dispose();
            }
        });

        userHomepage.getLogoutButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Logout Clicked");
                login.setVisible(true);
                userHomepage.dispose();
            }
        });
        userHomepage.getShowBooksButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Show Books Clicked");
            }
        });
        userHomepage.getBorrowBookButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Borrow Books Clicked");
            }
        });
        userHomepage.getReturnBookButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Return Books Clicked");
            }
        });
/*
 *  USER HOME PAGE END
 */

/*
 *  PROFILE START
 */

        profile.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("-->>" + read.getUsername());
                System.out.println("Go Back Clicked");
                userHomepage.setVisible(true);
                profile.dispose();
            }
        });

        profile.getEditButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Edit Clicked");

                profile.getUsername_label().setEditable(true);
                profile.getfName_label().setEditable(true);
                profile.getlName_label().setEditable(true);
                profile.geteMail_label().setEditable(true);
                profile.getPasswordField().setEditable(true);
            }
        });

        profile.getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Show Button Clicked");

                read.setUsername(profile.getUsername_label().getText());
                read.setFirstname(profile.getfName_label().getText());
                read.setLastname(profile.getlName_label().getText());
                read.setEmail(profile.geteMail_label().getText());
                read.setPassword(String.valueOf(profile.getPasswordField().getPassword()));

                update.UpdateUser(read.getId(),read.getUsername(),read.getFirstname(),read.getLastname(),read.getEmail(),read.getPassword());
                JOptionPane.showMessageDialog(profile.getPanelMain(),"Your account successfully updated.");
                profile.getUsername_label().setEditable(false);
                profile.getfName_label().setEditable(false);
                profile.getlName_label().setEditable(false);
                profile.geteMail_label().setEditable(false);
                profile.getPasswordField().setEditable(false);

            }
        });
/*
 *  PROFILE END
 */

    };
}