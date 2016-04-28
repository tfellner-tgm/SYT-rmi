package remoteService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import server.commands.Command;

/**
 * Interface for defining an executer for commands
 *
 * @author tfellner
 * @version 28.4.2016
 */
public interface CommandExecutor extends Remote {

	public void executeCommand(Command c) throws RemoteException;
	
}
