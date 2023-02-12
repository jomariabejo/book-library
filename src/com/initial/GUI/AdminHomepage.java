package com.initial.GUI;

import javax.swing.*;

public class AdminHomepage extends JFrame{
    private JPanel panelMain;
    private JButton viewBooksButton;
    private JButton viewUsersButton;
    private JButton viewIssuedBooksButton;
    private JButton issueBookButton;
    private JButton addUserButton;
    private JButton addBookButton;
    private JButton returnBookButton;
    private JButton createResetButton;

    public AdminHomepage() {
        pack();
        ImageIcon img = new ImageIcon("C:\\Users\\Prila\\jdbc\\src\\others\\icon.png");
        setIconImage(img.getImage());
        setContentPane(panelMain);
        setTitle("Jomari Abejo");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
class testAdminHomepage{
    public static void main(String[] args) {
        AdminHomepage adminHomepage = new AdminHomepage();
    }
}
