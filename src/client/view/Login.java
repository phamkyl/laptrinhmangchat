package client.view;

import client.controller.Client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//public class Login extends JFrame {
//    private JPanel contentPane;
//    public JTextField textFieldUserName;
//    public JPasswordField passwordUser;
//    private Client client = new Client(this);
//
//    public Login() {
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBounds(100, 100, 922, 503);
//        contentPane = new JPanel();
//        contentPane.setBackground(new Color(255, 255, 255));
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        setContentPane(contentPane);
//        contentPane.setLayout(null);
//
//        Panel panelLeft = new Panel();
//        panelLeft.setBackground(new Color(204, 255, 255));
//        panelLeft.setBounds(0, 0, 386, 477);
//        contentPane.add(panelLeft);
//        panelLeft.setLayout(null);
//
//        JLabel labelIconHospital = new JLabel("");
//        labelIconHospital.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\hospital.png"));
//        labelIconHospital.setBounds(120, 135, 130, 145);
//        panelLeft.add(labelIconHospital);
//
//        JLabel labelNameHospital = new JLabel("B\u1EC6NH VI\u1EC6N");
//        labelNameHospital.setForeground(new Color(0, 102, 153));
//        labelNameHospital.setFont(new Font("Tahoma", Font.PLAIN, 23));
//        labelNameHospital.setBounds(126, 290, 148, 38);
//        panelLeft.add(labelNameHospital);
//
//        Panel panelRight = new Panel();
//        panelRight.setBackground(new Color(0, 204, 204));
//        panelRight.setBounds(381, 0, 574, 466);
//        contentPane.add(panelRight);
//        panelRight.setLayout(null);
//
//        textFieldUserName = new JTextField();
//        textFieldUserName.setForeground(new Color(255, 255, 255));
//        textFieldUserName.setFont(new Font("Tahoma", Font.PLAIN, 23));
//        textFieldUserName.setBorder(null);
//        textFieldUserName.setBackground(new Color(0, 204, 204));
//        textFieldUserName.setBounds(129, 131, 328, 38);
//        panelRight.add(textFieldUserName);
//        textFieldUserName.setColumns(10);
//
//        passwordUser = new JPasswordField();
//        passwordUser.setForeground(new Color(255, 255, 255));
//        passwordUser.setFont(new Font("Tahoma", Font.PLAIN, 23));
//        passwordUser.setBorder(null);
//        passwordUser.setBackground(new Color(0, 204, 204));
//        passwordUser.setBounds(129, 229, 328, 38);
//        panelRight.add(passwordUser);
//
//        JSeparator separatorUserName = new JSeparator();
//        separatorUserName.setBackground(new Color(255, 255, 255));
//        separatorUserName.setBounds(129, 174, 328, 2);
//        panelRight.add(separatorUserName);
//
//        JSeparator separatorPassword = new JSeparator();
//        separatorPassword.setBackground(Color.WHITE);
//        separatorPassword.setBounds(129, 270, 328, 2);
//        panelRight.add(separatorPassword);
//
//        JLabel labelIconUserName = new JLabel("");
//        labelIconUserName.setForeground(new Color(0, 0, 0));
//        labelIconUserName.setBackground(new Color(255, 255, 255));
//        labelIconUserName.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\avatar.png"));
//        labelIconUserName.setBounds(78, 153, 43, 38);
//        panelRight.add(labelIconUserName);
//
//        JLabel labelIconPassword = new JLabel("");
//        labelIconPassword.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\key (1).png"));
//        labelIconPassword.setForeground(Color.BLACK);
//        labelIconPassword.setBackground(Color.WHITE);
//        labelIconPassword.setBounds(76, 249, 43, 38);
//        panelRight.add(labelIconPassword);
//
//        JButton buttonLogin = new JButton("\u0110\u0102NG NH\u1EACP");
//        buttonLogin.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                client.loginAccount();
//            }
//        });
//        buttonLogin.setBorder(null);
//        buttonLogin.setBackground(new Color(255, 255, 255));
//        buttonLogin.setForeground(new Color(0, 204, 204));
//        buttonLogin.setFont(new Font("Tahoma", Font.PLAIN, 19));
//        buttonLogin.setBounds(203, 344, 160, 43);
//        panelRight.add(buttonLogin);
//    }
//
//    public void dipslay() {
//        GUI gui = new GUI();
//        gui.setTitle("Quản lý bệnh án");
//        gui.setSize(1114, 674);
//        gui.setLocationRelativeTo(null);
//        gui.setVisible(true);
//    }
//}

