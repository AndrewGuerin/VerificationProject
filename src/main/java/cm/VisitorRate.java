package cm;

import java.math.BigDecimal;

public class VisitorRate implements InterfaceCalculate{

    BigDecimal visitorAllowance = new BigDecimal("10");
    BigDecimal percentage = new BigDecimal("0.5");

    @Override
    public BigDecimal calculate(BigDecimal calc) {

        //if stay cost is less than 10 return the visitor allowance
        if (calc.compareTo(visitorAllowance) <= 0){
            return new BigDecimal((0));
        } else {
            //Minus 10 and multiply by 50%
            return calc.subtract(visitorAllowance).multiply(percentage);
        }
    }
}