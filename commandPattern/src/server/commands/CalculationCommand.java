package server.commands;

import java.io.Serializable;
import java.rmi.RemoteException;

import calculation.Calculation;
import callback.Callback;

public class CalculationCommand implements Command, Serializable {

    private static final long serialVersionUID = 12L;

    private Calculation calc;
    private Callback cb;

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
            e.printStackTrace();
        }
    }
}
