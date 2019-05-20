package com.fingolfinor.AlgoDS.datastructures.linkedlist;

public class DoublyLinkedList {
    private Node first;                        // Pointers to Nodes in the list (not using next/prev internals)
    private Node last;

    public DoublyLinkedList() {                                                 //Explicit for simplicity
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(Object data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            first.prev = newNode;
            newNode.next = first;
            first = newNode;
        }
    }

    public void insertLast(Object data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
        }

        last = newNode;
    }

    // assume User knows non-empty list
    public Node deleteFirst() {
        Node deletedNode = first;

        if (first.next == null) {               //i: there is only one item in the list
            first = null;
            last = null;
        } else {
            first.next.prev = null;
            first = first.next;
        }

        return deletedNode;
    }

    // assume User knows non-empty list
    public  Node deleteLast() {
        Node deletedNode =  last;

        if (first.next == null) {
            first = null;
            last = null;
        } else {
            last = last.prev;
            last.next = null;
        }

        return deletedNode;
    }

    // assume a non-empty list
    public boolean insertAfter(Object keyData, Object data) {
        Node current = first;

        // Search for the matched key
        while((int) current.data != (int) keyData) {        // Would need dynamic equality, so need to implement .equals()
            current = current.next;

            if (current == null) {                          // Got to the end, not found, exit
                return false;
            }
        }
                                            // Order of code seems a bit chaotic.?

        Node newNode = new Node(data);
        if (current == last) {
            current.next = null;    // id as last node
            last = newNode;
        } else {
            newNode.next = current.next;    //i: new node's next field should point to the node ahead of the current
            current.next.prev = newNode;    //i: the node ahead of current, it's previous field should point to the new node
        }

        newNode.prev = current;
        current.next = newNode;

        return true;
    }

    //assume a non-empty list
    public Node deleteKey(Object keyData) {
        Node current = first;

        // Search for the matched key
        while((int) current.data != (int) keyData) {        // Would need dynamic equality, so need to implement .equals()
            current = current.next;

            if (current == null) {
                return null;
            }
        }

        // Remove links to matched node (remove=delete)
        if (current == first) {
            deleteFirst();
        }
        else if (current == last) {
            deleteLast();
        }
        else {  // Deletes Node current
            current.prev.next = current.next;   //Set next pointer
            current.next.prev = current.prev;   //Set previous pointer
        }

        return current;
    }

    public void printListForward() {
        Node current = first;

        while(current != null) {
            System.out.println(current.data);
            current =  current.next;
        }
    }

    public void printListBackwards() {
        Node current = last;

        while(current != null) {
            System.out.println(current.data);
            current =  current.prev;
        }
    }
}
