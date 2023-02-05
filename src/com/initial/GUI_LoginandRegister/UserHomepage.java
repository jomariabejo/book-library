package com.initial.GUI_LoginandRegister;

import javax.swing.*;

public class UserHomepage extends JFrame{
    private JPanel panelMain;
    private JButton borrowBookButton;
    private JButton returnBookButton;
    private JButton showBooksButton;
    private JButton profileButton;
    private JButton logoutButton;
    public JLabel label_username;



    public UserHomepage(){
        pack();
        ImageIcon img = new ImageIcon("C:\\Users\\Prila\\jdbc\\src\\others\\icon.png");
        setIconImage(img.getImage());
        setContentPane(panelMain);
        setTitle("Jomari Abejo");
        setSize(400,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);
    }
}
