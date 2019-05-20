package com.fingolfinor.AlgoDS;

import com.fingolfinor.AlgoDS.datastructures.Stack;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackTests {

    /**
     * Methods Chosen for testing pulled from Stack Interface.
     *
     * TODO: Consider how unit tests depend on each other, so if one breaks so will the other
     * e.g. push_threeItems_long() depend on both push() and peak() - may need to update Stack to have a size or
     * something?
     */

    @Test
    public void push_threeItems_long() {
        Stack stack = new Stack(3);
        stack.push(1); stack.push(2); stack.push(3);

        long expectedOutput = 3;
        long actualOutput = stack.peak();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void push_onMaxSize_void() {
        Stack stack = new Stack(2);
        stack.push(1); stack.push(2); stack.push(3);

        long expectedOutput = 2;
        long actualOutput = stack.peak();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void pop_onEmpty_long() {
        Stack stack = new Stack(2);
        stack.pop();

        long expectedOutput = -1;
        long actualOutput = stack.pop();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void pop_onSimplePush_long() {
        Stack stack = new Stack(3);
        stack.push(1); stack.push(2); stack.push(3);
        stack.pop();

        long expectedOutput = 2;
        long actualOutput = stack.pop();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void peak_onEmpty_long() {
        Stack stack = new Stack(2);

        long expectedOutput = -1;
        long actualOutput = stack.peak();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void peak_onSimplePush_long() {
        Stack stack = new Stack(3);
        stack.push(1); stack.push(2); stack.push(3);

        long expectedOutput = 3;
        long actualOutput = stack.peak();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void isEmpty_onEmpty_boolean() {
        Stack stack = new Stack(3);

        boolean expectedOutput = true;
        boolean actualOutput = stack.isEmpty();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void isEmpty_onSize3_boolean() {
        Stack stack = new Stack(3);
        stack.push(1); stack.push(2); stack.push(3);

        boolean expectedOutput = false;
        boolean actualOutput = stack.isEmpty();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void isFull_onEmpty_boolean() {
        Stack stack = new Stack(3);

        boolean expectedOutput = false;
        boolean actualOutput = stack.isFull();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void isFull_onFull_boolean() {
        Stack stack = new Stack(3);
        stack.push(1); stack.push(2); stack.push(3);

        boolean expectedOutput = true;
        boolean actualOutput = stack.isFull();
        assertEquals(expectedOutput, actualOutput);
    }


    @Test
    public void runStack_reverseWordTest_string() {
        String testFixture = "hello";
        String expectedResult = "olleh";
        String actualResult = reverseWord(testFixture);
        assertEquals(expectedResult, actualResult);
    }


    /**
     * Reverses a word to test Pushing and Popping from the Stack - basically just Playing with stacks.
     *
     * @param word
     * @return
     */
    public static String reverseWord(String word) {
        int stackSize = word.length();
        Stack stack = new Stack(stackSize);
        String reversedWord = "";

        // Push vals on stack
        for (int i = 0; i < stackSize; i++) {
            stack.push(i);
        }

        // Reverse vals by popping off stack onto string
        while (!stack.isEmpty()) {
            int charIndex = (int) stack.pop();
            reversedWord = reversedWord + word.charAt(charIndex);
        }

        return reversedWord;
    }
}
