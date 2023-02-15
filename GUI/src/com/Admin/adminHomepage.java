package com.Admin;

import javax.swing.*;

public class adminHomepage extends JFrame{
    private JPanel panelMain;

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void setPanelMain(JPanel panelMain) {
        this.panelMain = panelMain;
    }
        public adminHomepage(){
        setContentPane(getPanelMain());
        setTitle("Jomari Abejo");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);
    }
}

class testttt{
    public static void main(String[] args) {
        adminHomepage ad = new adminHomepage();
        ad.setVisible(true);
    }
}