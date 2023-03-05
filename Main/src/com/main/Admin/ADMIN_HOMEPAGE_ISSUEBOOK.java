package com.main.Admin;

import javax.swing.*;

public class ADMIN_HOMEPAGE_ISSUEBOOK extends JFrame{
    private JTextField textField_BookId;
    private JTextField textField_UserId;
    private JTextField txtField_Period;
    private JButton submitButton;
    private JButton clearFieldsButton;
    private JLabel lbl_BookId;
    private JLabel lbl_UserId;
    private JLabel lbl_Period;
    private JLabel lbl_IssuedDate;
    private JTextField txtField_IssuedDate;
    private JButton goBackButton;
    private JPanel panelMain;

    public JTextField getTextField_BookId() {
        return textField_BookId;
    }

    public void setTextField_BookId(JTextField textField_BookId) {
        this.textField_BookId = textField_BookId;
    }

    public JTextField getTextField_UserId() {
        return textField_UserId;
    }

    public void setTextField_UserId(JTextField textField_UserId) {
        this.textField_UserId = textField_UserId;
    }

    public JTextField getTxtField_Period() {
        return txtField_Period;
    }

    public void setTxtField_Period(JTextField txtField_Period) {
        this.txtField_Period = txtField_Period;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(JButton submitButton) {
        this.submitButton = submitButton;
    }

    public JButton getClearFieldsButton() {
        return clearFieldsButton;
    }

    public void setClearFieldsButton(JButton clearFieldsButton) {
        this.clearFieldsButton = clearFieldsButton;
    }

    public JLabel getLbl_BookId() {
        return lbl_BookId;
    }

    public void setLbl_BookId(JLabel lbl_BookId) {
        this.lbl_BookId = lbl_BookId;
    }

    public JLabel getLbl_UserId() {
        return lbl_UserId;
    }

    public void setLbl_UserId(JLabel lbl_UserId) {
        this.lbl_UserId = lbl_UserId;
    }

    public JLabel getLbl_Period() {
        return lbl_Period;
    }

    public void setLbl_Period(JLabel lbl_Period) {
        this.lbl_Period = lbl_Period;
    }

    public JLabel getLbl_IssuedDate() {
        return lbl_IssuedDate;
    }

    public void setLbl_IssuedDate(JLabel lbl_IssuedDate) {
        this.lbl_IssuedDate = lbl_IssuedDate;
    }

    public JTextField getTxtField_IssuedDate() {
        return txtField_IssuedDate;
    }

    public void setTxtField_IssuedDate(JTextField txtField_IssuedDate) {
        this.txtField_IssuedDate = txtField_IssuedDate;
    }

    public JButton getGoBackButton() {
        return goBackButton;
    }

    public void setGoBackButton(JButton goBackButton) {
        this.goBackButton = goBackButton;
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void setPanelMain(JPanel panelMain) {
        this.panelMain = panelMain;
    }
    public ADMIN_HOMEPAGE_ISSUEBOOK(){
        setContentPane(getPanelMain());
        setTitle("Jomari Abejo");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);
    }
}
