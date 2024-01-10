package client.view;


import client.controller.Client;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import java.awt.event.*;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class GUI extends JFrame {
    private JPanel contentPane;
    public JLabel menuLabels[];
    public JPanel menuPanels[];
    public JPanel panelLeft;
    public JPanel panelRight;
    public JPanel panelSearch;
    public JPanel panelManagement;
    public JPanel panelChart;
    public JTextField textFieldDiagnostic;
    public JDateChooser dateOut;
    public JTextField textFieldHomeTown;
    public JTextField textFieldNumberCode;
    public JTextField textFieldName;
    public JDateChooser dateCome;
    public JTable table;
    public JTable tableSearch;
    public JTextField textFieldSearch;
    public JPanel panelBarChart;
    public JLabel labelHome;

    public JButton buttonAdd;
    private Client client = new Client(this);

    private AddActionView bgColor = new AddActionView(this);

    public GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1114, 679);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

//        client.executed2();

        panelLeft = new JPanel();
        panelLeft.setBackground(new Color(32, 178, 170));
        panelLeft.setBounds(0, 0, 251, 652);
        contentPane.add(panelLeft);
        panelLeft.setLayout(null);

        labelHome = new JLabel("TRANG CHỦ");
        labelHome.setBackground(new Color(32, 178, 170));
        labelHome.setOpaque(true);
        labelHome.setForeground(new Color(255, 250, 250));
        labelHome.setHorizontalAlignment(SwingConstants.CENTER);
        labelHome.setFont(new Font("Tahoma", Font.PLAIN, 23));
        labelHome.setBounds(0, 50, 251, 63);
        panelLeft.add(labelHome);

        JLabel labelPatient = new JLabel("TÌM KIẾM");
        labelPatient.setBackground(new Color(32, 178, 170));
        labelPatient.setOpaque(true);
        labelPatient.setHorizontalAlignment(SwingConstants.CENTER);
        labelPatient.setForeground(new Color(255, 250, 250));
        labelPatient.setFont(new Font("Tahoma", Font.PLAIN, 23));
        labelPatient.setBounds(0, 163, 251, 63);
        panelLeft.add(labelPatient);

        JLabel labelManagement = new JLabel("BỆNH ÁN");
        labelManagement.setBackground(new Color(32, 178, 170));
        labelManagement.setOpaque(true);
        labelManagement.setHorizontalAlignment(SwingConstants.CENTER);
        labelManagement.setForeground(new Color(255, 250, 250));
        labelManagement.setFont(new Font("Tahoma", Font.PLAIN, 23));
        labelManagement.setBounds(0, 284, 251, 63);
        panelLeft.add(labelManagement);

        JLabel labelChart = new JLabel("THỐNG KÊ");
        labelChart.setBackground(new Color(32, 178, 170));
        labelChart.setOpaque(true);
        labelChart.setHorizontalAlignment(SwingConstants.CENTER);
        labelChart.setForeground(new Color(255, 250, 250));
        labelChart.setFont(new Font("Tahoma", Font.PLAIN, 23));
        labelChart.setBounds(0, 407, 251, 63);
        panelLeft.add(labelChart);

        JLabel labelChatRoom = new JLabel("PHÒNG TRÒ CHUYỆN");
        labelChatRoom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    client.showUpChatRoom();
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                } catch (NotBoundException ex) {
                    ex.printStackTrace();
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
            }
        });


        labelChatRoom.setOpaque(true);
        labelChatRoom.setHorizontalAlignment(SwingConstants.CENTER);
        labelChatRoom.setForeground(new Color(255, 250, 250));
        labelChatRoom.setFont(new Font("Tahoma", Font.PLAIN, 23));
        labelChatRoom.setBackground(new Color(32, 178, 170));
        labelChatRoom.setBounds(0, 523, 251, 63);
        panelLeft.add(labelChatRoom);

        panelRight = new JPanel();
        panelRight.setBounds(246, 0, 854, 652);
        contentPane.add(panelRight);
        panelRight.setLayout(null);

        panelSearch = new JPanel();
        panelSearch.setBackground(new Color(175, 238, 238));
        panelSearch.setLayout(null);
        panelSearch.setBounds(246, 0, 854, 652);
        contentPane.add(panelSearch);

        panelManagement = new JPanel();
        panelManagement.setLayout(null);
        panelManagement.setBackground(new Color(175, 238, 238));
        panelManagement.setBounds(246, 0, 854, 652);
        contentPane.add(panelManagement);

        panelChart = new JPanel();
        panelChart.setLayout(null);
        panelChart.setBackground(new Color(175, 238, 238));
        panelChart.setBounds(246, 0, 854, 652);
        contentPane.add(panelChart);


        //        TRANG CHỦ
        JLabel labelHomeBackground = new JLabel("New label");
        labelHomeBackground.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\image-background.jpg"));
        labelHomeBackground.setBounds(0, 0, 854, 508);
        panelRight.add(labelHomeBackground);

        JLabel labelManagers = new JLabel("Người quản lý");
        labelManagers.setForeground(Color.GRAY);
        labelManagers.setFont(new Font("Tahoma", Font.BOLD, 24));
        labelManagers.setBounds(570, 518, 180, 34);
        panelRight.add(labelManagers);

        JLabel labelManagerName = new JLabel("TTYPĐ");
        labelManagerName.setHorizontalAlignment(SwingConstants.CENTER);
        labelManagerName.setForeground(new Color(255, 127, 80));
        labelManagerName.setFont(new Font("Tahoma", Font.BOLD, 26));
        labelManagerName.setBounds(525, 574, 264, 34);
        panelRight.add(labelManagerName);

        JSeparator separatorHome = new JSeparator();
        separatorHome.setForeground(Color.WHITE);
        separatorHome.setBackground(new Color(0, 128, 128));
        separatorHome.setBounds(506, 562, 315, 2);
        panelRight.add(separatorHome);

