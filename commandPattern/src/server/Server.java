package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import remoteService.CommandExecutor;

/**
 * Server Class with main Method.
 *
 * First create Service Object and
 * export the stub
 * Create Registry on Port and bind the stub object to "Service"
 * Unexport Service Object again after breaking via enter
 *
 * @author tfellner
 * @version 26.4.2016
 */
public class Server {

	public static void main(String[] args) {

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {
			//Create Service Object
			ServerService uRemoteObject = new ServerService();

            //export Object
			CommandExecutor stub = (CommandExecutor) UnicastRemoteObject.exportObject(uRemoteObject, 0);

            //create Registry on port 1234
			Registry registry = LocateRegistry.createRegistry(1234);

            //bind "Service" to stub object for other Clients to use
			registry.rebind("Service", stub);
			System.out.println("Service bound! Press Enter to terminate ...");

			while ( System.in.read() != '\n' );
			//unexport the object
            UnicastRemoteObject.unexportObject(uRemoteObject, true);

			System.out.println("Service unbound, System goes down ...");

		} catch (RemoteException re) {
			System.err.println("Service already bound?" + " Check your RMI-Registry settings!");
			re.printStackTrace();
			System.exit(1);
		} catch (Exception e) {
			System.err.println("Service exception:");
			e.printStackTrace();
			System.exit(1);
		}

	}

}
