package callback;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Callback Class for BigDecimal numbers
 * First you set the variable then you can
 * print or receive the object
 *
 * @author tfellner
 * @version 27.4.2016
 */
public class CallbackBigDecimal implements Callback<BigDecimal>, Serializable{

    private static final long serialVersionUID = 224L;

    private BigDecimal nr;

    /**
     * Setter of the Attribute nr
     * @param nr to set this.nr to
     */
    @Override
    public void set(BigDecimal nr) {
        this.nr = nr;
    }

    /**
     * Print value of Attribute nr
     */
    @Override
    public void print() {
        System.out.println(nr);
    }

    /**
     * Receive the number
     */
    @Override
    public BigDecimal receive() {
        return nr;
    }
}
