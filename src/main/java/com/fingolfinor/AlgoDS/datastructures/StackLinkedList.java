package com.fingolfinor.AlgoDS.datastructures;


import com.fingolfinor.AlgoDS.datastructures.linkedlist.LinkedList;

// TODO: Re-Implement to take Objects of any type -  and probably using a LinkedList
public class StackLinkedList {
    private int maxSize;
    private int size;

    // Container storing items
    private LinkedList stack;

    public StackLinkedList() {
        this(9999);
    }

    public StackLinkedList(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.stack = new LinkedList();
    }

    public void push(Object newItem) {
        if (isFull()) {
            System.out.println("Stack max size reached");
            return;
        }

        stack.insertLast(newItem);
        size++;
    }

    // TODO
    public Object pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");

            // Not a great way of handling since user may place -1 on Array but hopefully Msg above
            // WHY exceptions are better.
            return -1;
        }

        size--;
        return stack.deleteFirst();
    }

    // TODO
    public Object peak() {
        if (isEmpty()) {
            return -1;
        }

        return new Object();
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean isFull() {
        return (maxSize == size);
    }
}
