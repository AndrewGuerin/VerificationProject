package cm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class GuerinAndrewTestTask3 {

    // Visitor rate of 10.00 or below
    @Test
    public void RateTestCase1() {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(4);
        Rate rate = new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal(0), rate.calculate(new Period(12,14)));
    }

    // Visitor rate over 10.00 euro
    @Test
    public void RateTestCase2() {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(4);
        Rate rate = new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal("1.00"), rate.calculate(new Period(12,15)));
    }

    // Management below 4.00
    @Test
    public void RateTestCase3() {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(1);
        Rate rate = new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal(4), rate.calculate(new Period(13,15)));
    }

    // Management above 4.00
    @Test
    public void RateTestCase4() {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(3);
        Rate rate = new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal(10), rate.calculate(new Period(7,9)));
    }

    // Management parked during non normal or reduced hours
    @Test
    public void RateTestCase5() {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(2);
        Rate rate = new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal(4), rate.calculate(new Period(4,6)));
    }

    // student amount below 5.50
    @Test
    public void RateTestCase6() {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        Rate rate = new Rate(CarParkKind.STUDENT, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal(4), rate.calculate(new Period(12,14)));
    }

    // student amount above 5.50
    @Test
    public void RateTestCase7() {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal("13.50");
        BigDecimal reducedRate = new BigDecimal(2);
        Rate rate = new Rate(CarParkKind.STUDENT, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal("11.50"), rate.calculate(new Period(12,13)));
    }

    // student amount above 5.50 but moves from normal period to reduced period
    @Test
    public void RateTestCase8() {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal("10.50");
        BigDecimal reducedRate = new BigDecimal(2);
        Rate rate = new Rate(CarParkKind.STUDENT, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal("10.75"), rate.calculate(new Period(16,18)));
    }

    // staff amount under 16.00
    @Test
    public void RateTestCase9() {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(3);
        Rate rate = new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal(12), rate.calculate(new Period(12,14)));
    }

    // staff amount above 16.00
    @Test
    public void RateTestCase10() {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(3);
        Rate rate = new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal(16), rate.calculate(new Period(12,16)));
    }

    // staff amount above 16.00 over normal and reduced period
    @Test
    public void RateTestCase11() {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(3);
        Rate rate = new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal(16), rate.calculate(new Period(15,22)));
    }


}
