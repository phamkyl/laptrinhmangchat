package server;

import model.Message;
import model.Patient;
import model.PatientStartEntry;
import rmi.IChat;
import rmi.IPatient;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IPatientImp extends UnicastRemoteObject implements IPatient, IChat, Serializable {
    private Connection conn;
    private List<String> users = new ArrayList<>();
    private List<Message> messages = new ArrayList<>();

    public IPatientImp() throws RemoteException {
        super();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=finalProject;user=sa;password=thithanh2605");

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public boolean loginPatient(String userName, String password) throws RemoteException {
        try {
            String query = "select * from loginAccount where userName='" + userName + "' and _password='" + password + "'";

            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(query);

            if (rs.next()) {
                return true;
            } else {
                return false;
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


    @Override
    public synchronized String deletePatient(int id) throws RemoteException {
        try {

            Statement statement = conn.createStatement();
            String sql = "delete from patient where numberCode='" + id + "'";

            statement.executeUpdate(sql);
            return "Record Delete Successfully";

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public synchronized String insertPatient(int numberCode, String namePatient, String homeTown, String diagnostic, java.util.Date dateCome, java.util.Date dateOut) throws RemoteException {
        try {
            Statement statement = conn.createStatement();
            String sql = "insert into patient (numberCode,namePatient,_address,diagnostic,dateCome,dateOut) values ('"
                    + numberCode + "',N'" + namePatient + "',N'" + homeTown + "',N'" + diagnostic + "',N'" + dateCome + "','"
                    + dateOut + "')";
            statement.executeUpdate(sql);

            return "Record Insert Successfully";


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return "Record Insert Not Successfully";
    }

    @Override
    public synchronized String updatePatient(int numberCode, String namePatient, String homeTown, String diagnostic, java.util.Date dateCome, java.util.Date dateOut) throws RemoteException {
        try {
            Statement statement = conn.createStatement();
            String sql = " update patient set namePatient=N'" + namePatient
                    + "',_address=N'" + homeTown + "',diagnostic=N'" + diagnostic + "',dateCome='" + dateCome + "',dateOut='"
                    + dateOut + "' where numberCode='" + numberCode + "'";

            statement.executeUpdate(sql);

            return "Record Update Successfully";


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public synchronized List<Patient> searchPatient(String name) throws RemoteException {

        List<Patient> patientList = new ArrayList<>();

        try {

            Statement statement = conn.createStatement();
            String sql = "select * from patient where namePatient like N'%" + name + "%' or _address like N'%" +
                    name + "%' or diagnostic like N'%" + name + "%' or dateCome like N'%" +
                    name + "%' or dateOut like N'%" + name + "%' or numberCode like N'%" +
                    name + "%'";

            ResultSet resultSet = statement.executeQuery(sql);

            Patient patient;

            while (resultSet.next()) {

                patient = new Patient(resultSet.getInt("numberCode"),
                        resultSet.getString("namePatient"),
                        resultSet.getString("_address"),
                        resultSet.getString("diagnostic"),
                        resultSet.getDate("dateCome"),
                        resultSet.getDate("dateOut"));

                patientList.add(patient);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return patientList;
    }

    @Override
    public synchronized List<Patient> showUpJTable() throws RemoteException {
        List<Patient> listPatient = new ArrayList<>();

        try {

            Statement statement = conn.createStatement();

            String query = "select * from patient";

            ResultSet resultSet = statement.executeQuery(query);

            Patient patient;

            while (resultSet.next()) {
                patient = new Patient(resultSet.getInt("numberCode"),
                        resultSet.getString("namePatient"),
                        resultSet.getString("_address"),
                        resultSet.getString("diagnostic"),
                        resultSet.getDate("dateCome"),
                        resultSet.getDate("dateOut"));

                listPatient.add(patient);


            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPatient;
    }

    @Override
    public List<PatientStartEntry> chart() throws RemoteException {
        List<PatientStartEntry> listChart = new ArrayList<>();

        try {
            Statement statement = conn.createStatement();
            String query = "select month(p.dateCome) as _month, count(*) as _count from patient as p group by month(p.dateCome)";

            ResultSet resultSet = statement.executeQuery(query);

            PatientStartEntry patientStartEntry;

            while (resultSet.next()) {
                patientStartEntry = new PatientStartEntry(
                        resultSet.getInt("_month"),
                        resultSet.getInt("_count"));

                listChart.add(patientStartEntry);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listChart;
    }


    @Override
    public boolean login(String username) throws RemoteException {
        boolean flag = false;
        for (String user : users) {
            if (username.equals(user)) {
                flag = true;
                break;
            } else {
                flag = false;
            }
        }
        if (flag == false) {
            users.add(username);
            Message message = new Message();
            message.setUserName(username);
            message.setMessage(" tham gia cuộc trò chuyện ");
            message.setType("tham gia");
            message.setDate(new java.util.Date());
            messages.add(message);

            return true;
        } else {
            return false;
        }
    }

    @Override
    public void logOut(String userName) throws RemoteException {
        users.remove(userName);
        Message message = new Message();
        message.setUserName(userName);
        message.setMessage(" rời cuộc trò chuyện ");
        message.setType("rời khỏi");
        message.setDate(new Date());
        messages.add(message);

    }


    @Override
    public void sendMessage(Message message) throws RemoteException {
        messages.add(message);
    }

    @Override
    public List<Message> getAllMessages() throws RemoteException {
        for (Message m : messages) {
            System.out.println(m.getUserName() + " " + m.getMessage());
        }
        return messages;
    }

    @Override
    public List<String> getAllUsers() throws RemoteException {
        for (String u : users) {
            System.out.println(u);
        }
        return users;
    }

}
