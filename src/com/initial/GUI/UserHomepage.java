package com.initial.GUI;

import javax.swing.*;

public class UserHomepage extends JFrame {
    public JPanel getPanelMain() {
        return panelMain;
    }

    private JPanel panelMain;
    private JButton borrowBookButton;
    private JButton returnBookButton;
    private JButton showBooksButton;
    private JButton profileButton;
    private JButton logoutButton;

    public void setPanelMain(JPanel panelMain) {
        this.panelMain = panelMain;
    }

    public JButton getBorrowBookButton() {
        return borrowBookButton;
    }

    public void setBorrowBookButton(JButton borrowBookButton) {
        this.borrowBookButton = borrowBookButton;
    }

    public JButton getReturnBookButton() {
        return returnBookButton;
    }

    public void setReturnBookButton(JButton returnBookButton) {
        this.returnBookButton = returnBookButton;
    }

    public JButton getShowBooksButton() {
        return showBooksButton;
    }

    public void setShowBooksButton(JButton showBooksButton) {
        this.showBooksButton = showBooksButton;
    }

    public JButton getProfileButton() {
        return profileButton;
    }

    public void setProfileButton(JButton profileButton) {
        this.profileButton = profileButton;
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }

    public void setLogoutButton(JButton logoutButton) {
        this.logoutButton = logoutButton;
    }

    public JLabel getLabel_username() {
        return label_username;
    }

    public void setLabel_username(JLabel label_username) {
        this.label_username = label_username;
    }

    private JLabel label_username;



    public UserHomepage() {
        pack();
        ImageIcon img = new ImageIcon("C:\\Users\\Prila\\jdbc\\src\\others\\icon.png");
        setIconImage(img.getImage());
        setContentPane(panelMain);
        setTitle("Jomari Abejo");
        setSize(400, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);
    }
}