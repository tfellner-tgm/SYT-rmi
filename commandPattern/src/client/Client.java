package client;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import calculation.EulerCalc;
import calculation.PICalc;
import callback.Callback;
import callback.CallbackBigDecimal;
import remoteService.CommandExecutor;
import server.commands.*;

/**
 * Client Class with main Method.
 *
 * First connect to registry on port 1234,
 * then get the Serivce Object from the Registry
 * then export own Callback Object
 * and then execute the Commands
 * after breaking via enter
 * the callback Object is unexported again
 *
 * @author tfellner
 * @version 28.4.2016
 */
public class Client {

	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {
            //Connect to Server registry on port 1234
			Registry registry = LocateRegistry.getRegistry(1234);

            //get CommandExecutor from registry
			CommandExecutor uRemoteObject = (CommandExecutor) registry.lookup("Service");
			System.out.println("Service found");


            //create callback
            Callback cb = new CallbackBigDecimal();
            //export the Callback
            Callback cbStub = (Callback) UnicastRemoteObject.exportObject(cb, 0);

            //Setup Commands for Calculating Pi and Euler's number
            Command calcPi = new CalculationCommand(cbStub, new PICalc(Integer.parseInt(args[0])));
            Command calcEuler = new CalculationCommand(cbStub, new EulerCalc(300));

            //execute the Commands
            uRemoteObject.executeCommand(calcPi);
            uRemoteObject.executeCommand(calcEuler);

            //hold program until a break is made
            while ( System.in.read() != '\n' );
            //unexport the Callback Object
            UnicastRemoteObject.unexportObject(cb, true);

		} catch (RemoteException re) {
			System.err.println("Error in Service " + re);
			System.exit(1);
		} catch (Exception e) {
			System.err.println("Service exception: " + e);
			System.exit(1);
		}
	}
}
