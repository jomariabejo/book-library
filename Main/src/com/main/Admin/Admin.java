package com.main.Admin;

import com.crud.*;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin implements Runnable {

        public Admin(){
        /*
         *   DATABASE
         */
        CREATE create = new CREATE();
        READ read = new READ();
        UPDATE update = new UPDATE();
        DELETE delete = new DELETE();
        /*
         *   ADMIN GUI
         */
        ADMIN_HOMEPAGE home = new ADMIN_HOMEPAGE();
        ADMIN_HOMEPAGE_ADDUSER adduser = new ADMIN_HOMEPAGE_ADDUSER();
        ADMIN_HOMEPAGE_ADDBOOK addbook = new ADMIN_HOMEPAGE_ADDBOOK();
        ADMIN_HOMEPAGE_CREATERESET create_or_reset = new ADMIN_HOMEPAGE_CREATERESET();
        ADMIN_HOMEPAGE_ISSUEBOOK issuebook = new ADMIN_HOMEPAGE_ISSUEBOOK();
        ADMIN_HOMEPAGE_RETURNBOOK returnbook = new ADMIN_HOMEPAGE_RETURNBOOK();
        ADMIN_HOMEPAGE_VIEWBOOKS viewbooks = new ADMIN_HOMEPAGE_VIEWBOOKS();
        ADMIN_HOMEPAGE_VIEWISSUEDBOOKS viewissuedbooks = new ADMIN_HOMEPAGE_VIEWISSUEDBOOKS();
        ADMIN_HOMEPAGE_VIEWUSERS viewusers = new ADMIN_HOMEPAGE_VIEWUSERS();

        System.out.println("Welcome to admin Homepage");

        /*
         *  The program will launch the homepage.
         */

        /*
         * ADMIN_HOMEPAGE
         */

        JFrame[] changeFrame = new JFrame[8];
        changeFrame[0] = viewbooks;
        changeFrame[1] = viewusers;
        changeFrame[2] = viewissuedbooks;
        changeFrame[3] = issuebook;
        changeFrame[4] = adduser;
        changeFrame[5] = addbook;
        changeFrame[6] = returnbook;
        changeFrame[7] = create_or_reset;

        ActionListener listenerAdminHomepage = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[] arrAdminHomepageButtons = {
                        "View Books",
                        "View INITIAL_MAIN",
                        "View Issued Books",
                        "Issue Book",
                        "Add User",
                        "Add Book",
                        "Return Book",
                        "Create/Reset",
                };

                for (int c = 0; c < arrAdminHomepageButtons.length; c++) {
                    if (e.getActionCommand().equals(arrAdminHomepageButtons[c])) {
                        changeFrame[c].setVisible(true);
                        if (c == 0) {
                            read.showBooks();
                            viewbooks.getTbl_ViewBooks().setModel(read.getBooksDTM());
                            viewbooks.getjScrollPane().getViewport().add(viewbooks.getTbl_ViewBooks());

                            System.out.println("a;lskdfjas;dlj");
                        }
                        home.dispose();
                    }
                }
            }
        };
        home.getAddBookButton().addActionListener(listenerAdminHomepage);
        home.getAddUserButton().addActionListener(listenerAdminHomepage);
        home.getCreateResetButton().addActionListener(listenerAdminHomepage);
        home.getIssueBookButton().addActionListener(listenerAdminHomepage);
        home.getViewBooksButton().addActionListener(listenerAdminHomepage);
        home.getReturnBookButton().addActionListener(listenerAdminHomepage);
        home.getViewIssuedBooksButton().addActionListener(listenerAdminHomepage);
        home.getViewUsersButton().addActionListener(listenerAdminHomepage);




        /*
         * ADDUSER
         */

        ActionListener listenerAddUser = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Go Back")) {
                    System.out.println("Go Back");
                    home.setVisible(true);
                    adduser.dispose();
                } else if (e.getActionCommand().equals("Clear Fields")) {
                    System.out.println("Clear Fields");
                    adduser.clearFields();
                } else {
                    System.out.println("Add User");
                    create.admin_create_user(
                            adduser.uname(),
                            adduser.fname(),
                            adduser.lname(),
                            adduser.email()
                    );
                    JOptionPane.showMessageDialog(adduser.getPanelMain(),
                            create.isDuplicate() ? ("Account already Exist") : ("Added Successfully"));

                    if (!create.isDuplicate()) {
                        home.setVisible(true);
                        adduser.dispose();
                    } else create.setDuplicate(false);
                }
            }
        };
        adduser.getGoBackButton().addActionListener(listenerAddUser);
        adduser.getAddUserButton().addActionListener(listenerAddUser);
        adduser.getClearFieldsButton().addActionListener(listenerAddUser);


        /*
         * ADDBOOK START
         */

        ActionListener listenerAddBook = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] addBookBtn = {
                        "Go Back",
                        "Clear Fields",
                        "Submit",
                };
                if (e.getActionCommand().equals(addBookBtn[0])) {
                    home.setVisible(true);
                    addbook.clearFields();
                    addbook.dispose();
                } else if (e.getActionCommand().equals(addBookBtn[1])) {
                    addbook.clearFields();
                } else {
                    System.out.println("Execute Query");
                    create.addNewBook(addbook.BNAME(), addbook.BGENRE(), addbook.BPRICE());
                }
            }
        };
        addbook.getGoBackButton().addActionListener(listenerAddBook);
        addbook.getClearFieldsButton().addActionListener(listenerAddBook);
        addbook.getSubmitButton().addActionListener(listenerAddBook);

        /*
         * VIEWBOOKS START
         */

        ActionListener listenerViewBooks = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Go Back")) {
                    home.setVisible(true);
                    viewbooks.dispose();
                }
            }
        };
        viewbooks.getGoBackButton().addActionListener(listenerViewBooks);
        }

    @Override
    public void run() {
    }
}