//        ĐÓNG TRANG CHỦ

        // MEDICAL MANAGEMENT

        JLabel labelInfoManage = new JLabel("THÔNG TIN BỆNH ÁN");
        labelInfoManage.setFont(new Font("Tahoma", Font.PLAIN, 19));
        labelInfoManage.setForeground(Color.DARK_GRAY);
        labelInfoManage.setBounds(349, 10, 209, 52);
        panelManagement.add(labelInfoManage);

        JLabel labelNumberCode = new JLabel("Mã số bảo hiểm");
        labelNumberCode.setForeground(Color.DARK_GRAY);
        labelNumberCode.setFont(new Font("Tahoma", Font.PLAIN, 19));
        labelNumberCode.setBounds(10, 76, 150, 52);
        panelManagement.add(labelNumberCode);

        textFieldNumberCode = new JTextField();
        textFieldNumberCode.setBounds(156, 81, 250, 52);
        panelManagement.add(textFieldNumberCode);
        textFieldNumberCode.setColumns(10);

        JLabel labelHometown = new JLabel("Quê quán");
        labelHometown.setForeground(Color.DARK_GRAY);
        labelHometown.setFont(new Font("Tahoma", Font.PLAIN, 19));
        labelHometown.setBounds(10, 152, 150, 52);
        panelManagement.add(labelHometown);

        textFieldHomeTown = new JTextField();
        textFieldHomeTown.setColumns(10);
        textFieldHomeTown.setBounds(156, 157, 250, 52);
        panelManagement.add(textFieldHomeTown);

        JLabel labelName = new JLabel("Tên bệnh nhân");
        labelName.setForeground(Color.DARK_GRAY);
        labelName.setFont(new Font("Tahoma", Font.PLAIN, 19));
        labelName.setBounds(427, 76, 150, 52);
        panelManagement.add(labelName);

        textFieldName = new JTextField();
        textFieldName.setColumns(10);
        textFieldName.setBounds(569, 81, 250, 52);
        panelManagement.add(textFieldName);

        JLabel labelDiagnostic = new JLabel("Chuẩn đoán");
        labelDiagnostic.setForeground(Color.DARK_GRAY);
        labelDiagnostic.setFont(new Font("Tahoma", Font.PLAIN, 19));
        labelDiagnostic.setBounds(427, 152, 150, 52);
        panelManagement.add(labelDiagnostic);

        textFieldDiagnostic = new JTextField();
        textFieldDiagnostic.setColumns(10);
        textFieldDiagnostic.setBounds(569, 157, 250, 52);
        panelManagement.add(textFieldDiagnostic);

        JLabel labelDateCome = new JLabel("Ngày vào viện");
        labelDateCome.setForeground(Color.DARK_GRAY);
        labelDateCome.setFont(new Font("Tahoma", Font.PLAIN, 19));
        labelDateCome.setBounds(10, 227, 150, 52);
        panelManagement.add(labelDateCome);

        dateCome = new JDateChooser();
        dateCome.setBounds(156, 232, 250, 52);
        panelManagement.add(dateCome);

        JLabel labelDateOut = new JLabel("Ngày ra viện");
        labelDateOut.setForeground(Color.DARK_GRAY);
        labelDateOut.setFont(new Font("Tahoma", Font.PLAIN, 19));
        labelDateOut.setBounds(427, 227, 150, 52);
        panelManagement.add(labelDateOut);

        dateOut = new JDateChooser();
        dateOut.setBounds(569, 232, 250, 52);
        panelManagement.add(dateOut);

        JSeparator separatorTwo = new JSeparator();
        separatorTwo.setBounds(10, 294, 834, 2);
        panelManagement.add(separatorTwo);

        JSeparator separatorOne = new JSeparator();
        separatorOne.setBounds(285, 60, 343, 2);
        panelManagement.add(separatorOne);

        buttonAdd = new JButton("THÊM");
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.insertPatient();
            }
        });
        buttonAdd.setFont(new Font("Tahoma", Font.PLAIN, 19));
        buttonAdd.setBackground(new Color(0, 128, 128));
        buttonAdd.setForeground(new Color(255, 250, 250));
        buttonAdd.setBounds(50, 556, 150, 41);
        panelManagement.add(buttonAdd);

        JButton buttonDelete = new JButton("XÓA");
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.deletePatient();
            }
        });
        buttonDelete.setForeground(new Color(255, 250, 250));
        buttonDelete.setFont(new Font("Tahoma", Font.PLAIN, 19));
        buttonDelete.setBackground(new Color(0, 128, 128));
        buttonDelete.setBounds(461, 556, 150, 41);
        panelManagement.add(buttonDelete);

        JButton buttonMofify = new JButton("CHỈNH SỬA");
        buttonMofify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.updatePatient();
            }
        });
        buttonMofify.setForeground(new Color(255, 250, 250));
        buttonMofify.setFont(new Font("Tahoma", Font.PLAIN, 19));
        buttonMofify.setBackground(new Color(0, 128, 128));
        buttonMofify.setBounds(256, 556, 150, 41);
        panelManagement.add(buttonMofify);

        JButton btnChnhSa = new JButton("HỦY");
        btnChnhSa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.reset();
            }
        });
        btnChnhSa.setForeground(new Color(255, 250, 250));
        btnChnhSa.setFont(new Font("Tahoma", Font.PLAIN, 19));
        btnChnhSa.setBackground(new Color(0, 128, 128));
        btnChnhSa.setBounds(669, 556, 150, 41);
        panelManagement.add(btnChnhSa);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = table.getSelectedRow();
                client.showDataJTable(index);
            }
        });
        table.setBounds(26, 317, 805, 211);

        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(26, 317, 805, 211);
        panelManagement.add(jScrollPane);

        //PATIENT SEARCH MANAGEMENT

        JLabel labelSearch = new JLabel("TÌM KIẾM");
        labelSearch.setFont(new Font("Tahoma", Font.PLAIN, 19));
        labelSearch.setBounds(392, 10, 94, 106);
        panelSearch.add(labelSearch);

        JSeparator separatorSearch = new JSeparator();
        separatorSearch.setBounds(273, 91, 347, 2);
        panelSearch.add(separatorSearch);

        JLabel labelNamePatient = new JLabel("Nhập tên bệnh nhân");
        labelNamePatient.setFont(new Font("Tahoma", Font.PLAIN, 19));
        labelNamePatient.setBounds(49, 142, 196, 36);
        panelSearch.add(labelNamePatient);

        textFieldSearch = new JTextField();
        textFieldSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                client.searchPatient();
            }
        });
        textFieldSearch.setBounds(236, 133, 434, 54);
        panelSearch.add(textFieldSearch);
        textFieldSearch.setColumns(10);

        tableSearch = new JTable();
        tableSearch.setBounds(60, 260, 778, 360);
        panelSearch.add(tableSearch);

        JScrollPane jScrollPaneSearch = new JScrollPane();
        jScrollPaneSearch.setBounds(49, 260, 778, 360);
        panelSearch.add(jScrollPaneSearch);
        jScrollPaneSearch.setViewportView(tableSearch);

        JSeparator separatorSearchTable = new JSeparator();
        separatorSearchTable.setBounds(35, 248, 809, 2);
        panelSearch.add(separatorSearchTable);

        JLabel lblBngTmKim = new JLabel("BẢNG TÌM KIẾM");
        lblBngTmKim.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblBngTmKim.setBounds(372, 188, 156, 62);
        panelSearch.add(lblBngTmKim);


        // CLOSE MEDICAL SEARCH MANAGEMENT

        //OPEN CHART BAR CHART
        JLabel labelBarChart = new JLabel("THỐNG KÊ SỐ LƯỢNG KHÁM THEO THÁNG");
        labelBarChart.setFont(new Font("Tahoma", Font.PLAIN, 19));
        labelBarChart.setBounds(253, 24, 370, 66);
        panelChart.add(labelBarChart);

        JSeparator separatorBarChart = new JSeparator();
        separatorBarChart.setBounds(300, 86, 281, 2);
        panelChart.add(separatorBarChart);

        panelBarChart = new JPanel();
        panelBarChart.setBounds(25, 126, 807, 423);
        panelChart.add(panelBarChart);

        JButton buttonBarChart = new JButton("THỐNG KÊ");
        buttonBarChart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.chart();
            }
        });
        buttonBarChart.setForeground(new Color(255, 250, 250));
        buttonBarChart.setBackground(new Color(0, 128, 128));
        buttonBarChart.setFont(new Font("Tahoma", Font.PLAIN, 19));
        buttonBarChart.setBounds(365, 578, 142, 38);
        panelChart.add(buttonBarChart);

        //CLOSE BAR CHART

        menuLabels = new JLabel[5];
        menuLabels[0] = labelHome;
        menuLabels[1] = labelPatient;
        menuLabels[2] = labelManagement;
        menuLabels[3] = labelChart;
        menuLabels[4] = labelChatRoom;

        menuPanels = new JPanel[4];
        menuPanels[0] = panelRight;
        menuPanels[1] = panelSearch;
        menuPanels[2] = panelManagement;
        menuPanels[3] = panelChart;

        labelHome.getText().trim();
        labelPatient.getText().trim();
        labelManagement.getText().trim();
        labelChart.getText().trim();
        labelChatRoom.getText().trim();

        bgColor.addToMenuLabel();

        client.show();


    }

}


