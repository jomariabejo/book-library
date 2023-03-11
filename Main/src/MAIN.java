import com.crud.*;
import com.main.Admin.*;
import com.main.Users.*;
import com.database.Database;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.TableColumnModel;

public class MAIN {
    /*
     *  SQL-CRUD
     */
    static CREATE create = new CREATE();
    static READ read = new READ();
    static UPDATE update = new UPDATE();
    static DELETE delete = new DELETE();

    /*
     *  LOGIN GUI
     */
    static USERS_LOGIN login = new USERS_LOGIN();
    static USERS_REGISTER register = new USERS_REGISTER();
    static USERS_FORGOTPASSWORD forgotPwd = new USERS_FORGOTPASSWORD();

    /*
     *  USERS GUI
     */
    static USERS_HOMEPAGE users_homepage = new USERS_HOMEPAGE();
    static USERS_PROFILE users_profile = new USERS_PROFILE();
    static USERS_BOOKS users_borrowedBooks = new USERS_BOOKS();
    static USERS_VIEWBOOKS users_viewBooks = new USERS_VIEWBOOKS();

    /*
     *  ADMIN GUI
     */
    static ADMIN_HOMEPAGE admin_homepage = new ADMIN_HOMEPAGE();
    static ADMIN_HOMEPAGE_ADDUSER adduser = new ADMIN_HOMEPAGE_ADDUSER();
    static ADMIN_HOMEPAGE_ADDBOOK addbook = new ADMIN_HOMEPAGE_ADDBOOK();
    static ADMIN_HOMEPAGE_RESET reset =
            new ADMIN_HOMEPAGE_RESET();
    static ADMIN_HOMEPAGE_ISSUEBOOK issuebook = new ADMIN_HOMEPAGE_ISSUEBOOK();
    static ADMIN_HOMEPAGE_RETURNBOOK returnbook = new ADMIN_HOMEPAGE_RETURNBOOK();
    static ADMIN_HOMEPAGE_VIEWBOOKS viewbooks = new ADMIN_HOMEPAGE_VIEWBOOKS();
    static ADMIN_HOMEPAGE_VIEWISSUEDBOOKS viewissuedbooks =
            new ADMIN_HOMEPAGE_VIEWISSUEDBOOKS();
    static ADMIN_HOMEPAGE_VIEWUSERS viewusers = new ADMIN_HOMEPAGE_VIEWUSERS();

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        login.setVisible(true);
        /*
         *  The program will start to login GUI.
         */
        login.setVisible(true);
        Database.getConnectionLibrary();
        login.getBtn_login().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Login Clicked");

                String username = login.getTxtField_username().getText();
                String password =
                        String.valueOf(login.getPwdField_password().getPassword());

                read.check_admin_or_user(username, password);

