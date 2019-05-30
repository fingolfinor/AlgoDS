package com.fingolfinor.AlgoDS;

import com.fingolfinor.AlgoDS.datastructures.stack.IStack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public abstract class StackTestBase<T extends IStack> {

    private T instance;

    protected abstract T createInstance();

    @Before
    public void setUp() {
        instance = createInstance();
    }


    @Test
    public void push_onMaxSize_void() {
        instance.push(1); instance.push(2); instance.push(3); instance.push(4);

        long expectedOutput = 3;
        long actualOutput = Long.parseLong(String.valueOf(instance.peak()));
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void push_threeItems_long() {
        instance.push(1); instance.push(2); instance.push(3);

        long expectedOutput = 3;
        long actualOutput = Long.parseLong(String.valueOf(instance.peak()));
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void pop_onEmpty_long() {
        instance.pop();

        int expectedOutput = -1;
        int actualOutput = Integer.parseInt(String.valueOf(instance.pop()));
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void pop_onSimplePush_long() {
        instance.push(1); instance.push(2); instance.push(3);
        instance.pop();

        long expectedOutput = 2;
        long actualOutput = Long.parseLong(String.valueOf(instance.pop()));
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void peak_onEmpty_long() {
        long expectedOutput = -1;
        long actualOutput = Long.parseLong(String.valueOf(instance.peak()));
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void peak_onSimplePush_long() {
        instance.push(1); instance.push(2); instance.push(3);

        long expectedOutput = 3;
        long actualOutput = Long.parseLong(String.valueOf(instance.peak()));
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void isEmpty_onEmpty_boolean() {
        boolean expectedOutput = true;
        boolean actualOutput = instance.isEmpty();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void isEmpty_onSize3_boolean() {
        instance.push(1); instance.push(2); instance.push(3);

        boolean expectedOutput = false;
        boolean actualOutput = instance.isEmpty();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void isFull_onEmpty_boolean() {
        boolean expectedOutput = false;
        boolean actualOutput = instance.isFull();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void isFull_onFull_boolean() {
        instance.push(1); instance.push(2); instance.push(3);

        boolean expectedOutput = true;
        boolean actualOutput = instance.isFull();
        assertEquals(expectedOutput, actualOutput);
    }
}
