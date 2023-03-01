package com.main.Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ADMIN_HOMEPAGE_ADDBOOK extends JFrame{
    private JPanel panelMain;
    private JTextField textField_Genre;
    private JTextField textField_Price;
    private JButton goBackButton;
    private JButton submitButton;
    private JButton clearFieldsButton;
    private JLabel lbl_BookName;
    private JLabel lbl_Genre;
    private JLabel lbl_Price;
    private JTextField textField_BookName;

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void setPanelMain(JPanel panelMain) {
        this.panelMain = panelMain;
    }

    public JTextField getTextField_Genre() {
        return textField_Genre;
    }

    public void setTextField_Genre(JTextField textField_Genre) {
        this.textField_Genre = textField_Genre;
    }

    public JTextField getTextField_Price() {
        return textField_Price;
    }

    public void setTextField_Price(JTextField textField_Price) {
        this.textField_Price = textField_Price;
    }

    public JButton getGoBackButton() {
        return goBackButton;
    }

    public void setGoBackButton(JButton goBackButton) {
        this.goBackButton = goBackButton;
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

    public JLabel getLbl_BookName() {
        return lbl_BookName;
    }

    public void setLbl_BookName(JLabel lbl_BookName) {
        this.lbl_BookName = lbl_BookName;
    }

    public JLabel getLbl_Genre() {
        return lbl_Genre;
    }

    public void setLbl_Genre(JLabel lbl_Genre) {
        this.lbl_Genre = lbl_Genre;
    }

    public JLabel getLbl_Price() {
        return lbl_Price;
    }

    public void setLbl_Price(JLabel lbl_Price) {
        this.lbl_Price = lbl_Price;
    }

    public JTextField getTextField_BookName() {
        return textField_BookName;
    }

    public void setTextField_BookName(JTextField textField_BookName) {
        this.textField_BookName = textField_BookName;
    }
    ADMIN_HOMEPAGE_ADDBOOK(){
        setContentPane(getPanelMain());
        setTitle("Jomari Abejo");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);

    }
}
