package com.Users;

import javax.swing.*;
import java.awt.*;

public class UsersHomepage extends JFrame {
    private JPanel panelMain;
    private JButton viewBooksButton;
    private JButton myBooksButton;
    private JButton btn_myProfile;
    private JLabel lbl_username;
    private JLabel lbl_getUsername;

    public JButton getViewBooksButton() {
        return viewBooksButton;
    }

    public void setViewBooksButton(JButton viewBooksButton) {
        this.viewBooksButton = viewBooksButton;
    }

    public JButton getMyBooksButton() {
        return myBooksButton;
    }

    public void setMyBooksButton(JButton myBooksButton) {
        this.myBooksButton = myBooksButton;
    }

    public JButton getBtn_myProfile() {
        return btn_myProfile;
    }

    public void setBtn_myProfile(JButton btn_myProfile) {
        this.btn_myProfile = btn_myProfile;
    }

    public JLabel getLbl_username() {
        return lbl_username;
    }

    public void setLbl_username(JLabel lbl_username) {
        this.lbl_username = lbl_username;
    }

    public JLabel getLbl_getUsername() {
        return lbl_getUsername;
    }

    public void setLbl_getUsername(JLabel lbl_getUsername) {
        this.lbl_getUsername = lbl_getUsername;
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void setPanelMain(JPanel panelMain) {
        this.panelMain = panelMain;
    }

    public UsersHomepage() throws HeadlessException {
        setContentPane(panelMain);
        setTitle("Jomari Abejo");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);
    }
}

class testUserHomepage{
    public static void main(String[] args) {
        UsersHomepage usersHomepage = new UsersHomepage();
        usersHomepage.setVisible(true);
    }
}
