package Servidor;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


	public class Servidor {

		public Servidor() throws RemoteException {
	        try {
	           LocateRegistry.createRegistry(1234);
	           Naming.rebind("rmi://localhost:1234/produtos", new Controle());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public static void main(String[] args) throws RemoteException {
	       new Servidor();
	    }
		
	}
	