package com.initial.GUI_LoginandRegister;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame{
    private JTextField fName_txtField;
    private JTextField lName_txtField;
    private JTextField eMail_txtField;
    private JButton registerButton;
    private JButton backToLoginButton;
    private JPanel panelMain;
    private JPasswordField passwordField_password;
    private JPasswordField passwordField_Confirm;
    private JProgressBar progressBar1;

    public Register() {

        pack();
        ImageIcon img = new ImageIcon("C:\\Users\\Prila\\jdbc\\src\\others\\icon.png");
        setIconImage(img.getImage());
        setContentPane(panelMain);
        setTitle("Jomari Abejo");
        setSize(400,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Register");
            }
        });
        backToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Back to Login");
                dispose();
                Login login = new Login();
            }
        });
    }
}
