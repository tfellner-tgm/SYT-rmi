package server;

import java.rmi.RemoteException;

import remoteService.CommandExecutor;
import server.commands.Command;

/**
 * Concrete Service for Executing a Command
 */
public class ServerService implements CommandExecutor {

	@Override
	public void executeCommand(Command c) throws RemoteException {
		c.execute();

	}

}
