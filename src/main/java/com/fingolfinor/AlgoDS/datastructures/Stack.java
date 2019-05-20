package com.fingolfinor.AlgoDS.datastructures;

// TODO: Re-Implement to take Objects of any type -  and probably using a LinkedList
public class Stack {
    private int maxSize;
    private long[] stackArray;      //Container storing items
    private int top;                //index of last item
                                    // Using pointers to maintain Top of Stack (just overwriting old and new array cells)

    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new long[maxSize];
        this.top = -1;              //So first item placed on stack will start at index 0
    }

    public void push(long j) {
        if (isFull()) {
            System.out.println("Stack max size reached");
            return;
        }

        top++;
        stackArray[top] = j;
    }

    public long pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;                  // Not a great way of handling since user may place -1 on Array but hopefully Msg above
                                        // WHY exceptions are better.
        }

        int oldTop = top;
        top--;
        return stackArray[oldTop];
    }

    public long peak() {
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
