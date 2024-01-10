package client.view;

import rmi.IChat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ChatLogin extends JFrame {
    private static IChat chat;
    private JPanel contentPane;
    private JTextField textField;
    private List<String> users = new ArrayList<>();
    private String userName;

    public ChatLogin(IChat chat) {
        init();
        this.chat = chat;
        setLocationRelativeTo(null);
        setSize(393, 519);

        setVisible(true);
    }

    public void init() {
        setBounds(100, 100, 397, 524);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 240, 245));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel labelChatLogin = new JLabel("TR\u00D2 CHUY\u1EC6N TR\u1EF0C TUY\u1EBEN");
        labelChatLogin.setForeground(new Color(0, 128, 128));
        labelChatLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelChatLogin.setBounds(91, 34, 205, 34);
        contentPane.add(labelChatLogin);

        JLabel labelNameChatLogin = new JLabel("NH\u1EACP T\u00CAN ");
        labelNameChatLogin.setForeground(new Color(0, 128, 128));
        labelNameChatLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelNameChatLogin.setBounds(52, 337, 81, 34);
        contentPane.add(labelNameChatLogin);

        textField = new JTextField();
        textField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    userLogin();
                }
            }
        });
        textField.setBounds(48, 375, 295, 48);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton buttonChatLogin = new JButton("\u0110\u0102NG NH\u1EACP");
        buttonChatLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userLogin();
            }
        });
        buttonChatLogin.setForeground(new Color(255, 250, 250));
        buttonChatLogin.setBackground(new Color(0, 128, 128));
        buttonChatLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
        buttonChatLogin.setBounds(48, 443, 102, 34);
        contentPane.add(buttonChatLogin);

        JLabel labelIcon = new JLabel("");
        labelIcon.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\chat.png"));
        labelIcon.setBounds(128, 109, 134, 177);
        contentPane.add(labelIcon);
    }


    private void userLogin() {
        userName = textField.getText().trim();

        try {
            users = chat.getAllUsers();

        } catch (RemoteException e) {
            e.printStackTrace();
        }

        if (users.contains(userName)) {
            JOptionPane.showMessageDialog(null, "Người đùng đã tồn tại");
            textField.setText("");

        } else {
            try {
                new ChatForm(chat, userName);

            } catch (RemoteException e) {
                e.printStackTrace();
            }

            this.setVisible(false);
        }
    }


}

