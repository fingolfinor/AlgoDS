package com.fingolfinor.AlgoDS.datastructures.stack;

import com.fingolfinor.AlgoDS.datastructures.linkedlist.LinkedList;
import com.fingolfinor.AlgoDS.datastructures.linkedlist.Node;


public class StackLinkedList implements IStack{
    private int maxSize;
    private int size;

    // Use Start of LinkedList as Top to push/pop from top of Stack
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

        size++;

        stack.insertFirst(newItem);
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

        Node node = stack.deleteFirst();
        Object item = node.data;
        return item;
    }


    public Object peak() {
        if (isEmpty()) {
            return -1;
        }

        // Way around limitation of no LinkedList method to look at the first Node.
        Node node = stack.deleteFirst();
        Object item = node.data;
        push(item);

        return item;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean isFull() {
        return (maxSize == size);
    }
}
