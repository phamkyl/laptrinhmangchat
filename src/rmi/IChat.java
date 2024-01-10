package rmi;

import model.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IChat extends Remote {

    public boolean login (String userName) throws RemoteException;

    public void logOut (String userName) throws RemoteException;

    public void sendMessage (Message message) throws RemoteException;

    public List<Message> getAllMessages () throws RemoteException;

    public List<String> getAllUsers () throws RemoteException;
}
