package com.Users;

import javax.swing.*;

public class MyBooks extends JFrame{
    private JPanel panelMain;
    private JTable myBooksTable;
    private JButton goBackButton;

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void setPanelMain(JPanel panelMain) {
        this.panelMain = panelMain;
    }

    public JTable getMyBooksTable() {
        return myBooksTable;
    }

    public void setMyBooksTable(JTable myBooksTable) {
        this.myBooksTable = myBooksTable;
    }

    public JButton getGoBackButton() {
        return goBackButton;
    }

    public void setGoBackButton(JButton goBackButton) {
        this.goBackButton = goBackButton;
    }

    public MyBooks() {
        setContentPane(getPanelMain());
        setTitle("Jomari Abejo");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);

    }
}
