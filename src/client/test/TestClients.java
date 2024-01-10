package client.test;


import client.view.Login;

import javax.swing.*;

public class TestClients {

    public static void main(String[] args) {
        show();
    }

    public static void show () {
        Login login = new Login();
        login.setTitle("Đăng nhập");
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setSize(900, 500);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }

}


