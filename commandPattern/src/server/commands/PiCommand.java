package server.commands;

import calculation.Calculation;
import calculation.PICalc;
import callback.Callback;
import callback.CallbackPi;

import java.io.Serializable;

/**
 * Created by tfellner on 4/28/16.
 */
public class PiCommand implements Command, Serializable{

    private static final long serialVersionUID = 3202369269194173440L;

    private Integer digits;

    public PiCommand(Integer digits){
        this.digits = digits;
    }

    @Override
    public void execute() {
        System.out.println(digits);
    }
}
