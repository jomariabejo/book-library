package com.main.Admin;

import com.crud.READ;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.sql.SQLException;
import java.text.ParseException;

public class ADMIN_HOMEPAGE_VIEWISSUEDBOOKS extends JFrame {
    private JPanel panelMain;
    private JTable tbl_IssuedBooks;
    private JButton goBackButton;
    private JScrollPane jScroll;

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
    private DefaultTableModel dtm;

    public DefaultTableModel getDtm() {
        return dtm;
    }

    public JScrollPane getjScroll() {
        return jScroll;
    }

    public void setjScroll(JScrollPane jScroll) {
        this.jScroll = jScroll;
    }

    public void setDtm(DefaultTableModel dtm) {
        this.dtm = dtm;
    }
    String[] headers = {
            "IID",
            "UID",
            "BID",
            "ISSUED_DATE",
            "RETURN_DATE",
            "PERIOD",
            "FINE"
    };

    String[][] data = {
            {
                    "0",
                    "1",
                    "2",
                    "3",
                    "4",
                    "5",
                    "6"
            },
            {
                    "0",
                    "1",
                    "2",
                    "3",
                    "4",
                    "5",
                    "6"
            },
            {
                    "0",
                    "1",
                    "2",
                    "3",
                    "4",
                    "5",
                    "6"
            },
            {
                    "0",
                    "1",
                    "2",
                    "3",
                    "4",
                    "5",
                    "6"
            },
            {
                    "0",
                    "1",
                    "2",
                    "3",
                    "4",
                    "5",
                    "6"
            },
            {
                    "0",
                    "1",
                    "2",
                    "3",
                    "4",
                    "5",
                    "6"
            },
            {
                    "0",
                    "1",
                    "2",
                    "3",
                    "4",
                    "5",
                    "6"
            },
            {
                    "0",
                    "1",
                    "2",
                    "3",
                    "4",
                    "5",
                    "6"
            },
            {
                    "0",
                    "1",
                    "2",
                    "3",
                    "4",
                    "5",
                    "6"
            },
            {
                    "0",
                    "1",
                    "2",
                    "3",
                    "4",
                    "5",
                    "6"
            },
            {
                    "0",
                    "1",
                    "2",
                    "3",
                    "4",
                    "5",
                    "6"
            },
            {
                    "0",
                    "1",
                    "2",
                    "3",
                    "4",
                    "5",
                    "6"
            },
            {
                    "0",
                    "1",
                    "2",
                    "3",
                    "4",
                    "5",
                    "6"
            },
            {
                    "0",
                    "1",
                    "2",
                    "3",
                    "4",
                    "5",
                    "6"
            },
            {
                    "0",
                    "1",
                    "2",
                    "3",
                    "4",
                    "5",
                    "6"
            },
            {
                    "0",
                    "1",
                    "2",
                    "3",
                    "4",
                    "5",
                    "6"
            },
            {
                    "0",
                    "1",
                    "2",
                    "3",
                    "4",
                    "5",
                    "6"
            },
            {
                    "0",
                    "1",
                    "2",
                    "3",
                    "4",
                    "5",
                    "6"
            },

    };

    public ADMIN_HOMEPAGE_VIEWISSUEDBOOKS() {
        DefaultTableModel dtm = new DefaultTableModel(data, headers);
        getTbl_IssuedBooks().setModel(dtm);
        getjScroll().getViewport().add(getTbl_IssuedBooks());
        TableColumnModel columnModel = getTbl_IssuedBooks().getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(50);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(160);
        columnModel.getColumn(4).setPreferredWidth(160);
        columnModel.getColumn(5).setPreferredWidth(80);
        columnModel.getColumn(6).setPreferredWidth(100);
        getTbl_IssuedBooks().getTableHeader().setFont(new Font("Dialog", Font.BOLD, 18));
        getTbl_IssuedBooks().setRowHeight(0, 60);
        getTbl_IssuedBooks().setRowHeight(40);
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