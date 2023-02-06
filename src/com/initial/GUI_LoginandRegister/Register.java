package com.initial.GUI_LoginandRegister;

import com.initial.Create;
import com.initial.Read;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame {
    public JTextField fName_txtField;
    public JTextField lName_txtField;
    public JTextField eMail_txtField;
    public JButton registerButton;
    public JButton backToLoginButton;
    public JPanel panelMain;
    public JPasswordField passwordField_password;
    public JPasswordField passwordField_Confirm;
    public JTextField username_txtField;

    public Register() {

        pack();
        ImageIcon img = new ImageIcon("C:\\Users\\Prila\\jdbc\\src\\others\\icon.png");
        setIconImage(img.getImage());
        setContentPane(panelMain);
        setTitle("Jomari Abejo");
        setSize(400, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);


    }
}