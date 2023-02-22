package com.initial.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ShowBooks extends JFrame {
    static Connection conn = null;
    static Statement stmt = null;
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/books";

    static final String USER = "root";
    static final String PASS = "";

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
        return bookslistt;
    }

    public void setBookslist(JTable bookslist) {
        this.bookslistt = bookslist;
    }

    public JTable bookslistt;

    public JScrollPane getScrollPane() {
        return ScrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        ScrollPane = scrollPane;
    }

    private JScrollPane ScrollPane;

    public JButton getGoBackButton() {
        return goBackButton;
    }

    public void setGoBackButton(JButton goBackButton) {
        this.goBackButton = goBackButton;
    }

    private JButton goBackButton;
    private String[][] dataMain;

    public String[][] getDataMain() {
        return dataMain;
    }

    public void setDataMain(String[][] dataMain) {
        this.dataMain = dataMain;
    }

    public ShowBooks() throws SQLException, ClassNotFoundException {
        ImageIcon img = new ImageIcon("C:\\Users\\Prila\\jdbc\\src\\others\\icon.png");
        String[] headers = {
                "ID",
                "Title",
                "Released Year",
                "Stock Qty"
        };


// sql start
        // Set up database connection
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
        // Create a Statement object with a scrollable cursor
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        // Execute the query and store the result in a ResultSet
        ResultSet rs = stmt.executeQuery("SELECT id, title, released_year, stock_quantity FROM books1_0");
        // Determine the number of rows in the ResultSet
        rs.last();
        System.out.println(rs.last());
        int numRows = rs.getRow();
        rs.beforeFirst();
        // Initialize multidimensional array
        String[][] data = new String[numRows][4];

        // Iterate through the ResultSet and store the values in the array
        int row = 0;
        while (rs.next()) {
            data[row][0] = rs.getString("id");
            data[row][1] = rs.getString("title");
            data[row][2] = rs.getString("released_year");
            data[row][3] = rs.getString("stock_quantity");
            row++;
        }
// sql end

        DefaultTableModel model = new DefaultTableModel(data, headers);
        getBookslist().setModel(model);
        getScrollPane().getViewport().add(getBookslist());
        pack();
        setIconImage(img.getImage());
        setContentPane(getPanelMain());
        setTitle("Jomari Abejo");
        setSize(400, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);
    }
}

class testShowBooks{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

    }
}