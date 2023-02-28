package com.main;

import com.main.Admin.ADMIN_HOMEPAGE;
import com.main.Admin.Admin;
import com.crud.CREATE;
import com.crud.DELETE;
import com.main.Users.*;
import com.crud.READ;
import com.crud.UPDATE;



import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

public class MAIN {
    public static void main(String[] args) throws SQLException {
        //  SQL METHODS
        CREATE create = new CREATE();
        READ read = new READ();
        UPDATE update = new UPDATE();
        DELETE delete = new DELETE();

        //  LOGIIN GUI
        LOGIIN login = new LOGIIN();
        REGISTER register = new REGISTER();
        FORGOTPASSWORD forgotpassword = new FORGOTPASSWORD();


        //  USERS GUI
        USERS_HOMEPAGE users_homepage = new USERS_HOMEPAGE();
        MyProfile users_profile = new MyProfile();
        MyBooks users_books = new MyBooks();
        ViewBooks users_viewBooks = new ViewBooks();


        //  ADMIN GUI
        ADMIN_HOMEPAGE admin_homepage = new ADMIN_HOMEPAGE();


        //  The program will start to login GUI.
        login.setVisible(true);
        login.getBtn_login().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Login Clicked");

                String username =
                        login.
                        getTxtField_username().
                        getText();
                String password =
                        String.valueOf(login.getPwdField_password().getPassword());

                read.check_admin_or_user(username, password);

                if (read.isAdmin()) {
                    JOptionPane.showMessageDialog
                                    (login.getPanelMain(), "Welcome back admin");
                    admin_homepage.setVisible(true);
                    login.dispose();
                } else if (read.isUser()) {
                    JOptionPane.showMessageDialog(login.getPanelMain(),
                            "Welcome back " + username);
                    users_homepage.getLbl_getUsername().setText(username);
                    users_homepage.setVisible(true);
                    login.dispose();
                } else {
                    JOptionPane.showMessageDialog(login.getPanelMain(),
                            "The username you entered isn’t connected to an account.");
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
                        JOptionPane.showMessageDialog(login.getPanelMain(),
                                "Ensure that every field has a value.");
                    }
                    if (read.isAdmin()) {
                        JOptionPane.showMessageDialog(login.getPanelMain(),
                                "Welcome back admin");
                        admin_homepage.setVisible(true);
                        login.dispose();
                    } else if (read.isUser()) {
                        JOptionPane.showMessageDialog(login.getPanelMain(),
                                "Welcome back " + username);
                        users_homepage.getLbl_getUsername().setText(username);
                        users_homepage.setVisible(true);
                        login.dispose();
                    } else {
                        JOptionPane.showMessageDialog(login.getPanelMain(),
                                "The username you entered isn’t connected to an account.");
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
            LOGIIN GUI END
         */





        /*
            REGISTER GUI START
         */


        register.getBtn_register().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Register Clicked");

//                String username, String password, String secret_recovery_phrase, String fname, String lname, String email
                create.insert_user(
                        register.getTxtField_username().getText(),
                        String.valueOf(register.getPwdField_password_confirm().getPassword()),
                        String.valueOf(register.getPwdField_recoveryphrase().getPassword()),
                        register.getTxtField_firstname().getText(),
                        register.getTxtField_lastname().getText(),
                        register.getTxtField_email().getText()
                );

                if (register.getTxtField_username().getText().equals("") ||
                        String.valueOf(register.getPwdField_recoveryphrase().getPassword()).equals("") ||
                        String.valueOf(register.getPwdField_password_confirm().getPassword()).equals("")
                ) {
                    JOptionPane.showMessageDialog(register.getPanelMain(), "Fill in the fields");
                }

                if (!register.getTxtField_username().getText().equals("") &&
                        !String.valueOf(register.getPwdField_password_confirm().getPassword()).equals("") &&
                        !String.valueOf(register.getPwdField_recoveryphrase().getPassword()).equals("")) {

                    if (String.valueOf(register.getPwdField_password_confirm().getPassword()).equals(String.valueOf(register.getPwdField_password().getPassword()))) {

                        if (create.isDuplicate()) {
                            JOptionPane.showMessageDialog(register.getPanelMain(),
                                    "Account already Exist");
                        } else {
                            JOptionPane.showMessageDialog(register.getPanelMain(),
                                    "Registered Successfully");
                            register.RESETVALUES();
                            login.setVisible(true);
                            register.dispose();
                        }
                    } else {
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

                    create.insert_user(
                            register.getTxtField_username().getText(),
                            String.valueOf(register.getPwdField_password_confirm().getPassword()),
                            String.valueOf(register.getPwdField_recoveryphrase().getPassword()),
                            register.getTxtField_firstname().getText(),
                            register.getTxtField_lastname().getText(),
                            register.getTxtField_email().getText()
                    );

                    if (register.getTxtField_username().getText().equals("") ||
                            String.valueOf(register.getPwdField_recoveryphrase().getPassword()).equals("") ||
                            String.valueOf(register.getPwdField_password_confirm().getPassword()).equals("")
                    ) {
                        JOptionPane.showMessageDialog(register.getPanelMain(), "Fill in the fields");
                    }

                    if (!register.getTxtField_username().getText().equals("") &&
                            !String.valueOf(register.getPwdField_password_confirm().getPassword()).equals("") &&
                            !String.valueOf(register.getPwdField_recoveryphrase().getPassword()).equals("")) {

                        if (String.valueOf
                                (register.getPwdField_password_confirm().getPassword()).
                                equals(String.valueOf(register.getPwdField_password().getPassword()))) {

                            if (create.isDuplicate() == true) {
                                JOptionPane.showMessageDialog(register.getPanelMain(),
                                        "Account already Exist");
                            } else {
                                JOptionPane.showMessageDialog(register.getPanelMain(),
                                        "Registered Successfully");
                            }
                        } else {
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





        /*
            USER HOMEPAGE START
         */

        users_homepage.myProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("My Profile Clicked");
                users_profile.getTxtField_username().setText(read.getGetUsername());
                users_profile.getPasswordField_password().setText(read.getGetPassword());
                users_profile.getTxtField_fname().setText(read.getGetFirstName());
                users_profile.getTxtField_lname().setText(read.getGetLastName());
                users_profile.getTxtField_email().setText(read.getGetEmail());
                users_profile.setVisible(true);
                users_homepage.dispose();
            }
        });
        users_homepage.getViewBooksButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("View Books Clicked");
                read.showBooks();
                users_viewBooks.getBooksTable().setModel(read.getBooksDTM());
                users_viewBooks.getJscroll().getViewport().add(users_viewBooks.getBooksTable());
                TableColumnModel columnModel = users_viewBooks.getBooksTable().getColumnModel();
                columnModel.getColumn(0).setPreferredWidth(25);
                columnModel.getColumn(1).setPreferredWidth(420);
                columnModel.getColumn(2).setPreferredWidth(100);
                columnModel.getColumn(3).setPreferredWidth(55);
                users_viewBooks.getBooksTable().getTableHeader().setFont(new Font("Dialog", Font.BOLD, 18));
                users_viewBooks.getBooksTable().setRowHeight(0, 60);
                users_viewBooks.getBooksTable().setRowHeight(40);
                users_viewBooks.setVisible(true);
                users_homepage.dispose();
            }
        });
        users_homepage.getMyBooksButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("My Books Clicked");
                String UID = String.valueOf(read.getID());
                try {
                    read.usersBooks(UID);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                users_books.getMyBooksTable().setModel(read.getUsersBooksDTM());
                users_books.getjScrollpane().getViewport().add(users_books.getMyBooksTable());

                TableColumnModel columnModel = users_books.getMyBooksTable().getColumnModel();
                columnModel.getColumn(0).setPreferredWidth(200);
                columnModel.getColumn(1).setPreferredWidth(200);
                columnModel.getColumn(2).setPreferredWidth(200);
                users_books.setVisible(true);
                users_homepage.dispose();
            }
        });

        users_homepage.getLOGOUTButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("LOGOUT CLICKED");
                login.getTxtField_username().setText("");
                login.getPwdField_password().setText("");
                login.setVisible(true);
                users_homepage.dispose();
            }
        });

        /*
            USER HOMEPAGE END
         */



        /*
            My Profile Start
         */

        users_profile.getEditButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit Button Clicked");
            }
        });
        users_profile.getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Save Button Clicked");
                try {
                    update.UPDATE_USERPROFILE(
                            read.getGetUsername(),
                            users_profile.getTxtField_username().getText(),
                            String.valueOf(users_profile.getPasswordField_password().getPassword()),
                            users_profile.getTxtField_fname().getText(),
                            users_profile.getTxtField_lname().getText(),
                            users_profile.getTxtField_email().getText()
                    );
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                if (update.getUPDATE_PROCESS().equals("success")) {
                    JOptionPane.showMessageDialog(users_profile.getPanelMain(), "UPDATE SUCCESS");
                    users_profile.getTxtField_username().setEditable(false);
                    users_profile.getTxtField_fname().setEditable(false);
                    users_profile.getTxtField_lname().setEditable(false);
                    users_profile.getTxtField_email().setEditable(false);
                    users_profile.getPasswordField_password().setEditable(false);
                    users_homepage.getLbl_getUsername().setText(users_profile.getTxtField_username().getText());
                    read.setGetUsername(users_profile.getTxtField_username().getText());
                    read.setGetPassword
                            (String.valueOf
                                    (Boolean.parseBoolean
                                            (String.valueOf
                                                    (users_profile.
                                                            getPasswordField_password().
                                                            getPassword()))));
                } else {
                    JOptionPane.showMessageDialog(users_profile.getPanelMain(), "UPDATE FAILED");
                }
            }
        });
        users_profile.getGoBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Go Back Clicked");
                users_homepage.setVisible(true);
                users_profile.dispose();
            }
        });

        /*
            My Profile End
         */


        /*
            Users ViewBooks Start
         */

        users_viewBooks.goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Go Back");
            }
        });

        users_viewBooks.goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Go Back Clicked.");
                users_homepage.setVisible(true);
                users_viewBooks.dispose();
            }
        });

        /*
            Users ViewBooks End
         */

        /*
            Users Books Start
         */

        users_books.getGoBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Go Back Clicked");
                users_homepage.setVisible(true);
                users_books.dispose();
            }
        });
        /*
           Users Books End
         */









        /*
           MyProfile Start
         */

        users_profile.getEditButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (users_profile.getTxtField_username().isEditable()) {
                    users_profile.getTxtField_username().setEditable(false);
                    users_profile.getPasswordField_password().setEditable(false);
                    users_profile.getTxtField_fname().setEditable(false);
                    users_profile.getTxtField_lname().setEditable(false);
                    users_profile.getTxtField_email().setEditable(false);
                } else {
                    users_profile.getTxtField_username().setEditable(true);
                    users_profile.getPasswordField_password().setEditable(true);
                    users_profile.getTxtField_fname().setEditable(true);
                    users_profile.getTxtField_lname().setEditable(true);
                    users_profile.getTxtField_email().setEditable(true);
                }
            }
        });
        users_profile.getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        users_profile.getGoBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                users_homepage.setVisible(true);
                users_profile.dispose();
            }
        });

        /*
           MyProfile End
         */
    }
}