package callback;

import java.math.BigDecimal;
import java.rmi.Remote;

/**
 * Created by tfellner on 4/27/16.
 */
public interface Callback<T> extends Remote{
    public T send(T argument);
}
