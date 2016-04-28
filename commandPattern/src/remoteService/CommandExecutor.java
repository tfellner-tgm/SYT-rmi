package remoteService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import server.commands.Command;

public interface CommandExecutor extends Remote {

	public void executeCommand(Command c) throws RemoteException;
	
}
