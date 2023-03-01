package com.main.Admin;

import javax.swing.*;

public class ADMIN_HOMEPAGE_VIEWBOOKS extends JFrame{
    private JTable tbl_ViewBooks;
    private JPanel panelMain;
    private JButton goBackButton;

    public JTable getTbl_ViewBooks() {
        return tbl_ViewBooks;
    }

    public void setTbl_ViewBooks(JTable tbl_ViewBooks) {
        this.tbl_ViewBooks = tbl_ViewBooks;
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void setPanelMain(JPanel panelMain) {
        this.panelMain = panelMain;
    }

    public JButton getGoBackButton() {
        return goBackButton;
    }

    public void setGoBackButton(JButton goBackButton) {
        this.goBackButton = goBackButton;
    }
    ADMIN_HOMEPAGE_VIEWBOOKS(){
        setContentPane(getPanelMain());
        setTitle("Jomari Abejo");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);
    }
}
