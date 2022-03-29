package cm;

import java.math.BigDecimal;

class ManagementRate implements  InterfaceCalculate
{

    BigDecimal minPayment = new BigDecimal("4.00");
    @Override
    public BigDecimal calculate(BigDecimal calc) {

        //if calculation is < 4 return the minPayment of 4
        if (calc.compareTo(minPayment) < 0){
            return minPayment;
        }

        return calc;
    }
}