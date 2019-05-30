package com.fingolfinor.AlgoDS.datastructures.stack;


/**
 * StackArray
 *
 * Uses an Array DS to store items on a Stack.
 */
public class StackArray implements IStack {
    private int maxSize;

    // Container storing items
    private Object[] stackArray;

    // Index of last item at the top of the Stack in stackArray
    // Using pointers to maintain Top of StackArray (just overwriting old and new array cells)
    private int top;


    public StackArray(int size) {
        this.maxSize = size;
        this.stackArray = new Object[maxSize];

        //So first item placed on stack will start at index 0
        this.top = -1;
    }

    public void push(Object j) {
        if (isFull()) {
            System.out.println("StackArray max size reached");
            return;
        }

        top++;
        stackArray[top] = j;
    }

    public Object pop() {
        if (isEmpty()) {
            System.out.println("StackArray is empty");

            // Not a great way of handling since user may place -1 on Array but hopefully Msg above
            // WHY exceptions are better.
            return -1;
        }

        int oldTop = top;
        top--;
        return stackArray[oldTop];
    }

    public Object peak() {
        if (isEmpty()) {
            return -1;
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top <= -1);
    }

    //-1 since start at 0 for array index
    public boolean isFull() {
        return (maxSize - 1 == top);
    }
}
