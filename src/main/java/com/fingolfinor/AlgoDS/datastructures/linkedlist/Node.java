package com.fingolfinor.AlgoDS.datastructures.linkedlist;

/**
 * Node used in LinkedLists to chain Nodes together.
 *
 * Note: Could break off as NodeSingle if memory size was a concern. Kept simple with one class for both.
 */
public class Node {

    public Object data;

    // Recursive Node type (pointing to a type of itself)
    public Node next;

    // Note: Not used in Singularly Linked-List
    public Node prev;

    public Node(Object data) {
        this.data = data;
    }

    public void displayData() {
        System.out.println("{" + data + "}");
    }
}
