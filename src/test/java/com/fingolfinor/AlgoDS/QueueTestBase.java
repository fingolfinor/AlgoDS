package com.fingolfinor.AlgoDS;

import com.fingolfinor.AlgoDS.datastructures.queue.IQueue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class QueueTestBase<T extends IQueue>  {

    private T instance;

    protected abstract T createInstance();

    @Before
    public void setUp() {
        instance = createInstance();
    }

    @Test
    public void enQueue_enQueuThreeItemsThenDeQueue_int() {
        instance.enQueue(1); instance.enQueue(2); instance.enQueue(3);

        long expectedOutput = 1;
        long actualOutput = Long.parseLong(String.valueOf(instance.deQueue()));
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void enQueue_enQueuDeQueueAlotThenTestDeEueueVal_int() {
        // Add and remove a lot of values, remaining Queue item should be 5
        instance.enQueue(1); instance.enQueue(2); instance.enQueue(3);
        instance.deQueue(); instance.deQueue(); instance.deQueue();
        instance.enQueue(4); instance.enQueue(5);
        instance.deQueue();

        long expectedOutput = 5;
        long actualOutput = Long.parseLong(String.valueOf(instance.deQueue()));
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void deQueue_onEmptyDefault_int() {
        int expectedOutput = -1;
        int actualOutput = Integer.parseInt(String.valueOf(instance.deQueue()));
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void deQueue_onEmptyAfterEnQueuedAndDeQueuedToEmpty_int() {
        // Add some values
        instance.enQueue(1); instance.enQueue(2); instance.enQueue(3);
        //Remove those values
        instance.deQueue(); instance.deQueue(); instance.deQueue();

        int expectedOutput = -1;
        int actualOutput = Integer.parseInt(String.valueOf(instance.deQueue()));
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void peakFront_onEmpty_int() {
        int expectedOutput = -1;
        int actualOutput = Integer.parseInt(String.valueOf(instance.deQueue()));
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void peakFront_onNonEmpty_int() {
        // Add some values
        instance.enQueue(1); instance.enQueue(2); instance.enQueue(3);

        int expectedOutput = 1;
        int actualOutput = Integer.parseInt(String.valueOf(instance.peakFront()));
        assertEquals(expectedOutput, actualOutput);
    }
}
