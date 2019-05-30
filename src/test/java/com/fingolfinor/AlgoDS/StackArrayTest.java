package com.fingolfinor.AlgoDS;

import com.fingolfinor.AlgoDS.datastructures.stack.StackArray;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackArrayTest extends StackTestBase<StackArray> {

    @Override
    protected StackArray createInstance() {
        return new StackArray(3);
    }


    @Test
    public void runStack_reverseWordTest_string() {
        String testFixture = "hello";

        String expectedResult = "olleh";

        String actualResult = reverseWord(testFixture);
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Reverses a word to test Pushing and Popping from the StackArray - basically just Playing with stacks.
     *
     * @param word
     * @return
     */
    public static String reverseWord(String word) {
        int stackSize = word.length();
        StackArray stackArray = new StackArray(stackSize);
        String reversedWord = "";

        // Push vals on stackArray
        for (int i = 0; i < stackSize; i++) {
            stackArray.push(i);
        }

        // Reverse vals by popping off stackArray onto string
        while (!stackArray.isEmpty()) {
            int charIndex = Integer.parseInt(String.valueOf(stackArray.pop()));
            reversedWord = reversedWord + word.charAt(charIndex);
        }

        return reversedWord;
    }
}
