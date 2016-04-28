package client;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import calculation.PICalc;
import callback.Callback;
import callback.CallbackBigDecimal;
import remoteService.CommandExecutor;
import server.commands.*;

public class Client {

	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {
			Registry registry = LocateRegistry.getRegistry(1234);

			CommandExecutor uRemoteObject = (CommandExecutor) registry.lookup("Service");
			System.out.println("Service found");


            Callback cb = new CallbackBigDecimal();
            Callback cbStub = (Callback) UnicastRemoteObject.exportObject(cb, 0);

            Command calcPi = new CalculationCommand(cbStub, new PICalc(2500));

            uRemoteObject.executeCommand(calcPi);

            while ( System.in.read() != '\n' );
            UnicastRemoteObject.unexportObject(cb, true);

		} catch (RemoteException re) {
			System.err.println("Service not found?" + " Check your RMI-Registry!");
            System.err.println(re.getMessage());
			System.exit(1);
		} catch (Exception e) {
			System.err.println("Service exception:");
			e.printStackTrace();
			System.exit(1);
		}
	}

    public static int factorial(int n) {
        int fact = 1; // this  will be the result
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
