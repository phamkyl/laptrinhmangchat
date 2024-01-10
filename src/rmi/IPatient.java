package rmi;

import model.Patient;
import model.PatientStartEntry;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

public interface IPatient extends Remote {

    public String deletePatient(int id) throws RemoteException;

    public String insertPatient(int numberCode, String namePatient, String homeTown
            , String diagnostic, Date dateCome, Date dateOut) throws RemoteException;

    public String updatePatient (int numberCode, String namePatient, String homeTown
            , String diagnostic, Date dateCome, Date dateOut) throws RemoteException;

    public List<Patient> searchPatient (String name) throws RemoteException;

    public List<Patient> showUpJTable () throws RemoteException;

    public List<PatientStartEntry> chart () throws RemoteException;

    public boolean loginPatient (String userName, String password) throws RemoteException;


}