public class Login extends JFrame {

    private JPanel contentPane;
    public JTextField textFieldUserName;
    public JPasswordField passwordUser;
    private Client client = new Client(this);

    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 922, 503);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

        JPanel panelLeft = new JPanel();
        panelLeft.setBackground(new Color(204, 255, 255));
        contentPane.add(panelLeft);
        panelLeft.setLayout(null);

        JLabel labelIconHospital = new JLabel("");
        labelIconHospital.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\hospital.png"));
        labelIconHospital.setBounds(160, 135, 130, 145);
        panelLeft.add(labelIconHospital);

        JLabel labelNameHospital = new JLabel("B\u1EC6NH VI\u1EC6N");
        labelNameHospital.setForeground(new Color(0, 102, 153));
        labelNameHospital.setFont(new Font("Tahoma", Font.PLAIN, 23));
        labelNameHospital.setBounds(170, 290, 148, 38);
        panelLeft.add(labelNameHospital);

        JPanel panelRight = new JPanel();
        panelRight.setBackground(new Color(0, 204, 204));
        contentPane.add(panelRight);
        panelRight.setLayout(null);

        textFieldUserName = new JTextField();
        textFieldUserName.setForeground(new Color(255, 255, 255));
        textFieldUserName.setFont(new Font("Tahoma", Font.PLAIN, 23));
        textFieldUserName.setBorder(null);
        textFieldUserName.setBackground(new Color(0, 204, 204));
        textFieldUserName.setBounds(78, 135, 344, 38);
        panelRight.add(textFieldUserName);
        textFieldUserName.setColumns(10);

        passwordUser = new JPasswordField();
        passwordUser.setForeground(new Color(255, 255, 255));
        passwordUser.setFont(new Font("Tahoma", Font.PLAIN, 23));
        passwordUser.setBorder(null);
        passwordUser.setBackground(new Color(0, 204, 204));
        passwordUser.setBounds(78, 229, 344, 38);
        panelRight.add(passwordUser);

        JSeparator separatorUserName = new JSeparator();
        separatorUserName.setBackground(new Color(255, 255, 255));
        separatorUserName.setBounds(78, 183, 344, 2);
        panelRight.add(separatorUserName);

        JSeparator separatorPassword = new JSeparator();
        separatorPassword.setBackground(Color.WHITE);
        separatorPassword.setBounds(78, 277, 344, 2);
        panelRight.add(separatorPassword);

        JLabel labelIconUserName = new JLabel("");
        labelIconUserName.setForeground(new Color(0, 0, 0));
        labelIconUserName.setBackground(new Color(255, 255, 255));
        labelIconUserName.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\avatar.png"));
        labelIconUserName.setBounds(25, 158, 43, 38);
        panelRight.add(labelIconUserName);

        JLabel labelIconPassword = new JLabel("");
        labelIconPassword.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\key (1).png"));
        labelIconPassword.setForeground(Color.BLACK);
        labelIconPassword.setBackground(Color.WHITE);
        labelIconPassword.setBounds(25, 252, 43, 38);
        panelRight.add(labelIconPassword);

        JButton buttonLogin = new JButton("\u0110\u0102NG NH\u1EACP");
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.loginAccount();
            }
        });
        buttonLogin.setBorder(null);
        buttonLogin.setBackground(new Color(255, 255, 255));
        buttonLogin.setForeground(new Color(0, 204, 204));
        buttonLogin.setFont(new Font("Tahoma", Font.PLAIN, 19));
        buttonLogin.setBounds(159, 329, 160, 43);
        panelRight.add(buttonLogin);
    }

    public void dipslay() {
        GUI gui = new GUI();
        gui.setTitle("Quản lý bệnh án");
        gui.setSize(1114, 674);
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
    }
}
