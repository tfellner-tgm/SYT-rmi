package server;

import java.rmi.RemoteException;

import remoteService.CommandExecutor;
import server.commands.Command;

public class ServerService implements CommandExecutor {

	@Override
	public void executeCommand(Command c) throws RemoteException {
		c.execute();

	}

}
