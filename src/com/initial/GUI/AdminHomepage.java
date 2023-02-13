package com.initial.GUI;

import javax.swing.*;

public class AdminHomepage extends JFrame{
    private JPanel panelMain;
    private JButton viewBooksButton;
    private JButton viewUsersButton;
    private JButton viewIssuedBooksButton;

    public JButton getViewBooksButton() {
        return viewBooksButton;
    }

    public JButton getViewUsersButton() {
        return viewUsersButton;
    }

    public JButton getViewIssuedBooksButton() {
        return viewIssuedBooksButton;
    }

    public JButton getIssueBookButton() {
        return issueBookButton;
    }

    public JButton getAddUserButton() {
        return addUserButton;
    }

    public JButton getAddBookButton() {
        return addBookButton;
    }

    public JButton getReturnBookButton() {
        return returnBookButton;
    }

    public JButton getCreateResetButton() {
        return createResetButton;
    }
    public JButton getLogoutButton() {
        return logoutButton;
    }

    private JButton issueBookButton;
    private JButton addUserButton;
    private JButton addBookButton;
    private JButton returnBookButton;
    private JButton createResetButton;
    private JButton logoutButton;

    public AdminHomepage() {
        pack();
        ImageIcon img = new ImageIcon("C:\\Users\\Prila\\jdbc\\src\\others\\icon.png");
        setIconImage(img.getImage());
        setContentPane(panelMain);
        setTitle("Jomari Abejo");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);

    }
}
