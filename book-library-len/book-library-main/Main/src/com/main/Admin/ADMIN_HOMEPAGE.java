package com.main.Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ADMIN_HOMEPAGE extends JFrame{
    private JPanel panelMain;
    private JButton viewBooksButton;
    private JButton addUserButton;
    private JButton viewUsersButton;
    private JButton addBookButton;
    private JButton viewIssuedBooksButton;
    private JButton returnBookButton;
    private JButton issueBookButton;
    private JButton createResetButton;

    public JButton getViewBooksButton() {
        return viewBooksButton;
    }

    public void setViewBooksButton(JButton viewBooksButton) {
        this.viewBooksButton = viewBooksButton;
    }

    public JButton getAddUserButton() {
        return addUserButton;
    }

    public void setAddUserButton(JButton addUserButton) {
        this.addUserButton = addUserButton;
    }

    public JButton getViewUsersButton() {
        return viewUsersButton;
    }

    public void setViewUsersButton(JButton viewUsersButton) {
        this.viewUsersButton = viewUsersButton;
    }

    public JButton getAddBookButton() {
        return addBookButton;
    }

    public void setAddBookButton(JButton addBookButton) {
        this.addBookButton = addBookButton;
    }

    public JButton getViewIssuedBooksButton() {
        return viewIssuedBooksButton;
    }

    public void setViewIssuedBooksButton(JButton viewIssuedBooksButton) {
        this.viewIssuedBooksButton = viewIssuedBooksButton;
    }

    public JButton getReturnBookButton() {
        return returnBookButton;
    }

    public void setReturnBookButton(JButton returnBookButton) {
        this.returnBookButton = returnBookButton;
    }

    public JButton getIssueBookButton() {
        return issueBookButton;
    }

    public void setIssueBookButton(JButton issueBookButton) {
        this.issueBookButton = issueBookButton;
    }

    public JButton getCreateResetButton() {
        return createResetButton;
    }

    public void setCreateResetButton(JButton createResetButton) {
        this.createResetButton = createResetButton;
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void setPanelMain(JPanel panelMain) {
        this.panelMain = panelMain;
    }
        public ADMIN_HOMEPAGE(){
        setContentPane(getPanelMain());
        setTitle("Jomari Abejo");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        }
}

