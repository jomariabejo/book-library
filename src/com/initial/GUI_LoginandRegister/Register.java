package com.initial.GUI_LoginandRegister;

import com.initial.Create;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame {
    private JTextField fName_txtField;
    private JTextField lName_txtField;
    private JTextField eMail_txtField;
    private JButton registerButton;
    private JButton backToLoginButton;
    private JPanel panelMain;
    private JPasswordField passwordField_password;
    private JPasswordField passwordField_Confirm;
    private JTextField username_txtField;

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

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Create create = new Create();
                System.out.println(create.theCheckIfExist());

                if (String.valueOf(passwordField_password.getPassword()).equals(String.valueOf(passwordField_Confirm.getPassword()))) {
                    create.setUserUsername(username_txtField.getText());
                    create.setUserFirstName(fName_txtField.getText());
                    create.setUserLastName(lName_txtField.getName());
                    create.setUserEmail(eMail_txtField.getText());
                    create.setUserPassword(String.valueOf(passwordField_password.getPassword()));
                    create.InsertUser();

                    /*
                        Account Already Exist
                     */
                    if (create.getCheckIfExist() != null) {
                        JOptionPane.showMessageDialog(panelMain, "Account Exist");
                    }
                    /*
                        Account Successfuly Registered to Database
                     */
                    if (create.getCheckIfExist() == null) {
                        JOptionPane.showMessageDialog(panelMain, "Successfully Registered");
                    }
                } else {
                    JOptionPane.showMessageDialog(panelMain, "Password didn't match");
                }

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