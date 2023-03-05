package com.main.Admin;

import javax.swing.*;
import java.awt.*;

public class ADMIN_HOMEPAGE_RETURNBOOK extends JFrame{

    private JPanel panelMain;
    private JTextField textField_IssueId;
    private JTextField textField_ReturnDate;
    private JButton returnButton;
    private JButton goBackButton;
    private JLabel lbl_IssueId;
    private JLabel lbl_ReturnDate;

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void setPanelMain(JPanel panelMain) {
        this.panelMain = panelMain;
    }

    public JTextField getTextField_IssueId() {
        return textField_IssueId;
    }

    public void setTextField_IssueId(JTextField textField_IssueId) {
        this.textField_IssueId = textField_IssueId;
    }

    public JTextField getTextField_ReturnDate() {
        return textField_ReturnDate;
    }

    public void setTextField_ReturnDate(JTextField textField_ReturnDate) {
        this.textField_ReturnDate = textField_ReturnDate;
    }

    public JButton getReturnButton() {
        return returnButton;
    }

    public void setReturnButton(JButton returnButton) {
        this.returnButton = returnButton;
    }

    public JButton getGoBackButton() {
        return goBackButton;
    }

    public void setGoBackButton(JButton goBackButton) {
        this.goBackButton = goBackButton;
    }

    public JLabel getLbl_IssueId() {
        return lbl_IssueId;
    }

    public void setLbl_IssueId(JLabel lbl_IssueId) {
        this.lbl_IssueId = lbl_IssueId;
    }

    public JLabel getLbl_ReturnDate() {
        return lbl_ReturnDate;
    }

    public void setLbl_ReturnDate(JLabel lbl_ReturnDate) {
        this.lbl_ReturnDate = lbl_ReturnDate;
    }
    public ADMIN_HOMEPAGE_RETURNBOOK(){
        setContentPane(getPanelMain());
        setTitle("Jomari Abejo");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);
    }

}
