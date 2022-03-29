package cm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GuerinAndrewTestTask1 {

    @Test
    public void testingCase1() throws Exception {
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.STAFF, new BigDecimal(-1), new BigDecimal(1), reducedPeriod, normalPeriod);
        });
    }

    @Test
    public void testingCase2() throws Exception {
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.STUDENT, new BigDecimal(3), new BigDecimal(-2), reducedPeriod, normalPeriod);
        });
    }

    @Test
    public void testingCase3() throws Exception {
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.VISITOR, new BigDecimal(4), new BigDecimal(5), reducedPeriod, normalPeriod);
        });
    }

    @Test
    public void testingCase4(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Rate rate = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(3),new BigDecimal(2), reducedPeriod, normalPeriod);
        assertEquals(new BigDecimal(6), rate.calculate(new Period(7,9)));

    }

    @Test
    public void testingCase5(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(3),new BigDecimal(0), reducedPeriod, normalPeriod);
        assertEquals(new BigDecimal(0), rate.calculate(new Period(11,13)));
    }

    @Test
    public void testingCase6(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Rate rate = new Rate(CarParkKind.STUDENT, new BigDecimal(5),new BigDecimal(4), reducedPeriod, normalPeriod);
        assertEquals(new BigDecimal(8), rate.calculate(new Period(11,13)));
    }

    @Test
    public void testingCase7(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(6),new BigDecimal(5), reducedPeriod, normalPeriod);
        assertEquals(new BigDecimal(25), rate.calculate(new Period(12,17)));
    }

    @Test
    public void testingCase8(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(16,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(9,20)));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.MANAGEMENT, new BigDecimal(5), new BigDecimal(2), reducedPeriod, normalPeriod);
        });
    }

    @Test
    public void testingCase9(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(10,17)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(2), reducedPeriod, normalPeriod);
        });
    }

    @Test
    public void testingCase10(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(7,10)));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(2), reducedPeriod, normalPeriod);
        });
    }

    @Test
    public void testingCase11(){
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.STUDENT, null, new BigDecimal(2), reducedPeriod, normalPeriod);
        });
    }

    @Test
    public void testingCase12(){
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.VISITOR, new BigDecimal(5), null, reducedPeriod, normalPeriod);
        });
    }

    @Test
    public void testingCase13(){
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.STAFF, new BigDecimal(10), new BigDecimal(5), null, normalPeriod);
        });
    }

    @Test
    public void testingCase14(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.MANAGEMENT, new BigDecimal(10), new BigDecimal(5), reducedPeriod, null);
        });
    }

    @Test
    public void testingCase15(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(10),new BigDecimal(5), reducedPeriod, normalPeriod);
        assertEquals(new BigDecimal(25), rate.calculate(new Period(10,15)));
    }

    @Test
    public void testingCase16(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Rate rate = new Rate(CarParkKind.STUDENT, new BigDecimal(10),new BigDecimal(5), reducedPeriod, normalPeriod);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rate.calculate(new Period(10,1));
        });
    }

    @Test
    public void testingCase17(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Rate rate = new Rate(CarParkKind.VISITOR, new BigDecimal(10),new BigDecimal(5), reducedPeriod, normalPeriod);
        assertEquals(new BigDecimal(25), rate.calculate(new Period(10,15)));
    }

    @Test
    public void testingCase18(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(10),new BigDecimal(5), reducedPeriod, normalPeriod);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rate.calculate(new Period(0,0));
        });
    }

    @Test
    public void testingCase19(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Rate rate = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(10),new BigDecimal(5), reducedPeriod, normalPeriod);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rate.calculate(new Period(0,0));
        });
    }

    @Test
    public void testingCase20(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Rate rate = new Rate(CarParkKind.STUDENT, new BigDecimal(10),new BigDecimal(5), reducedPeriod, normalPeriod);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rate.calculate(new Period(24,1));
        });
    }

    @Test
    public void testingCase21(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Rate rate = new Rate(CarParkKind.VISITOR, new BigDecimal(10),new BigDecimal(5), reducedPeriod, normalPeriod);

        assertEquals(new BigDecimal(20), rate.calculate(new Period(7,9)));
    }

    @Test
    public void testingCase22(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(10),new BigDecimal(5), reducedPeriod, normalPeriod);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rate.calculate(new Period(25,4));
        });
    }

    @Test
    public void testingCase23(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Rate rate = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(10),new BigDecimal(5), reducedPeriod, normalPeriod);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rate.calculate(new Period(3,25));
        });
    }

    @Test
    public void testingCase24(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(10),new BigDecimal(5), reducedPeriod, normalPeriod);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rate.calculate(new Period(5,-2));
        });
    }

}