package com.Users;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewBooks extends JFrame{


    public JPanel getPanelMain() {
        return panelMain;
    }

    public void setPanelMain(JPanel panelMain) {
        this.panelMain = panelMain;
    }

    public  JTable getBooksTable() {
        return booksTable;
    }

    public void setBooksTable(JTable booksTable) {
        this.booksTable = booksTable;
    }

    private JPanel panelMain;
    public JButton goBackButton;
    private JTable booksTable;


    public ViewBooks() {
        setContentPane(getPanelMain());
        setTitle("Jomari Abejo");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);

        String[] headers = {
                "ID",
                "Title",
                "Released Year",
                "Stock Qty"
        };
        String[][] data = {

                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
        };

        DefaultTableModel dtm = new DefaultTableModel(data, headers);
        getBooksTable().setModel(dtm);
    }
}

class testViewBooks{
    public static void main(String[] args) {
        ViewBooks v = new ViewBooks();
        v.setVisible(true);
    }
}