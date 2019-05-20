package com.fingolfinor.AlgoDS;

import com.fingolfinor.AlgoDS.datastructures.CounterADT;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CounterADTTests {

    // Fixture: data to run the test against.

    // Method naming convention: public void nameOfMethodWeAreTesting_descriptionOfBehavior_expectedReturnValue()
    @Test
    public void runCounterADT_defaultOfZero_integer() {
        int expectedOutput = 0;

        CounterADT counterADT = new CounterADT("MyCounter");
        int actualOutput = counterADT.getCurrentValue();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void runCounterADT_incrementUpTwo_integer() {
        int expectedOutput = 3;

        CounterADT counterADT = new CounterADT("MyCounter");
        counterADT.increment().increment().increment();
        int actualOutput = counterADT.getCurrentValue();

        assertEquals(expectedOutput, actualOutput);
    }
}
