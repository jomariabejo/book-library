package com.main.Admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ADMIN_HOMEPAGE_VIEWBOOKS extends JFrame {
    private JTable tbl_ViewBooks;
    private JPanel panelMain;
    private JButton goBackButton;
    private JScrollPane jScrollPane;

    public JScrollPane getjScrollPane() {
        return jScrollPane;
    }

    public void setjScrollPane(JScrollPane jScrollPane) {
        this.jScrollPane = jScrollPane;
    }

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
    public ADMIN_HOMEPAGE_VIEWBOOKS() {

        String[] headers = {
                "ID",
                "Title",
                "Released Year",
                "Stock Qty"
        };

        String[][] data = {
                {
                        "0",
                        "1",
                        "2",
                        "3"
                },
        };

        DefaultTableModel dtm = new DefaultTableModel(data, headers);
        getTbl_ViewBooks().setModel(dtm);
        getjScrollPane().getViewport().add(getTbl_ViewBooks());
        TableColumnModel columnModel = getTbl_ViewBooks().getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(25);
        columnModel.getColumn(1).setPreferredWidth(420);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(55);
        getTbl_ViewBooks().getTableHeader().setFont(new Font("Dialog", Font.BOLD, 18));
        getTbl_ViewBooks().setRowHeight(0, 60);
        getTbl_ViewBooks().setRowHeight(40);
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