package com.fingolfinor.AlgoDS.datastructures.linkedlist;

public class CircularLinkedList {
    private Node first;
    private Node last;

    public CircularLinkedList() {
        first = null;
        last = null;
    }

    public void insertFirst(Object data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            last = newNode;
        }

        newNode.next = first;               // Set next reference to Node first
        first = newNode;                    // delete old reference, and set reference to newNode
    }

    public void insertLast(Object data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            last = newNode;                 // HAH was right, bug in instructor code - need this to
            first = newNode;
        } else {
            last.next = newNode;            // Updates chain so not broken
            last = newNode;                 // last pointer also needs to be updated
        }
    }

    public Node deleteFirst() {
        Node firstNode = first;

        if (first.next == null) {
            //first = null;
            last = null;
        }

        //first.next = first.next.next;     // Hope over next link in chain and connect there
        first = first.next;                 //first wil point to old's next value


        return firstNode;
    }

    public void displayList() {
        Node current = first;
        System.out.println("First to last:");
        while(current != null) {
            current.displayData();
            current = current.next;
        }
        System.out.println("End of list");
    }

    public boolean isEmpty() {
        return (first == null);     // So no nodes in list
    }
}
