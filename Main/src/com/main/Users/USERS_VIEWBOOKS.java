package com.main.Users;

import com.crud.READ;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class USERS_VIEWBOOKS extends JFrame {

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void setPanelMain(JPanel panelMain) {
        this.panelMain = panelMain;
    }

    public JTable getBooksTable() {
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

    public USERS_VIEWBOOKS() {

        setContentPane(getPanelMain());
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Prila\\Downloads\\book-library\\Main\\src\\com\\main\\iconJomariAbejo.jpeg");
        setIconImage(icon);
        setTitle("Jomari Abejo");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);
        getBooksTable().setRowHeight(24);
        getJscroll().getViewport().add(getBooksTable());
        String [] headers = {
                "ID",
                "NAME",
                "GENRE",
                "PRICE"
        };
        String [][] data = {
                {"0","1","2","3"},
        };
        DefaultTableModel dtm = new DefaultTableModel(data,headers);
        getBooksTable().setModel(dtm);
        TableColumnModel columnModel = getBooksTable().getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(450);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(50);

    }
}
class asdf{
    public static void main(String[] args) {
//  Users Borrowed BOOKS
        READ r = new READ();
//        USERS_BOOKS users_borrowedBooks = new USERS_BOOKS();
//        r.userBorrowedBooks("10");
//        users_borrowedBooks.getMyBooksTable().setModel(r.getBorrowedBooksDTM());
//        users_borrowedBooks.getjScrollpane().getViewport().add(
//                users_borrowedBooks.getMyBooksTable());
//        users_borrowedBooks.setVisible(true);
//  ->
        USERS_VIEWBOOKS uv = new USERS_VIEWBOOKS();
        r.showBooks();
        uv.getBooksTable().setModel(r.getBooksDTM());
        uv.setVisible(true);
    }
}
//SELECT `IID`, `UID`, `BID`, `ISSUED_DATE`, `RETURN_DATE`, `PERIOD`, `FINE` FROM `issued` WHERE `UID` = 13 AND `RETURN_DATE` = ""