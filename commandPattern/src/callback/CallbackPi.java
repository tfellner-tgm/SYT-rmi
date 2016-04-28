package callback;

import java.math.BigDecimal;

/**
 * Created by tfellner on 4/27/16.
 */
public class CallbackPi implements Callback<BigDecimal>{

    @Override
    public BigDecimal send(BigDecimal nr) {
        System.out.println(nr);
        return nr;
    }
}
