package com.fingolfinor.AlgoDS.datastructures.linkedlist;

public class Node {

    public Object data;
    public Node next;                          // Recursive Node type
    public Node prev;                          // note used in Singularly-Linked-List

    public Node(Object data) {
        this.data = data;
    }

    public void displayData() {
        System.out.println("{" + data + "}");
    }
}
