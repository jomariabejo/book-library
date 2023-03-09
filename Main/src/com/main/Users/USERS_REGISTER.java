package com.main.Users;

import javax.swing.*;
import java.awt.*;

public class USERS_REGISTER extends JFrame {

    private JPanel panelMain;
    private JTextField txtField_username;
    private JPasswordField pwdField_recoveryphrase;
    private JButton btn_register;
    private JButton btn_go_back;
    private JLabel lbl_username;
    private JLabel lbl_firstname;
    private JLabel lbl_lastname;
    private JLabel lbl_email;
    private JLabel lbl_recovery_phrase;
    private JLabel lbl_password;
    private JLabel lbl_confirm_password;
    private JTextField txtField_firstname;
    private JTextField txtField_lastname;
    private JTextField txtField_email;
    private JPasswordField pwdField_password;
    private JPasswordField pwdField_password_confirm;

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

    public JPasswordField getPwdField_recoveryphrase() {
        return pwdField_recoveryphrase;
    }

    public void setPwdField_recoveryphrase(JPasswordField pwdField_recoveryphrase) {
        this.pwdField_recoveryphrase = pwdField_recoveryphrase;
    }

    public JButton getBtn_register() {
        return btn_register;
    }

    public void setBtn_register(JButton btn_register) {
        this.btn_register = btn_register;
    }

    public JButton getBtn_go_back() {
        return btn_go_back;
    }

    public void setBtn_go_back(JButton btn_go_back) {
        this.btn_go_back = btn_go_back;
    }

    public JLabel getLbl_username() {
        return lbl_username;
    }

    public void setLbl_username(JLabel lbl_username) {
        this.lbl_username = lbl_username;
    }

    public JLabel getLbl_firstname() {
        return lbl_firstname;
    }

    public void setLbl_firstname(JLabel lbl_firstname) {
        this.lbl_firstname = lbl_firstname;
    }

    public JLabel getLbl_lastname() {
        return lbl_lastname;
    }

    public void setLbl_lastname(JLabel lbl_lastname) {
        this.lbl_lastname = lbl_lastname;
    }

    public JLabel getLbl_email() {
        return lbl_email;
    }

    public void setLbl_email(JLabel lbl_email) {
        this.lbl_email = lbl_email;
    }

    public JLabel getLbl_recovery_phrase() {
        return lbl_recovery_phrase;
    }

    public void setLbl_recovery_phrase(JLabel lbl_recovery_phrase) {
        this.lbl_recovery_phrase = lbl_recovery_phrase;
    }

    public JLabel getLbl_password() {
        return lbl_password;
    }

    public void setLbl_password(JLabel lbl_password) {
        this.lbl_password = lbl_password;
    }

    public JLabel getLbl_confirm_password() {
        return lbl_confirm_password;
    }

    public void setLbl_confirm_password(JLabel lbl_confirm_password) {
        this.lbl_confirm_password = lbl_confirm_password;
    }

    public JTextField getTxtField_firstname() {
        return txtField_firstname;
    }

    public void setTxtField_firstname(JTextField txtField_firstname) {
        this.txtField_firstname = txtField_firstname;
    }

    public JTextField getTxtField_lastname() {
        return txtField_lastname;
    }

    public void setTxtField_lastname(JTextField txtField_lastname) {
        this.txtField_lastname = txtField_lastname;
    }

    public JTextField getTxtField_email() {
        return txtField_email;
    }

    public void setTxtField_email(JTextField txtField_email) {
        this.txtField_email = txtField_email;
    }

    public JPasswordField getPwdField_password() {
        return pwdField_password;
    }

    public void setPwdField_password(JPasswordField pwdField_password) {
        this.pwdField_password = pwdField_password;
    }

    public JPasswordField getPwdField_password_confirm() {
        return pwdField_password_confirm;
    }

    public void setPwdField_password_confirm(JPasswordField pwdField_password_confirm) {
        this.pwdField_password_confirm = pwdField_password_confirm;
    }

    public USERS_REGISTER() throws HeadlessException {
        setContentPane(panelMain);
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Prila\\Downloads\\book-library\\Main\\src\\com\\main\\iconJomariAbejo.jpeg");
        setIconImage(icon);
        setTitle("Jomari Abejo");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);

    }
    public void RESETVALUES() {
        getTxtField_username().setText("");
        getTxtField_email().setText("");
        getTxtField_firstname().setText("");
        getTxtField_lastname().setText("");
        getPwdField_password().setText("");
        getPwdField_password_confirm().setText("");
        getPwdField_recoveryphrase().setText("");
    }
}