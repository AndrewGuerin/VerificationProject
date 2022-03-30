package cm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuerinAndrewTestTask3 {

    //task 1 tests
    @Test
    public void task1testingCase1() throws Exception {
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.STAFF, new BigDecimal(-1), new BigDecimal(1), reducedPeriod, normalPeriod);
        });
    }

    @Test
    public void task1testingCase2() throws Exception {
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.STUDENT, new BigDecimal(3), new BigDecimal(-2), reducedPeriod, normalPeriod);
        });
    }

    @Test
    public void task1testingCase3() throws Exception {
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.VISITOR, new BigDecimal(4), new BigDecimal(5), reducedPeriod, normalPeriod);
        });
    }

    @Test
    public void task1testingCase4(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Rate rate = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(3),new BigDecimal(2), reducedPeriod, normalPeriod);
        assertEquals(new BigDecimal("6.00"), rate.calculate(new Period(7,9)));

    }

    @Test
    public void task1testingCase5(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(3),new BigDecimal(0), reducedPeriod, normalPeriod);
        assertEquals(new BigDecimal("0.00"), rate.calculate(new Period(11,13)));
    }

    @Test
    public void task1testingCase6(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Rate rate = new Rate(CarParkKind.STUDENT, new BigDecimal(5),new BigDecimal(4), reducedPeriod, normalPeriod);
        assertEquals(new BigDecimal("7.38"), rate.calculate(new Period(11,13)));
    }

    @Test
    public void task1testingCase7(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(6),new BigDecimal(5), reducedPeriod, normalPeriod);
        assertEquals(new BigDecimal("16.00"), rate.calculate(new Period(12,17)));
    }

    @Test
    public void task1testingCase8(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(16,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(9,20)));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.MANAGEMENT, new BigDecimal(5), new BigDecimal(2), reducedPeriod, normalPeriod);
        });
    }

    @Test
    public void task1testingCase9(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(10,17)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(2), reducedPeriod, normalPeriod);
        });
    }

    @Test
    public void task1testingCase10(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(7,10)));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(2), reducedPeriod, normalPeriod);
        });
    }

    @Test
    public void task1testingCase11(){
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.STUDENT, null, new BigDecimal(2), reducedPeriod, normalPeriod);
        });
    }

    @Test
    public void task1testingCase12(){
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.VISITOR, new BigDecimal(5), null, reducedPeriod, normalPeriod);
        });
    }

    @Test
    public void task1testingCase13(){
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.STAFF, new BigDecimal(10), new BigDecimal(5), null, normalPeriod);
        });
    }

    @Test
    public void task1testingCase14(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.MANAGEMENT, new BigDecimal(10), new BigDecimal(5), reducedPeriod, null);
        });
    }

    @Test
    public void task1testingCase15(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(10),new BigDecimal(5), reducedPeriod, normalPeriod);
        assertEquals(new BigDecimal("16.00"), rate.calculate(new Period(10,15)));
    }

    @Test
    public void task1testingCase16(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Rate rate = new Rate(CarParkKind.STUDENT, new BigDecimal(10),new BigDecimal(5), reducedPeriod, normalPeriod);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rate.calculate(new Period(10,1));
        });
    }

    @Test
    public void task1testingCase17(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Rate rate = new Rate(CarParkKind.VISITOR, new BigDecimal(10),new BigDecimal(5), reducedPeriod, normalPeriod);
        assertEquals(new BigDecimal("7.50"), rate.calculate(new Period(10,15)));
    }

    @Test
    public void task1testingCase18(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(10),new BigDecimal(5), reducedPeriod, normalPeriod);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rate.calculate(new Period(0,0));
        });
    }

    @Test
    public void task1testingCase19(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Rate rate = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(10),new BigDecimal(5), reducedPeriod, normalPeriod);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rate.calculate(new Period(0,0));
        });
    }

    @Test
    public void task1testingCase20(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Rate rate = new Rate(CarParkKind.STUDENT, new BigDecimal(10),new BigDecimal(5), reducedPeriod, normalPeriod);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rate.calculate(new Period(24,1));
        });
    }

    @Test
    public void task1testingCase21(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Rate rate = new Rate(CarParkKind.VISITOR, new BigDecimal(10),new BigDecimal(5), reducedPeriod, normalPeriod);

        assertEquals(new BigDecimal("5.00"), rate.calculate(new Period(7,9)));
    }

    @Test
    public void task1testingCase22(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(10),new BigDecimal(5), reducedPeriod, normalPeriod);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rate.calculate(new Period(25,4));
        });
    }

    @Test
    public void task1testingCase23(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Rate rate = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(10),new BigDecimal(5), reducedPeriod, normalPeriod);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rate.calculate(new Period(3,25));
        });
    }

    @Test
    public void task1testingCase24(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));

        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(10),new BigDecimal(5), reducedPeriod, normalPeriod);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rate.calculate(new Period(5,-2));
        });
    }

    //Task 2 tests
    @Test
    public void task2testingCase1()  {
        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(10,17));

        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(17,24));

        //BigDecimal normalRate = new BigDecimal(5);
        //BigDecimal reducedRate = new BigDecimal(2);


        Assertions.assertDoesNotThrow(() -> {
            new Rate(CarParkKind.MANAGEMENT, new BigDecimal(5), new BigDecimal(2), reducedPeriod, normalPeriod);
        });
    }


    @Test
    public void task2testingCase2(){
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(0,12), new Period(10,18), new Period(15,24)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(7,15)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    @Test
    public void task2testingCase3(){
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(0,12), new Period(15,24)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(12,15)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        Rate rate = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(3),new BigDecimal(2), reducedPeriods, normalPeriods);
        assertEquals(new BigDecimal("6.00"), rate.calculate(new Period(7,9)));
    }

    @Test
    public  void task2testingCase4() {

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(10,18));

        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(17,24));

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriod, normalPeriod));
    }


    // Visitor rate of 10.00 or below
    @Test
    public void Task3VisitorBelow10() {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(4);
        Rate rate = new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal("0.00"), rate.calculate(new Period(12,14)));
    }

    // Visitor rate over 10.00 euro
    @Test
    public void Task3VisitorAbove10() {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(4);
        Rate rate = new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal("1.00"), rate.calculate(new Period(12,15)));
    }

    // Management below 4.00
    @Test
    public void Task3ManagementBelow4() {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(1);
        Rate rate = new Rate(CarParkKind.MANAGEMENT, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal("4.00"), rate.calculate(new Period(13,15)));
    }

    // Management above 4.00
    @Test
    public void Task3ManagementAbove4() {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(3);
        Rate rate = new Rate(CarParkKind.MANAGEMENT, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal("10.00"), rate.calculate(new Period(7,9)));
    }

    // Management parked during non normal or reduced hours
    @Test
    public void Task3ManagementFree() {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(2);
        Rate rate = new Rate(CarParkKind.MANAGEMENT, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal("4.00"), rate.calculate(new Period(4,6)));
    }

    // student amount below 5.50
    @Test
    public void Task3StudentBelow550() {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        Rate rate = new Rate(CarParkKind.STUDENT, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal("2.00"), rate.calculate(new Period(12,14)));
    }

    // student total above 5.50
    @Test
    public void Task3StudentAbove550() {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal("13.50");
        BigDecimal reducedRate = new BigDecimal(2);
        Rate rate = new Rate(CarParkKind.STUDENT, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal("11.50"), rate.calculate(new Period(8,9)));
    }

    // student amount above 5.50 but moves from normal period to reduced period
    @Test
    public void Task3Above550butNormAndNonNormPeriod() {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal("10.50");
        BigDecimal reducedRate = new BigDecimal(2);
        Rate rate = new Rate(CarParkKind.STUDENT, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal("10.75"), rate.calculate(new Period(16,18)));
    }

    // staff amount under 16.00
    @Test
    public void Task3StaffUnder16() {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(3);
        Rate rate = new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal("6.00"), rate.calculate(new Period(12,14)));
    }

    // staff amount above 16.00
    @Test
    public void Task3StaffOver16() {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(3);
        Rate rate = new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal("12.00"), rate.calculate(new Period(12,16)));
    }

    // staff amount above 16.00 over normal and reduced period
    @Test
    public void Task3StaffOver16ButBothPeriods() {
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10,17), new Period(20,24)));
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(7,10), new Period(17,20)));
        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(3);
        Rate rate = new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal("16.00"), rate.calculate(new Period(15,22)));
    }
}