                if (read.isAdmin()) {
                    JOptionPane.showMessageDialog(
                            login.getPanelMain(), "Welcome back admin");
                    admin_homepage.setVisible(true);
                    login.dispose();
                } else if (read.isUser()) {
                    JOptionPane.showMessageDialog(
                            login.getPanelMain(), "Welcome back " + username);
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
        login.getBtn_forgotpassword().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Forgot Password Clicked");
                login.getTxtField_username().setText("");
                login.getPwdField_password().setText("");
                forgotPwd.setVisible(true);
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
                    String password =
                            String.valueOf(login.getPwdField_password().getPassword());

                    read.check_admin_or_user(username, password);

                    if (login.getTxtField_username().equals("") ||
                            login.getPwdField_password().getPassword().equals("")) {
                        JOptionPane.showMessageDialog(
                                login.getPanelMain(), "Ensure that every field has a value.");
                    }
                    if (read.isAdmin()) {
                        JOptionPane.showMessageDialog(
                                login.getPanelMain(), "Welcome back admin");
                        admin_homepage.setVisible(true);
                        admin_homepage.setVisible(true);
                        login.dispose();
                    } else if (read.isUser()) {
                        JOptionPane.showMessageDialog(
                                login.getPanelMain(), "Welcome back " + username);
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
         *  USERS_REGISTER GUI
         */

        register.getBtn_register().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Register Clicked");
                create.insert_user(register.getTxtField_username().getText(),
                        String.valueOf(
                                register.getPwdField_password_confirm().getPassword()),
                        String.valueOf(register.getPwdField_recoveryphrase().getPassword()),
                        register.getTxtField_firstname().getText(),
                        register.getTxtField_lastname().getText(),
                        register.getTxtField_email().getText());

                if (register.getTxtField_username().getText().equals("") ||
                        String
                                .valueOf(register.getPwdField_recoveryphrase().getPassword())
                                .equals("") ||
                        String
                                .valueOf(
                                        register.getPwdField_password_confirm().getPassword())
                                .equals("")) {
                    JOptionPane.showMessageDialog(
                            register.getPanelMain(), "Fill in the fields");
                }

                if (!register.getTxtField_username().getText().equals("") &&
                        !String
                                .valueOf(
                                        register.getPwdField_password_confirm().getPassword())
                                .equals("") &&
                        !String
                                .valueOf(
                                        register.getPwdField_recoveryphrase().getPassword())
                                .equals("")) {
                    if (String
                            .valueOf(
                                    register.getPwdField_password_confirm().getPassword())
                            .equals(String.valueOf(
                                    register.getPwdField_password().getPassword()))) {
                        if (create.isDuplicate()) {
                            JOptionPane.showMessageDialog(
                                    register.getPanelMain(), "Account already Exist");
                        } else {
                            JOptionPane.showMessageDialog(
                                    register.getPanelMain(), "Registered Successfully");
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

                    create.insert_user(register.getTxtField_username().getText(),
                            String.valueOf(
                                    register.getPwdField_password_confirm().getPassword()),
                            String.valueOf(
                                    register.getPwdField_recoveryphrase().getPassword()),
                            register.getTxtField_firstname().getText(),
                            register.getTxtField_lastname().getText(),
                            register.getTxtField_email().getText());

                    if (register.getTxtField_username().getText().equals("") ||
                            String
                                    .valueOf(
                                            register.getPwdField_recoveryphrase().getPassword())
                                    .equals("") ||
                            String
                                    .valueOf(
                                            register.getPwdField_password_confirm().getPassword())
                                    .equals("")) {
                        JOptionPane.showMessageDialog(
                                register.getPanelMain(), "Fill in the fields");
                    }

                    if (!register.getTxtField_username().getText().equals("") &&
                            !String
                                    .valueOf(
                                            register.getPwdField_password_confirm().getPassword())
                                    .equals("") &&
                            !String
                                    .valueOf(
                                            register.getPwdField_recoveryphrase().getPassword())
                                    .equals("")) {
                        if (String
                                .valueOf(
                                        register.getPwdField_password_confirm().getPassword())
                                .equals(String.valueOf(
                                        register.getPwdField_password().getPassword()))) {
                            if (create.isDuplicate() == true) {
                                JOptionPane.showMessageDialog(
                                        register.getPanelMain(), "Account already Exist");
                            } else {
                                JOptionPane.showMessageDialog(
                                        register.getPanelMain(), "Registered Successfully");
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
         *  FORGOTPASSWORD
         */

        forgotPwd.getBtn_recovery().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand() + "Clicked");
                try {
                    update.resetpassword(forgotPwd.getTxtField_username().getText(),
                            String.valueOf(forgotPwd.getPwd_recovery_phrase().getPassword()));
                    JOptionPane.showMessageDialog(forgotPwd.getPanelMain(),
                            update.getResetpasswordMessage());
                    forgotPwd.getTxtField_username().setText("");
                    forgotPwd.getPwd_recovery_phrase().setText("");
                    forgotPwd.dispose();
                    login.setVisible(true);
                } catch (Exception eResetPassword) {
                    System.out.println(eResetPassword.getMessage());
                }
            }
        });
        forgotPwd.getBtn_go_back().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand() + "Clicked");
                forgotPwd.dispose();
                login.setVisible(true);
            }
        });
        /*
         *  USER HOMEPAGE
         */
        users_homepage.myProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("My Profile Clicked");
                users_profile.getTxtField_username().setText(read.getGetUsername());
                users_profile.getPasswordField_password().setText(
                        read.getGetPassword());
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
                users_viewBooks.getJscroll().getViewport().add(
                users_viewBooks.getBooksTable());
                TableColumnModel columnModel =
                    users_viewBooks.getBooksTable().getColumnModel();
                columnModel.getColumn(0).setPreferredWidth(25);
                columnModel.getColumn(1).setPreferredWidth(420);
                columnModel.getColumn(2).setPreferredWidth(100);
                columnModel.getColumn(3).setPreferredWidth(55);
                users_viewBooks.getBooksTable().getTableHeader().setFont(
                        new Font("Dialog", Font.BOLD, 18));
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
                System.out.println("UID -> " + UID);
                read.userBorrowedBooks(UID);
                users_borrowedBooks.getMyBooksTable().setModel(read.getBorrowedBooksDTM());
                users_borrowedBooks.getjScrollpane().getViewport().add(users_borrowedBooks.getMyBooksTable());

