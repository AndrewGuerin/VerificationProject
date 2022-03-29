package cm;

import java.math.BigDecimal;

public class StaffRate implements InterfaceCalculate {
    @Override
    public BigDecimal calculate(BigDecimal calc) {
        BigDecimal maxPayment = new BigDecimal("16");

        if (calc.compareTo(maxPayment) < 0) {
            return calc;
        } else {
            return maxPayment;
        }
    }
}