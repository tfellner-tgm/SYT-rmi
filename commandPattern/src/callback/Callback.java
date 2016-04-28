package callback;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by tfellner on 4/27/16.
 */
public interface Callback<T> extends Remote{
    public void set(T argument) throws RemoteException;
    public void print() throws RemoteException;
    public T receive() throws RemoteException;
}