                TableColumnModel columnModel =
                        users_borrowedBooks.getMyBooksTable().getColumnModel();
                columnModel.getColumn(0).setPreferredWidth(200);
                columnModel.getColumn(1).setPreferredWidth(200);
                columnModel.getColumn(2).setPreferredWidth(200);
                users_borrowedBooks.getMyBooksTable().getTableHeader().setFont(
                        new Font("Dialog", Font.BOLD, 18));
                users_borrowedBooks.getMyBooksTable().setRowHeight(0, 60);
                users_borrowedBooks.getMyBooksTable().setRowHeight(40);
                users_borrowedBooks.setVisible(true);
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
         *  User_Profile
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
                    update.UPDATE_USERPROFILE(read.getGetUsername(),
                            users_profile.getTxtField_username().getText(),
                            String.valueOf(
                                    users_profile.getPasswordField_password().getPassword()),
                            users_profile.getTxtField_fname().getText(),
                            users_profile.getTxtField_lname().getText(),
                            users_profile.getTxtField_email().getText());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                if (update.getUPDATE_PROCESS().equals("success")) {
                    JOptionPane.showMessageDialog(
                            users_profile.getPanelMain(), "UPDATE SUCCESS");
                    users_profile.getTxtField_username().setEditable(false);
                    users_profile.getTxtField_fname().setEditable(false);
                    users_profile.getTxtField_lname().setEditable(false);
                    users_profile.getTxtField_email().setEditable(false);
                    users_profile.getPasswordField_password().setEditable(false);
                    users_homepage.getLbl_getUsername().setText(
                            users_profile.getTxtField_username().getText());
                    read.setGetUsername(users_profile.getTxtField_username().getText());
                    read.setGetPassword(
                            String.valueOf(Boolean.parseBoolean(String.valueOf(
                                    users_profile.getPasswordField_password().getPassword()))));
                } else {
                    JOptionPane.showMessageDialog(
                            users_profile.getPanelMain(), "UPDATE FAILED");
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
         *  USERS_VIEWBOOKS
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
         *  USERS_BOOKS
         */

        users_borrowedBooks.getGoBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Go Back Clicked");
                users_homepage.setVisible(true);
                users_borrowedBooks.dispose();
            }
        });

        /*
         *  USERS_PROFILE
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
            public void actionPerformed(ActionEvent e) {}
        });
        users_profile.getGoBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                users_homepage.setVisible(true);
                users_profile.dispose();
            }
        });

        ActionListener listenerAdminHomepage = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (("View Books").equals(e.getActionCommand())) {
                    read.showBooks();
                    viewbooks.getTbl_ViewBooks().setModel(read.getBooksDTM());
                    viewbooks.getjScrollPane().getViewport().add(
                    viewbooks.getTbl_ViewBooks());
                    viewbooks.setVisible(true);
                    admin_homepage.dispose();
                }
                if (("View Users").equals(e.getActionCommand())) {
                    read.showUsers();
                    viewusers.getUsersTable().setModel(read.getListUsersDTM());
                    viewusers.getjScrollpane().getViewport().add(
                    viewusers.getUsersTable());
                    viewusers.setVisible(true);
                    admin_homepage.dispose();
                }
                if (("View Issued Books").equals(e.getActionCommand())){
                    try {
                        read.showIssuedBooks();
                        viewissuedbooks.getTbl_IssuedBooks().setModel(read.getIssuedBooksDTM());
                        viewissuedbooks.getjScroll().getViewport().add(
                        viewissuedbooks.getTbl_IssuedBooks());
                        viewissuedbooks.setVisible(true);
                        admin_homepage.dispose();

                    } catch (Exception ExceptionOnIssuedBooks) {
                        ExceptionOnIssuedBooks.printStackTrace();
                    }
                }
                if (("Issue Book").equals(e.getActionCommand())) {
                    System.out.println("Issue Book Clicked");
                    issuebook.setVisible(true);
                    admin_homepage.dispose();
                }
                if (("Clear Table").equals(e.getActionCommand())) {
                    reset.setVisible(true);
                    admin_homepage.dispose();
                }
                if (("Add User").equals(e.getActionCommand())){
                    adduser.setVisible(true);
                    admin_homepage.dispose();
                }
                if (("Add Book").equals(e.getActionCommand())){
                    addbook.setVisible(true);
                    admin_homepage.dispose();
                }
                if (("Return Book").equals(e.getActionCommand())){
                    returnbook.setVisible(true);
                    admin_homepage.dispose();
                }
            }
        };
        admin_homepage.getAddBookButton().addActionListener(listenerAdminHomepage);
        admin_homepage.getAddUserButton().addActionListener(listenerAdminHomepage);
        admin_homepage.getCreateResetButton().addActionListener(listenerAdminHomepage);
        admin_homepage.getIssueBookButton().addActionListener(listenerAdminHomepage);
        admin_homepage.getViewBooksButton().addActionListener(listenerAdminHomepage);
        admin_homepage.getReturnBookButton().addActionListener(listenerAdminHomepage);
        admin_homepage.getViewIssuedBooksButton().addActionListener(listenerAdminHomepage);
        admin_homepage.getViewUsersButton().addActionListener(listenerAdminHomepage);

        /*
         * ADDUSER
         */

        ActionListener listenerAddUser = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Go Back")) {
                    System.out.println("Go Back");
                    admin_homepage.setVisible(true);
                    adduser.dispose();
                } else if (e.getActionCommand().equals("Clear Fields")) {
                    System.out.println("Clear Fields");
                    adduser.clearFields();
                } else {
                    System.out.println("Add User");
                    create.createUser(adduser.uname(), adduser.fname(),
                            adduser.lname(), adduser.email());
                    JOptionPane.showMessageDialog(adduser.getPanelMain(),
                            create.isDuplicate() ? ("Account already Exist") :
                                    ("Added Successfully"));

                    if (!create.isDuplicate()) {
                        admin_homepage.setVisible(true);
                        adduser.dispose();
                    } else
                        create.setDuplicate(false);
                }
            }
        };
        adduser.getGoBackButton().addActionListener(listenerAddUser);
        adduser.getAddUserButton().addActionListener(listenerAddUser);
        adduser.getClearFieldsButton().addActionListener(listenerAddUser);

        /*
         * ADDBOOK
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
                    admin_homepage.setVisible(true);
                    addbook.clearFields();
                    addbook.dispose();
                } else if (e.getActionCommand().equals(addBookBtn[1])) {
                    addbook.clearFields();
                } else {
                    System.out.println("Execute Query");
                    create.addNewBook(
                            addbook.BNAME(), addbook.BGENRE(), addbook.BPRICE());
                    JOptionPane.showMessageDialog(addbook.getPanelMain(), "Book added successfully.");
                    addbook.getTextField_Price().setText("");
                    addbook.getTextField_BookName().setText("");
                    addbook.getTextField_Genre().setText("");

                    admin_homepage.setVisible(true);
                    addbook.dispose();
                }
            }
        };
        addbook.getGoBackButton().addActionListener(listenerAddBook);
        addbook.getClearFieldsButton().addActionListener(listenerAddBook);
        addbook.getSubmitButton().addActionListener(listenerAddBook);

        /*
         * VIEWBOOKS
         */

        ActionListener listenerViewBooks = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Back")) {
                    admin_homepage.setVisible(true);
                    viewbooks.dispose();
                }
            }
        };
        viewbooks.getGoBackButton().addActionListener(listenerViewBooks);
        /*
         *  VIEWUSERS
         */
        ActionListener listenerViewUsers = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
                if (e.getActionCommand().equals("Back")) {
                    admin_homepage.setVisible(true);
                    viewusers.dispose();
                }
            }
        };
        viewusers.getGoBackButton().addActionListener(listenerViewUsers);
        /*
         *  VIEW ISSUED BOOKS
         */
        ActionListener listenerViewIssuedBooks = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
                if (e.getActionCommand().equals("Back")) {
                    admin_homepage.setVisible(true);
                    viewissuedbooks.dispose();
                }
            }
        };
        viewissuedbooks.getGoBackButton().addActionListener(listenerViewIssuedBooks);
        ActionListener listenerIssueBook = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Go Back")) {
                    admin_homepage.setVisible(true);
                    issuebook.dispose();
                }
                if (e.getActionCommand().equals("Clear Fields")) {
                    issuebook.clearFields();
                    System.out.println("2");
                }
                if (e.getActionCommand().equals("Submit"))
                    try {
                        create.issueBook(
                                issuebook.getTextField_UserId().getText(),
                                issuebook.getTextField_BookId().getText(),
                                issuebook.getTxtField_IssuedDate().getText(),
                                issuebook.getTxtField_Period().getText());
                        JOptionPane.showMessageDialog(issuebook.getPanelMain(), "Book has been issued.");
                        admin_homepage.setVisible(true);
                        issuebook.dispose();
                    }
                    catch (Exception E) {
                        E.printStackTrace();
                    }
            }
        };

        /*
         *  ISSUE BOOK
         */

        issuebook.getClearFieldsButton().addActionListener(listenerIssueBook);
        issuebook.getSubmitButton().addActionListener(listenerIssueBook);
        issuebook.getGoBackButton().addActionListener(listenerIssueBook);

        /*
         *  RETURN BOOK
         */
        ActionListener listenerReturnBook = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
                if (e.getActionCommand().equals("Go Back")) {
                    System.out.println("Go Back Clicked");
                    admin_homepage.setVisible(true);
                    returnbook.dispose();
                }
                if (e.getActionCommand().equals("Submit")) {
                    String IID = returnbook.getTextField_IssueId().getText();
                    String returnDate = returnbook.getTextField_ReturnDate().getText();
                    try {
                        update.UPDATE_RETURNBOOKDATE(IID, returnDate);
                        update.UPDATE_FINE(IID);
                        JOptionPane.showMessageDialog(returnbook.getPanelMain(), "Updated successfully.");
                        admin_homepage.setVisible(true);
                        returnbook.dispose();
                    } catch (Exception exe) {
                        System.out.println(exe.getMessage());
                        System.out.println("ERROR");
                    }
                    System.out.println("Return Clicked");
                }
            }
        };
        returnbook.getGoBackButton().addActionListener(listenerReturnBook);
        returnbook.getReturnButton().addActionListener(listenerReturnBook);

        /*
         *  RESET
         */
        ActionListener listenerReset = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
                try {
                    if (e.getActionCommand().equals("Reset Books Table")) {
                        delete.BOOKS();
                        JOptionPane.showMessageDialog(reset.getPanelMain(), "cleaned table books");
                    }
                    if (e.getActionCommand().equals("Reset Issued Table")) {
                        delete.ISSUED();
                        JOptionPane.showMessageDialog(reset.getPanelMain(), "cleaned table issued");
                    }
                    if (e.getActionCommand().equals("Reset Users Table")) {
                        delete.USERS();
                        JOptionPane.showMessageDialog(reset.getPanelMain(), "cleaned table users");
                        login.setVisible(true);
                        create.insertAdmin();
                        reset.dispose();
                        login.getTxtField_username().setText("");
                        login.getPwdField_password().setText("");
                    }
                    if (e.getActionCommand().equals("Go Back")) {
                        admin_homepage.setVisible(true);
                        reset.dispose();
                    }
                } catch (Exception eListenerReset) {
                    eListenerReset.getMessage();
                }
            }
        };
        reset.getResetBooksBtn().addActionListener(listenerReset);
        reset.getResetUsersBtn().addActionListener(listenerReset);
        reset.getResetIssuedBtn().addActionListener(listenerReset);
        reset.getGoBackButton().addActionListener(listenerReset);
    }
}