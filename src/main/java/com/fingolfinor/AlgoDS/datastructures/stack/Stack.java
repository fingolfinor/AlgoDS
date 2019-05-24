package com.fingolfinor.AlgoDS.datastructures.stack;


/**
 * Stack
 *
 * Uses an Array DS to store items.
 *
 * @TODO move notes here.
 *
 */
public class Stack implements IStack {
    private int maxSize;
    private Object[] stackArray;      //Container storing items
    private int top;                //index of last item
                                    // Using pointers to maintain Top of Stack (just overwriting old and new array cells)

    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new Object[maxSize];
        this.top = -1;              //So first item placed on stack will start at index 0
    }

    public void push(Object j) {
        if (isFull()) {
            System.out.println("Stack max size reached");
            return;
        }

        top++;
        stackArray[top] = j;
    }

    public Object pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;                  // Not a great way of handling since user may place -1 on Array but hopefully Msg above
                                        // WHY exceptions are better.
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

    public boolean isFull() {
        return (maxSize-1 == top);  //-1 since start at 0 for array index
    }
}
