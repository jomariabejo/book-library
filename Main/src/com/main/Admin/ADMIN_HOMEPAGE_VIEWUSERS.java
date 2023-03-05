package com.main.Admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class ADMIN_HOMEPAGE_VIEWUSERS extends JFrame{
    private JPanel panelMain;
    private JTable usersTable;
    private JButton goBackButton;
    private JScrollPane jScrollpane;

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void setPanelMain(JPanel panelMain) {
        this.panelMain = panelMain;
    }

    public JTable getUsersTable() {
        return usersTable;
    }

    public void setUsersTable(JTable table1) {
        this.usersTable = table1;
    }

    public JButton getGoBackButton() {
        return goBackButton;
    }

    public void setGoBackButton(JButton goBackButton) {
        this.goBackButton = goBackButton;
    }

    public JScrollPane getjScrollpane() {
        return jScrollpane;
    }

    public void setjScrollpane(JScrollPane jScrollpane) {
        this.jScrollpane = jScrollpane;
    }

    public ADMIN_HOMEPAGE_VIEWUSERS(){

        String[] headers = {
                "ID",
                "Username",
                "First Name",
                "Last Name",
                "Email"
        };

        String[][] data = {
                {"hi","jomariabejo","Jomari","Abejo","jomariabejo@gmail.com"},
                {"asdf","jomariabejo","Jomari","Abejo","jomariabejo@gmail.com"},
                {"qwer","jomariabejo","Jomari","Abejo","jomariabejo@gmail.com"},
                {"hgf","jomariabejo","Jomari","Abejo","jomariabejo@gmail.com"},
                {"","jomariabejo","Jomari","Abejo","jomariabejo@gmail.com"},
                {"","jomariabejo","Jomari","Abejo","jomariabejo@gmail.com"},

        };

        DefaultTableModel dtm = new DefaultTableModel(data,headers);
        getUsersTable().setModel(dtm);
        getjScrollpane().getViewport().add(getUsersTable());
        TableColumnModel columnModel = getUsersTable().getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(150);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(150);
        columnModel.getColumn(3).setPreferredWidth(150);
        columnModel.getColumn(4).setPreferredWidth(150);

        getUsersTable().getTableHeader().setFont(new Font("Dialog", Font.BOLD, 18));
        getUsersTable().setRowHeight(60, 60);
        getUsersTable().setRowHeight(40);
        setContentPane(getPanelMain());

        setTitle("Jomari Abejo");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);
    }
}
class testp{
    public static void main(String[] args) {
        ADMIN_HOMEPAGE_VIEWUSERS v = new ADMIN_HOMEPAGE_VIEWUSERS();
        v.setVisible(true);
    }
}
