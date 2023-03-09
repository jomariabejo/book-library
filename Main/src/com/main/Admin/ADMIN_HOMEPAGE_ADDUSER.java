package com.main.Admin;

import javax.swing.*;
import java.awt.*;

public class ADMIN_HOMEPAGE_ADDUSER extends JFrame{
    private JPanel panelMain;
    private JTextField textField_Username;
    private JTextField textField_FirstName;
    private JTextField textField_LastName;
    private JLabel lblUsername;
    private JLabel lblFirstName;
    private JLabel lblLastName;
    private JButton addUserButton;
    private JButton clearFieldsButton;
    private JButton goBackButton;
    private JTextField textField_Email;
    private JLabel lbl_Email;

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void setPanelMain(JPanel panelMain) {
        this.panelMain = panelMain;
    }

    public JTextField getTextField_Username() {
        return textField_Username;
    }

    public void setTextField_Username(JTextField textField_Username) {
        this.textField_Username = textField_Username;
    }

    public JTextField getTextField_FirstName() {
        return textField_FirstName;
    }

    public void setTextField_FirstName(JTextField textField_FirstName) {
        this.textField_FirstName = textField_FirstName;
    }

    public JTextField getTextField_LastName() {
        return textField_LastName;
    }

    public void setTextField_LastName(JTextField textField_LastName) {
        this.textField_LastName = textField_LastName;
    }

    public JLabel getLblUsername() {
        return lblUsername;
    }

    public void setLblUsername(JLabel lblUsername) {
        this.lblUsername = lblUsername;
    }

    public JLabel getLblFirstName() {
        return lblFirstName;
    }

    public void setLblFirstName(JLabel lblFirstName) {
        this.lblFirstName = lblFirstName;
    }

    public JLabel getLblLastName() {
        return lblLastName;
    }

    public void setLblLastName(JLabel lblLastName) {
        this.lblLastName = lblLastName;
    }

    public JButton getAddUserButton() {
        return addUserButton;
    }

    public void setAddUserButton(JButton addUserButton) {
        this.addUserButton = addUserButton;
    }

    public JButton getClearFieldsButton() {
        return clearFieldsButton;
    }

    public void setClearFieldsButton(JButton clearFieldsButton) {
        this.clearFieldsButton = clearFieldsButton;
    }

    public JButton getGoBackButton() {
        return goBackButton;
    }

    public void setGoBackButton(JButton goBackButton) {
        this.goBackButton = goBackButton;
    }

    public JTextField getTextField_Email() {
        return textField_Email;
    }

    public void setTextField_Email(JTextField textField_Email) {
        this.textField_Email = textField_Email;
    }

    public JLabel getLbl_Email() {
        return lbl_Email;
    }

    public void setLbl_Email(JLabel lbl_Email) {
        this.lbl_Email = lbl_Email;
    }
    public void clearFields(){
        getTextField_FirstName().setText("");
        getTextField_Email().setText("");
        getTextField_Username().setText("");
        getTextField_LastName().setText("");
    }
    //createuser(getFieldsValues)
    public String uname(){
        return getTextField_Username().getText();
    }
    public String fname(){
        return getTextField_FirstName().getText();
    }
    public String lname(){
        return getTextField_LastName().getText();
    }
    public String email(){
        return getTextField_Email().getText();
    }
    public ADMIN_HOMEPAGE_ADDUSER(){
        setContentPane(getPanelMain());
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Prila\\Downloads\\book-library\\Main\\src\\com\\main\\iconJomariAbejo.jpeg");
        setIconImage(icon);
        setTitle("Jomari Abejo");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);
    }
}