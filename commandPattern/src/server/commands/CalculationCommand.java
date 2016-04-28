package server.commands;

import java.io.Serializable;
import java.rmi.RemoteException;

import calculation.Calculation;
import callback.Callback;

/**
 * Calculation Command that handels combination
 * of Calcuation and Callback.
 *
 * @author tfellner
 * @version 28.4.2016
 */
public class CalculationCommand implements Command, Serializable {

    private static final long serialVersionUID = 12L;

    /**
     * Generic Calculation Attribute
     */
    private Calculation calc;

    /**
     * Generic Callback Attribute
     */
    private Callback cb;

    /**
     * Constructor for creating the object.
     * has to have
     * @param cb Callback and
     * @param calc Calculation
     */
    public CalculationCommand(Callback cb, Calculation calc){
        this.cb = cb;
        this.calc = calc;
    }

    @Override
    public void execute() {
        System.out.println("CalculationCommand called!");
        calc.calculate();
        try {
            cb.set(calc.getResult());
            cb.print();
        } catch (RemoteException e) {
            System.out.println("Calculation Command error " + e);
        }
    }
}
