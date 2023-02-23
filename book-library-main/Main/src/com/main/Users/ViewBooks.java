package com.main.Users;

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
    private JScrollPane jscroll;

    public JScrollPane getJscroll() {
        return jscroll;
    }

    public void setJscroll(JScrollPane jscroll) {
        this.jscroll = jscroll;
    }

    public ViewBooks() {
        setContentPane(getPanelMain());
        setTitle("Jomari Abejo");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);
        getBooksTable().setRowHeight(24);

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
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
                {"0","1","2","3"},
        };

        DefaultTableModel dtm = new DefaultTableModel(data,headers);
        getBooksTable().setModel(dtm);
        getJscroll().getViewport().add(getBooksTable());
    }
}

class testViewBooks{
    public static void main(String[] args) {
        ViewBooks v = new ViewBooks();
        v.setVisible(true);
    }
}