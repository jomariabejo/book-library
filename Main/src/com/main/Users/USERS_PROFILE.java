package com.main.Users;

import javax.swing.*;

public class USERS_PROFILE extends JFrame {
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

    public JPasswordField getPasswordField_password() {
        return passwordField_password;
    }

    public void setPasswordField_password(JPasswordField passwordField_password) {
        this.passwordField_password = passwordField_password;
    }

    public JButton getGoBackButton() {
        return goBackButton;
    }

    public void setGoBackButton(JButton goBackButton) {
        this.goBackButton = goBackButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public void setEditButton(JButton editButton) {
        this.editButton = editButton;
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

    public JTextField getTxtField_fname() {
        return txtField_fname;
    }

    public void setTxtField_fname(JTextField txtField_fname) {
        this.txtField_fname = txtField_fname;
    }

    public JTextField getTxtField_lname() {
        return txtField_lname;
    }

    public void setTxtField_lname(JTextField txtField_lname) {
        this.txtField_lname = txtField_lname;
    }

    public JTextField getTxtField_email() {
        return txtField_email;
    }

    public void setTxtField_email(JTextField txtField_email) {
        this.txtField_email = txtField_email;
    }

    private JPanel panelMain;
    private JTextField txtField_username;
    private JPasswordField passwordField_password;
    private JButton goBackButton;
    private JButton saveButton;
    private JButton editButton;
    private JLabel lbl_username;
    private JLabel lbl_password;
    private JTextField txtField_fname;
    private JTextField txtField_lname;
    private JTextField txtField_email;

    public USERS_PROFILE() {
        setContentPane(getPanelMain());
        setTitle("Jomari Abejo");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);


    }
}
