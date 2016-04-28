package callback;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface for Callbacks of any datatype.
 *
 * @author tfellner
 * @version 27.4.2016
 */
public interface Callback<T> extends Remote{
    public void set(T argument) throws RemoteException;
    public void print() throws RemoteException;
    public T receive() throws RemoteException;
}
