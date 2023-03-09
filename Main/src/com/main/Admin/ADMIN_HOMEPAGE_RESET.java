package com.main.Admin;

import javax.swing.*;
import java.awt.*;

public class ADMIN_HOMEPAGE_RESET extends JFrame {
    private JButton resetBooksBtn;
    private JPanel panelMain;
    private JButton resetIssuedBtn;
    private JButton goBackButton;
    private JButton resetUsersBtn;

    public JButton getCreateButton() {
        return resetBooksBtn;
    }

    public void setCreateButton(JButton createButton) {
        this.resetBooksBtn = createButton;
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void setPanelMain(JPanel panelMain) {
        this.panelMain = panelMain;
    }

    public JButton getResetButton() {
        return resetIssuedBtn;
    }

    public void setResetButton(JButton resetButton) {
        this.resetIssuedBtn = resetButton;
    }

    public JButton getGoBackButton() {
        return goBackButton;
    }

    public void setGoBackButton(JButton goBackButton) {
        this.goBackButton = goBackButton;
    }

    public JButton getResetBooksBtn() {
        return resetBooksBtn;
    }

    public void setResetBooksBtn(JButton resetBooksBtn) {
        this.resetBooksBtn = resetBooksBtn;
    }

    public JButton getResetIssuedBtn() {
        return resetIssuedBtn;
    }

    public void setResetIssuedBtn(JButton resetIssuedBtn) {
        this.resetIssuedBtn = resetIssuedBtn;
    }

    public JButton getResetUsersBtn() {
        return resetUsersBtn;
    }

    public void setResetUsersBtn(JButton resetUsersBtn) {
        this.resetUsersBtn = resetUsersBtn;
    }

    public ADMIN_HOMEPAGE_RESET() {
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