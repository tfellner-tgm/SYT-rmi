package calculation;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Calculate Euler's number with this Class
 *
 * @author tfellner
 * @version 28.4.2016
 */
public class EulerCalc implements Calculation, Serializable{

    private static final long serialVersionUID = 13L;

    /**
     * Resulting euler number
     */
    private BigDecimal e;

    /**
     * How many 1s divided by factorials to sum.
     */
    private int accuracy;

    public EulerCalc(int accuracy){
        e = BigDecimal.ONE;
        this.accuracy = accuracy;
    }

    /**
     * Method for finding factorial.
     * This is required for calculating the euler number
     *
     * @param n number to factorial
     * @return the resulting factorial
     */
    private BigDecimal factorial(int n) {
        BigDecimal fact = BigDecimal.ONE;
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(BigDecimal.valueOf(i));
        }
        return fact;
    }

    /**
     * Calculate euler number e
     *
     * e = 1/0! + 1/1! + 1/2! ...
     */
    @Override
    public void calculate() {
        for (int i = 1; i < accuracy; i++) {
            BigDecimal k = BigDecimal.ONE.divide(factorial(i), accuracy, BigDecimal.ROUND_HALF_EVEN);

            e = e.add(k);
        }
    }

    /**
     * @return value of attribute e
     */
    @Override
    public BigDecimal getResult() {
        return this.e;
    }
}
