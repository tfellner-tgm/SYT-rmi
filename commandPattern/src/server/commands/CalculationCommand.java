package server.commands;

import java.io.Serializable;
import calculation.Calculation;
import calculation.PICalc;
import callback.Callback;
import callback.CallbackPi;

public class CalculationCommand implements Command, Serializable {

	private static final long serialVersionUID = 3202369269194172790L;
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
        cb.send(calc.getResult());
	}
}
