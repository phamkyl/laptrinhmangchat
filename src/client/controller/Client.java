package client.controller;

import client.view.ChatForm;
import client.view.ChatLogin;
import client.view.GUI;
import client.view.Login;
import model.Message;
import model.Patient;
import model.PatientStartEntry;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import rmi.IChat;
import rmi.IPatient;
import utils.DateUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.net.MalformedURLException;
import java.rmi.Naming;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Client {
    private GUI gui;
    private ChatForm chatForm;
    private Login login;

    private List<Patient> list;
    public static final String COUNT_ROW_KEY = "Số lần khám";

    public Client(GUI gui) {
        this.gui = gui;
    }

    public Client(ChatForm chatForm) {
        this.chatForm = chatForm;
    }

    public Client(Login login) {
        this.login = login;
    }

    public void loginAccount() {
        String userName = login.textFieldUserName.getText().trim();
        String password = String.valueOf(login.passwordUser.getPassword()).trim();

        try {
            IPatient iPatient = (IPatient) Naming.lookup("rmi://localhost:2605/db");

            boolean result = iPatient.loginPatient(userName, password);

            if (result) {
                login.dispose();
                login.dipslay();

            } else {
                JOptionPane.showMessageDialog(null, "Đăng nhập không thành công");
                login.textFieldUserName.setText("");
                login.passwordUser.setText("");

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }

    public void insertPatient() {
        try {
            if (gui.textFieldNumberCode.getText().length() != 0 &&
                    gui.textFieldName.getText().length() != 0 &&
                    gui.textFieldHomeTown.getText().length() != 0 &&
                    gui.textFieldDiagnostic.getText().length() != 0 &&
                    gui.dateCome.getDate() != null &&
                    gui.dateOut.getDate() != null) {

                int numberCode = Integer.parseInt(gui.textFieldNumberCode.getText().trim());
                String namePatient = gui.textFieldName.getText().trim();
                String homeTown = gui.textFieldHomeTown.getText().trim();
                String diagnostic = gui.textFieldDiagnostic.getText().trim();
                Date dateCome = DateUtils.convertUtilDate2SqlDate(gui.dateCome.getDate());
                Date dateOut = DateUtils.convertUtilDate2SqlDate(gui.dateOut.getDate());

                IPatient iPatient = (IPatient) Naming.lookup("rmi://localhost:2605/db");

                String result = iPatient.insertPatient(numberCode, namePatient, homeTown, diagnostic, dateCome, dateOut);

                show();

                if (result.equals("Record Insert Successfully")) {
                    JOptionPane.showMessageDialog(null, result, " Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, result, " Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        reset();
    }

    public void deletePatient() {
        try {
            if (!(gui.textFieldNumberCode.getText().equals(""))) {
                int numberCode = Integer.parseInt(gui.textFieldNumberCode.getText().trim());

                IPatient iPatient = (IPatient) Naming.lookup("rmi://localhost:2605/db");

                String result = iPatient.deletePatient(numberCode);

                show();

                JOptionPane.showMessageDialog(null, result, " Success", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);

        }

        reset();
    }

    public void updatePatient() {
        try {
            if (gui.textFieldNumberCode.getText().length() != 0 &&
                    gui.textFieldName.getText().length() != 0 &&
                    gui.textFieldHomeTown.getText().length() != 0 &&
                    gui.textFieldDiagnostic.getText().length() != 0 &&
                    gui.dateCome.getDate() != null &&
                    gui.dateOut.getDate() != null) {

                int numberCode = Integer.parseInt(gui.textFieldNumberCode.getText().trim());
                String namePatient = gui.textFieldName.getText().trim();
                String homeTown = gui.textFieldHomeTown.getText().trim();
                String diagnostic = gui.textFieldDiagnostic.getText().trim();
                Date dateCome = DateUtils.convertUtilDate2SqlDate(gui.dateCome.getDate());
                Date dateOut = DateUtils.convertUtilDate2SqlDate(gui.dateOut.getDate());

                IPatient iPatient = (IPatient) Naming.lookup("rmi://localhost:2605/db");

                String result = iPatient.updatePatient(numberCode, namePatient, homeTown, diagnostic, dateCome, dateOut);

                show();

                JOptionPane.showMessageDialog(null, result, " Success", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }

        reset();

    }

    public void searchPatient() {

        List<Patient> listPatient;

        try {
            String namePatient = gui.textFieldSearch.getText().trim();

            IPatient iPatient = (IPatient) Naming.lookup("rmi://localhost:2605/db");

            listPatient = iPatient.searchPatient(namePatient);

            DefaultTableModel model = (DefaultTableModel) gui.tableSearch.getModel();

            model.setRowCount(0);

            Object[] rows = new Object[6];

            for (int i = 0; i < listPatient.size(); i++) {

                rows[0] = listPatient.get(i).getNumberCode();
                rows[1] = listPatient.get(i).getNamePatient();
                rows[2] = listPatient.get(i).getHomeTown();
                rows[3] = listPatient.get(i).getDiagnostic();
                rows[4] = listPatient.get(i).getDateCome();
                rows[5] = listPatient.get(i).getDateOut();

                model.addRow(rows);
            }

            gui.tableSearch.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void reset() {
        gui.textFieldNumberCode.setText("");
        gui.textFieldName.setText("");
        gui.textFieldHomeTown.setText("");
        gui.textFieldDiagnostic.setText("");
        gui.dateCome.setDate(Calendar.getInstance().getTime());
        gui.dateOut.setDate(Calendar.getInstance().getTime());
    }

    public void show() {

        try {
            IPatient iPatient = (IPatient) Naming.lookup("rmi://localhost:2605/db");

            list = iPatient.showUpJTable();

            DefaultTableModel model = new DefaultTableModel();

            model.setRowCount(0);

            Object[] columns = new Object[6];
            columns[0] = "Mã Bảo Hiểm";
            columns[1] = "Tên Bệnh Nhân";
            columns[2] = "Địa chỉ";
            columns[3] = "Chuẩn Đoán";
            columns[4] = "Ngày Khám";
            columns[5] = "Ngày Ra Viện";

            model.setColumnIdentifiers(columns);

            Object[] rows = new Object[6];

            for (int i = 0; i < list.size(); i++) {

                rows[0] = list.get(i).getNumberCode();
                rows[1] = list.get(i).getNamePatient();
                rows[2] = list.get(i).getHomeTown();
                rows[3] = list.get(i).getDiagnostic();
                rows[4] = list.get(i).getDateCome();
                rows[5] = list.get(i).getDateOut();

                model.addRow(rows);

            }

            gui.table.setModel(model);
            gui.tableSearch.setModel(model);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showDataJTable(int index) {
        gui.textFieldNumberCode.setText(String.valueOf(list.get(index).getNumberCode()));
        gui.textFieldName.setText(list.get(index).getNamePatient());
        gui.textFieldHomeTown.setText(list.get(index).getHomeTown());
        gui.textFieldDiagnostic.setText(list.get(index).getDiagnostic());
        gui.dateCome.setDate(list.get(index).getDateCome());
        gui.dateOut.setDate(list.get(index).getDateOut());

    }

    static final List<String> ALL_MONTH_NAME = Arrays.asList(
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
    );

    public void chart() {
        List<PatientStartEntry> patientStartEntries;

        try {
            IPatient iPatient = (IPatient) Naming.lookup("rmi://localhost:2605/db");

            patientStartEntries = iPatient.chart();

            DefaultCategoryDataset barCharDate = new DefaultCategoryDataset();

            // init empty month
            for (String e : ALL_MONTH_NAME) {
                barCharDate.setValue(0, COUNT_ROW_KEY, e);
            }

            // init fill data
            for (PatientStartEntry e : patientStartEntries) {
                int monthIndex = e.getMonth();
                String monthName = ALL_MONTH_NAME.get(monthIndex - 1);
                barCharDate.setValue(e.getCount(), COUNT_ROW_KEY, monthName);
            }

            JFreeChart chart = ChartFactory.createBarChart("Thống kê", "Tháng", "Số lượng",
                    barCharDate, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot barChartCategory = chart.getCategoryPlot();
            barChartCategory.setRangeGridlinePaint(Color.BLUE);

            ChartPanel chartPanel = new ChartPanel(chart);

            gui.panelBarChart.removeAll();
            gui.panelBarChart.add(chartPanel);
            gui.panelBarChart.revalidate();
            gui.panelBarChart.repaint();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //    CHAT ROOM
    public void logOut() {
        try {
            chatForm.chat.logOut(chatForm.userName);
            chatForm.jFrame.dispose();
//            System.exit(0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void execute() {
        chatForm.textAreaUsersOnline.setLineWrap(true);
        chatForm.jFrame.setTitle("Public Chat");
        chatForm.addListeners();
        chatForm.labelChatUserName.setText(chatForm.userName);
        chatForm.jFrame.setVisible(true);
        chatForm.jFrame.setSize(828, 567);
        chatForm.jFrame.setLocationRelativeTo(null);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    refresh();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        t1.start();
    }

//    public void executed2 () {
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    refresh2();
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException ex) {
//                        ex.printStackTrace();
//                    }
//                }
//            }
//        });
//        t1.start();
//    }

    public void displayChatList() throws RemoteException {
        chatForm.textPaneMessage.setText("");
        chatForm.messages = chatForm.chat.getAllMessages();
        String doc = "<html><body><table>";
        for (Message m : chatForm.messages) {
            if (!((m.getUserName().equals(chatForm.userName)) && (m.getType().equals("tham gia")))) {
                Date date = m.getDate();
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String a = dateFormat.format(date);
                SimpleDateFormat parseFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                SimpleDateFormat printFormat = new SimpleDateFormat("HH:mm:ss");
                try {
                    Date time = parseFormat.parse(a);
                    doc += "<tr><td>"
                            + printFormat.format(time)
                            + "</td><td><font color='rgb(55,178,204)'><b>"
                            + m.getUserName()
                            + "</b></font></td><td> "
                            + m.getMessage()
                            + "</td></tr>";
                } catch (ParseException ex) {
                    ex.printStackTrace();
//                    Logger.getLogger(ChatForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        doc += "</table></body></html>";
        chatForm.textPaneMessage.setText(doc);
    }

    private void displayUserList() throws RemoteException {
        chatForm.textAreaUsersOnline.setText("");
        chatForm.users = chatForm.chat.getAllUsers();
        for (String u : chatForm.users) {
            if (!u.equals(chatForm.userName)) {
                chatForm.textAreaUsersOnline.append(" " + u + "\n");
            }
        }
    }

//    public void refresh2() {
//        show();
//    }


    public void refresh() {
        try {
            displayChatList();
            displayUserList();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }


    public void sendNewMessage() {
        String inputMessage = chatForm.textFieldMessage.getText();
        chatForm.textFieldMessage.setText("");
        Message message = new Message();
        message.setUserName(chatForm.userName);
        message.setMessage(inputMessage);
        message.setType("client");
        message.setDate(new Date());
        try {
            chatForm.chat.sendMessage(message);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

    public void mouseListener() {
        Message message = new Message();
        message.setUserName(chatForm.userName);
        message.setType("client");
        message.setDate(new Date());

        try {
            chatForm.chat.sendMessage(message);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

    public void showUpChatRoom() throws MalformedURLException, NotBoundException, RemoteException {
        IChat iChat = (IChat) Naming.lookup("rmi://localhost:2605/chatServer");
        new ChatLogin(iChat);
    }
}
