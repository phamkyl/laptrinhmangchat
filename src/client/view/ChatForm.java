package client.view;

import client.controller.Client;
import model.Message;
import rmi.IChat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;


public class ChatForm  implements MouseListener, KeyListener {

    private JPanel contentPane;
    public JTextField textFieldMessage;
    public String userName;
    public IChat chat;
    public List<Message> messages = new ArrayList<>();
    public List<String> users = new ArrayList<>();
    public JTextArea textAreaUsersOnline;
    public JTextPane textPaneMessage;
    public JLabel labelChatUserName;
    private Client client = new Client(this);
    public JFrame jFrame;

    public ChatForm(IChat chat, String userName) throws RemoteException {

        this.chat = chat;
        init();
        this.userName = userName;
        chat.login(userName);
        client.execute();
    }

    public void init() {
        jFrame = new JFrame();
        jFrame.setBounds(100, 100, 827, 565);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(0, 206, 209));
        jFrame.setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel labelUserOnline = new JLabel("Ng\u01B0\u1EDDi d\u00F9ng tr\u1EF1c tuy\u1EBFn");
        labelUserOnline.setFont(new Font("Tahoma", Font.PLAIN, 19));
        labelUserOnline.setBounds(10, 28, 202, 47);
        contentPane.add(labelUserOnline);

        textAreaUsersOnline = new JTextArea();
        textAreaUsersOnline.setColumns(20);
        textAreaUsersOnline.setRows(5);
        textAreaUsersOnline.setEditable(false);
        textAreaUsersOnline.setBounds(10, 95, 194, 422);
        contentPane.add(textAreaUsersOnline);

        JScrollPane jScrollPane2 = new JScrollPane();
        jScrollPane2.setBounds(10, 95, 194, 422);
        contentPane.add(jScrollPane2);

        jScrollPane2.setViewportView(textAreaUsersOnline);

        labelChatUserName = new JLabel();
        labelChatUserName.setText("Tên");
        labelChatUserName.setFont(new Font("Tahoma", Font.PLAIN, 19));
        labelChatUserName.setBounds(261, 34, 116, 34);
        contentPane.add(labelChatUserName);

        JButton buttonLogOut = new JButton("\u0110\u0102NG XU\u1EA4T");
        buttonLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.logOut();
            }
        });

        buttonLogOut.setForeground(new Color(255, 250, 250));
        buttonLogOut.setBackground(new Color(0, 128, 128));
        buttonLogOut.setFont(new Font("Tahoma", Font.PLAIN, 15));
        buttonLogOut.setBounds(477, 33, 116, 41);
        contentPane.add(buttonLogOut);

        textFieldMessage = new JTextField();
        textFieldMessage.setBounds(224, 471, 243, 47);
        contentPane.add(textFieldMessage);
        textFieldMessage.setColumns(10);

        JButton buttonSendMessage = new JButton("G\u1EECI \u0110I");
        buttonSendMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.sendNewMessage();
            }
        });
        buttonSendMessage.setForeground(new Color(255, 250, 250));
        buttonSendMessage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        buttonSendMessage.setBackground(new Color(0, 128, 128));
        buttonSendMessage.setBounds(479, 469, 116, 47);
        contentPane.add(buttonSendMessage);


        textPaneMessage = new JTextPane();
        textPaneMessage.setEditable(false);
        textPaneMessage.setContentType("text/html");
        textPaneMessage.setText("<html>\n  <head>\n\n  </head>\n  <body>\n    <p style=\"margin-top: 0\">\n      <h1 color='red'>Viji</h1>\n    </p>\n  </body>\n</html>\n");
        textPaneMessage.setBounds(214, 95, 395, 364);
        contentPane.add(textPaneMessage);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(214, 95, 395, 364);
        contentPane.add(scrollPane);

        scrollPane.setViewportView(textPaneMessage);

        JPanel panelIcons = new JPanel();
        panelIcons.setBackground(Color.WHITE);
        panelIcons.setBounds(621, 95, 183, 422);
        contentPane.add(panelIcons);
        panelIcons.setLayout(null);

        JLabel labelIcon1 = new JLabel("");
        labelIcon1.setBounds(10, 26, 64, 64);
        panelIcons.add(labelIcon1);
        labelIcon1.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\emoji.png"));

        JLabel labelIcon2 = new JLabel("");
        labelIcon2.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\emoji (1).png"));
        labelIcon2.setBounds(109, 26, 64, 64);
        panelIcons.add(labelIcon2);

        JLabel labelIcon3 = new JLabel("");
        labelIcon3.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\emoji (2).png"));
        labelIcon3.setBounds(10, 134, 64, 64);
        panelIcons.add(labelIcon3);

        JLabel labelIcon4 = new JLabel("");
        labelIcon4.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\emoji (3).png"));
        labelIcon4.setBounds(109, 134, 64, 64);
        panelIcons.add(labelIcon4);

        JLabel labelIcon5 = new JLabel("");
        labelIcon5.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\emoji (4).png"));
        labelIcon5.setBounds(10, 230, 64, 64);
        panelIcons.add(labelIcon5);

        JLabel labelIcon6 = new JLabel("");
        labelIcon6.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\emoji (5).png"));
        labelIcon6.setBounds(109, 230, 64, 64);
        panelIcons.add(labelIcon6);

        JLabel labelIcon7 = new JLabel("");
        labelIcon7.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\emoji (6).png"));
        labelIcon7.setBounds(10, 334, 64, 64);
        panelIcons.add(labelIcon7);

        JLabel labelIcon8 = new JLabel("");
        labelIcon8.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\emoji (7).png"));
        labelIcon8.setBounds(109, 334, 64, 64);
        panelIcons.add(labelIcon8);


        jFrame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                client.logOut();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        client.mouseListener();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void addListeners() {
        textFieldMessage.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            client.sendNewMessage();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}

