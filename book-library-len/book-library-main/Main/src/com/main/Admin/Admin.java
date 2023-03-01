package com.main.Admin;

import com.crud.*;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin implements Runnable {

    /*
    *   DATABASE
    */
    CREATE create = new CREATE();
    READ     read = new READ();
    UPDATE update = new UPDATE();
    DELETE delete = new DELETE();
    /*
     *   ADMIN GUI
     */
    ADMIN_HOMEPAGE             home = new ADMIN_HOMEPAGE();
    ADMIN_HOMEPAGE_ADDUSER     adduser = new ADMIN_HOMEPAGE_ADDUSER();
    ADMIN_HOMEPAGE_ADDBOOK     addbook = new ADMIN_HOMEPAGE_ADDBOOK();
    ADMIN_HOMEPAGE_CREATERESET create_or_reset = new ADMIN_HOMEPAGE_CREATERESET();
    ADMIN_HOMEPAGE_ISSUEBOOK   issuebook = new ADMIN_HOMEPAGE_ISSUEBOOK();
    ADMIN_HOMEPAGE_RETURNBOOK  returnbook = new ADMIN_HOMEPAGE_RETURNBOOK();
    ADMIN_HOMEPAGE_VIEWBOOKS   viewbooks = new ADMIN_HOMEPAGE_VIEWBOOKS();
    ADMIN_HOMEPAGE_VIEWISSUEDBOOKS viewissuedbooks = new ADMIN_HOMEPAGE_VIEWISSUEDBOOKS();
    ADMIN_HOMEPAGE_VIEWUSERS   viewusers = new ADMIN_HOMEPAGE_VIEWUSERS();

    @Override
    public void run() {
        System.out.println("Welcome to admin Homepage");

/*
 *  The program will launch the homepage.
 */

    /*
     * ADMIN_HOMEPAGE START
     */

        home.getViewBooksButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("View books Clicked");
                viewbooks.setVisible(true);
                home.dispose();
            }
        });
        home.getViewUsersButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("View users Clicked");
                viewusers.setVisible(true);
                home.dispose();
            }
        });
        home.getViewIssuedBooksButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("View issuedBooks Clicked");
                viewissuedbooks.setVisible(true);
                home.dispose();

            }
        });
        home.getIssueBookButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Issue book Clicked");
                issuebook.setVisible(true);
                home.dispose();

            }
        });
        home.getAddUserButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add user Clicked");
                adduser.setVisible(true);
                home.dispose();

            }
        });
        home.getAddBookButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add Book Clicked");
                addbook.setVisible(true);
                home.dispose();

            }
        });
        home.getReturnBookButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Return Book Clicked");
                returnbook.setVisible(true);
                home.dispose();

            }
        });
        home.getCreateResetButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Create reset Clicked");
                create_or_reset.setVisible(true);
                home.dispose();

            }
        });

    /*
     * ADMIN_HOMEPAGE END
     */



    /*
     * ADDUSER START
     */

        ActionListener listenerAddUser = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Go Back")){
                    System.out.println("Go Back");
                    home.setVisible(true);
                    adduser.dispose();
                }
                if (e.getActionCommand().equals("Clear Fields")){
                    System.out.println("Clear Fields");
                    adduser.getTextField_Username().setText("");
                    adduser.getTextField_FirstName().setText("");
                    adduser.getTextField_LastName().setText("");
                    adduser.getTextField_Email().setText("");
                }
                if (e.getActionCommand().equals("Add User")){
                    System.out.println("Add User");
                    create.admin_create_user(
                            adduser.getTextField_Username().getText(),
                            adduser.getTextField_FirstName().getText(),
                            adduser.getTextField_LastName().getText(),
                            adduser.getTextField_Email().getText()
                    );
                    JOptionPane.showMessageDialog(adduser.getPanelMain(),
                                create.isDuplicate() ? ("Account already Exist") : ("Added Successfully"));

                    if (!create.isDuplicate()){
                        home.setVisible(true);
                        adduser.dispose();
                    }
                    create.setDuplicate(false);
                }
            }
        };
        adduser.getGoBackButton().addActionListener(listenerAddUser);
        adduser.getAddUserButton().addActionListener(listenerAddUser);
        adduser.getClearFieldsButton().addActionListener(listenerAddUser);

    /*
     * ADDUSER END
     */
    }
}
