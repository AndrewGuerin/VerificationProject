package cm;

import java.math.BigDecimal;

class StudentRate implements  InterfaceCalculate
{

        @Override
        public BigDecimal calculate(BigDecimal calc) {

            BigDecimal studentLimit = new BigDecimal("5.50");
            BigDecimal remainder = calc.subtract(studentLimit);
            BigDecimal percentage = new BigDecimal("0.75");

            // if the cost is > 5.50, multiply the remainder by 0.75 and add the 5.50 back
            if (calc.compareTo(studentLimit) > 0) {
                calc = percentage.multiply(remainder).add(studentLimit);
            }
            return calc;
        }
}