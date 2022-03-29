package cm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.lang.reflect.Array;
import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class GuerinAndrewTestTask2 {

    @Test
    public void testingCase1()  {
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
    public void testingCase2(){
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(0,12), new Period(10,18), new Period(15,24)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(7,15)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    @Test
    public void testingCase3(){
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(0,12), new Period(15,24)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(12,15)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        Rate rate = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(3),new BigDecimal(2), reducedPeriods, normalPeriods);
        assertEquals(new BigDecimal(6), rate.calculate(new Period(7,9)));
    }

    @Test
    public  void testingCase4() {

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(10,18));

        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(17,24));

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriod, normalPeriod));
    }


}
