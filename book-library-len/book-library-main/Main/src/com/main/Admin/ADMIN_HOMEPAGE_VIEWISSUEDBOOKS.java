package com.main.Admin;

import javax.swing.*;

public class ADMIN_HOMEPAGE_VIEWISSUEDBOOKS extends JFrame{
    private JPanel panelMain;
    private JTable tbl_IssuedBooks;
    private JButton goBackButton;

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void setPanelMain(JPanel panelMain) {
        this.panelMain = panelMain;
    }

    public JTable getTbl_IssuedBooks() {
        return tbl_IssuedBooks;
    }

    public void setTbl_IssuedBooks(JTable tbl_IssuedBooks) {
        this.tbl_IssuedBooks = tbl_IssuedBooks;
    }

    public JButton getGoBackButton() {
        return goBackButton;
    }

    public void setGoBackButton(JButton goBackButton) {
        this.goBackButton = goBackButton;
    }
    ADMIN_HOMEPAGE_VIEWISSUEDBOOKS(){
        setContentPane(getPanelMain());
        setTitle("Jomari Abejo");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);
    }
}
