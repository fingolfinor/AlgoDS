package com.fingolfinor.AlgoDS;

import com.fingolfinor.AlgoDS.datastructures.stack.Stack;
import com.fingolfinor.AlgoDS.datastructures.stack.StackLinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackLinkedListTest extends StackTestBase<StackLinkedList> {

    @Override
    protected StackLinkedList createInstance() {
        return new StackLinkedList(3);
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
            int charIndex = Integer.parseInt(String.valueOf(stack.pop()));
            reversedWord = reversedWord + word.charAt(charIndex);
        }

        return reversedWord;
    }
}
