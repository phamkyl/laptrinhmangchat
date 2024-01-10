package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Server {
    public static void main(String[] args) throws RemoteException {
        Registry reg = LocateRegistry.createRegistry(2605);
        IPatientImp server = new IPatientImp();

        reg.rebind("db", server);
        reg.rebind("chatServer", server);

        System.out.println("Server is running now...");
    }
}
