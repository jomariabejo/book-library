package com.main.Users;

import javax.swing.*;
import java.awt.*;

public class USERS_LOGIN extends JFrame {
    private JPanel panelMain;
    private JPasswordField pwdField_password;
    private JButton btn_login;
    private JButton btn_register;
    private JLabel lbl_username;
    private JLabel lbl_password;
    private JTextField txtField_username;
    private JButton btn_forgotpassword;

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void setPanelMain(JPanel panelMain) {
        this.panelMain = panelMain;
    }

    public JTextField getTxtField_username() {
        return txtField_username;
    }

    public void setTxtField_username(JTextField txtField_username) {
        this.txtField_username = txtField_username;
    }

    public JPasswordField getPwdField_password() {
        return pwdField_password;
    }

    public void setPwdField_password(JPasswordField pwdField_password) {
        this.pwdField_password = pwdField_password;
    }

    public JButton getBtn_login() {
        return btn_login;
    }

    public void setBtn_login(JButton btn_login) {
        this.btn_login = btn_login;
    }

    public JButton getBtn_register() {
        return btn_register;
    }

    public void setBtn_register(JButton btn_register) {
        this.btn_register = btn_register;
    }

    public JLabel getLbl_username() {
        return lbl_username;
    }

    public void setLbl_username(JLabel lbl_username) {
        this.lbl_username = lbl_username;
    }

    public JLabel getLbl_password() {
        return lbl_password;
    }

    public void setLbl_password(JLabel lbl_password) {
        this.lbl_password = lbl_password;
    }

    public JButton getBtn_forgotpassword() {
        return btn_forgotpassword;
    }

    public void setBtn_forgotpassword(JButton btn_forgotpassword) {
        this.btn_forgotpassword = btn_forgotpassword;
    }

    public USERS_LOGIN() throws HeadlessException {
        setContentPane(getPanelMain());
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Prila\\Downloads\\book-library\\Main\\src\\com\\main\\iconJomariAbejo.jpeg");
        setIconImage(icon);
        setTitle("Jomari Abejo");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);
    }

    public String check_Fields() {
        if (getTxtField_username().getText().equals("") ||
                getPwdField_password().getText().equals("")) {
            return "Please enter information in the fields.";
        }
        if (getTxtField_username().getText().equals("")) {
            return "Put something in the username field.";
        }
        if (getPwdField_password().getText().equals("")) {
            return "Put something in the password field.";
        }
        return "";
    }
}