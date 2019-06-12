package com.fingolfinor.AlgoDS.datastructures.linkedlist;


/**
 * A FIFO DS that chains Nodes together through a Container that manages the List through the Head (first Node). Each
 * Node has Data and a Next value that points to the next Node in the chain. Often suited for Queue related problems
 * because the List is always accessed in order, from first to last (FIFO).
 *
 * + Dynamic sizing and fast O(n) inserting/deleting Nodes
 * - Slow access reading when N gets big since scan from Head to Tail
 * - Memory vs array since next pointer takes an additional 4-Bytes
 *
 * TODO:
 * * Implement Interface from these instructions
 *      https://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/linked%20lists.html
 */

public class LinkedList {

    // Entry point for access to chained Nodes
    // Last Node (implicit Tail) is identified by it pointing to Null
    private Node head;

    public LinkedList(){
    }

    public void insertFirst(Object data) {
        Node newNode = new Node(data);

        // Update first to
        newNode.next = head;

        head = newNode;
    }

    public void insertLast(Object data) {
        if (isEmpty()) {
            insertFirst(data);
            return;
        }

        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        Node newNode = new Node(data);
        current.next = newNode;
    }

    public Node deleteFirst() {
        Node deletedNode = head;
        head = head.next;
        return deletedNode;
    }

    public void displayList() {
        Node current = head;
        System.out.println("First to last:");
        while(current != null) {
            current.displayData();
            current = current.next;
        }
        System.out.println("End of list");
    }

    public boolean isEmpty() {
        return (head == null);
    }

}
