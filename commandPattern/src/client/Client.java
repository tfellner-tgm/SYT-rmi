package client;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import calculation.PICalc;
import callback.Callback;
import callback.CallbackPi;
import remoteService.DoSomethingService;
import server.commands.*;

public class Client {

	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {
			Registry registry = LocateRegistry.getRegistry(1234);

			DoSomethingService uRemoteObject = (DoSomethingService) registry.lookup("Service");
			System.out.println("Service found");

			Command rc = new RegisterCommand();
			Command lc = new LoginCommand();
            Command pi = new PiCommand(new Integer(400));

			uRemoteObject.doSomething(rc);
			uRemoteObject.doSomething(lc);
            uRemoteObject.doSomething(pi);


            Callback cb = new CallbackPi();
            Callback cbStub = (Callback) UnicastRemoteObject.exportObject(cb, 0);


            Command calcPi = new CalculationCommand(cbStub, new PICalc(300));

            uRemoteObject.doSomething(calcPi);

		} catch (RemoteException re) {
			System.err.println("Service not found?" + " Check your RMI-Registry!");
			System.exit(1);
		} catch (Exception e) {
			System.err.println("Service exception:");
			e.printStackTrace();
			System.exit(1);
		}
	}
}
