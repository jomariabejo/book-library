package com.main.Admin;

import javax.swing.*;

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
        setVisible(false);
    }
}

class testttt{
    public static void main(String[] args) {
        ADMIN_HOMEPAGE ad = new ADMIN_HOMEPAGE();
        ad.setVisible(true);
    }
}