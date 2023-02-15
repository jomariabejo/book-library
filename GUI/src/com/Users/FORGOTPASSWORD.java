package com.Users;

import javax.swing.*;
import java.awt.*;

public class FORGOTPASSWORD extends JFrame{
    private JPanel panelMain;
    private JTextField txtField_username;
    private JPasswordField pwd_recovery_phrase;
    private JButton btn_recovery;

    private JButton btn_go_back;
    private JLabel lbl_username;
    private JLabel lbl_recovery_phrase;

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

    public JPasswordField getPwd_recovery_phrase() {
        return pwd_recovery_phrase;
    }

    public void setPwd_recovery_phrase(JPasswordField pwd_recovery_phrase) {
        this.pwd_recovery_phrase = pwd_recovery_phrase;
    }

    public JButton getBtn_recovery() {
        return btn_recovery;
    }

    public void setBtn_recovery(JButton btn_recovery) {
        this.btn_recovery = btn_recovery;
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

    public JLabel getLbl_recovery_phrase() {
        return lbl_recovery_phrase;
    }

    public void setLbl_recovery_phrase(JLabel lbl_recovery_phrase) {
        this.lbl_recovery_phrase = lbl_recovery_phrase;
    }

    public FORGOTPASSWORD() throws HeadlessException {
        setContentPane(panelMain);
        setTitle("Jomari Abejo");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);
    }
}
class testForgotPassword{
    public static void main(String[] args) {
        FORGOTPASSWORD forgotpassword = new FORGOTPASSWORD();
        forgotpassword.setVisible(true);
    }
}