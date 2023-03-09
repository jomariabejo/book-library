package com.main.Users;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class USERS_BOOKS extends JFrame {
    private JPanel panelMain;
    private JTable myBooksTable;
    private JButton goBackButton;
    private JScrollPane jScrollpane;

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

    public DefaultTableModel mybooks_dtm;

    public JScrollPane getjScrollpane() {
        return jScrollpane;
    }

    public void setjScrollpane(JScrollPane jScrollpane) {
        this.jScrollpane = jScrollpane;
    }

    public USERS_BOOKS() {
        setContentPane(getPanelMain());
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Prila\\Downloads\\book-library\\Main\\src\\com\\main\\iconJomariAbejo.jpeg");
        setIconImage(icon);
        setTitle("Jomari Abejo");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);

    }
}