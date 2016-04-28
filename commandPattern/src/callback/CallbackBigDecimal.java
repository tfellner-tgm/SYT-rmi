package callback;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by tfellner on 4/27/16.
 */
public class CallbackBigDecimal implements Callback<BigDecimal>, Serializable{

    private static final long serialVersionUID = 3202539269194173440L;

    private BigDecimal nr;

    @Override
    public void set(BigDecimal nr) {
        this.nr = nr;
    }

    @Override
    public void print() {
        System.out.println(nr);
    }

    @Override
    public BigDecimal receive() {
        return nr;
    }
}
