package com.initial.GUI_LoginandRegister;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

public class ShowBooks extends JFrame{

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void setPanelMain(JPanel panelMain) {
        this.panelMain = panelMain;
    }

    public JButton getReturnButton() {
        return returnButton;
    }

    public void setReturnButton(JButton returnButton) {
        this.returnButton = returnButton;
    }

    public JButton getBorrowButton() {
        return borrowButton;
    }

    public void setBorrowButton(JButton borrowButton) {
        this.borrowButton = borrowButton;
    }

    private JPanel panelMain;
    private JButton returnButton;
    private JButton borrowButton;

    public JTable getBookslist() {
        return bookslist;
    }

    public void setBookslist(JTable bookslist) {
        this.bookslist = bookslist;
    }

    public JTable bookslist;

    public JScrollPane getScrollPane() {
        return ScrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        ScrollPane = scrollPane;
    }

    private JScrollPane ScrollPane;

    ShowBooks(){
        String[][] rec = {
                { "001", "David", "AUS" },
                { "002", "Steve", "AUS" },
                { "003", "Yuvraj", "IND" },
                { "004", "Kane", "NZ" },
                { "005", "Ben", "ENG" },
                { "006", "Eion", "ENG" },
                { "007", "Miller", "SA" },
                { "008", "Rohit", "IND" },
                { "001", "David", "AUS" },
                { "002", "Steve", "AUS" },
                { "003", "Yuvraj", "IND" },
                { "004", "Kane", "NZ" },
                { "005", "Ben", "ENG" },
                { "006", "Eion", "ENG" },
                { "007", "Miller", "SA" },
                { "008", "Rohit", "IND" },
                { "001", "David", "AUS" },
                { "002", "Steve", "AUS" },
                { "003", "Yuvraj", "IND" },
                { "004", "Kane", "NZ" },
                { "005", "Ben", "ENG" },
                { "006", "Eion", "ENG" },
                { "007", "Miller", "SA" },
                { "008", "Rohit", "IND" },
                { "001", "David", "AUS" },
                { "002", "Steve", "AUS" },
                { "003", "Yuvraj", "IND" },
                { "004", "Kane", "NZ" },
                { "005", "Ben", "ENG" },
                { "006", "Eion", "ENG" },
                { "007", "Miller", "SA" },
                { "008", "Rohit", "IND" }
        };

        String header [] = {"Id", "Player", "Team"};
//        DefaultTableModel dtm = (DefaultTableModel)getJtable().getModel();
//        dtm.addRow(rec);
//        dtm.getColumnCount();


        ImageIcon img = new ImageIcon("C:\\Users\\Prila\\jdbc\\src\\others\\icon.png");
//sample start
//        Font font = new Font("Verdana", Font.PLAIN, 12);
//        JTable table = new JTable(rec,header);
//        table.setFont(font);
//        table.setRowHeight(30);
//        table.setBackground(Color.blue);
//        table.setForeground(Color.white);
//        table.setTableHeader(null);
//        JFrame frame = new JFrame();
//        frame.add(new JScrollPane(table));
//
//
//        frame.pack();
//        frame.setIconImage(img.getImage());
//        frame.setTitle("Jomari Abejo");
//        frame.setSize(400, 600);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setLocationRelativeTo(null);
//        frame.dispose();
//        frame.setVisible(true);
//sample end


//DefaultTableModel dtm = (DefaultTableModel)getJtable().getModel();


//        TableModel dataModel = new
//                AbstractTableModel() {
//                    public int getColumnCount() {
//                        return 10;
//                    }
//
//                    public int getRowCount() {
//                        return 10;
//                    }
//
//                    public Object getValueAt(int row, int col) {
//                        return row * col;
//                    }
//                };

        String[] cols = {"Col 1", "Col2"};
        String[][] data = {{"Hello", "World"},{"Hello", "World"}};
        DefaultTableModel model = new DefaultTableModel(data,cols);
        getBookslist().setModel(model);
        pack();
        setIconImage(img.getImage());
        setContentPane(getPanelMain());
        setTitle("Jomari Abejo");
        setSize(400, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        dispose();
        setVisible(true);

    }
}

class testshowbooks{
    public static void main(String[] args) {
        ShowBooks showBooks = new ShowBooks();
    }
}