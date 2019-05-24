package com.fingolfinor.AlgoDS.datastructures.linkedlist;


public class LinkedList {

    private Node first;     // think Head of train, engine car

    public LinkedList(){
    }

    public void insertFirst(Object data) {
        Node newNode = new Node(data);
        newNode.next = first;           // Important
        first = newNode;
    }

    public void insertLast(Object data) {
        if (isEmpty()) {
            insertFirst(data);
            return;
        }

        Node current = first;
        while(current.next != null) {
            current = current.next;
        }
        Node newNode = new Node(data);
        current.next = newNode;
    }

    public Node deleteFirst() {
        Node deletedNode = first;
        first = first.next;
        return deletedNode;
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
        return (first == null);
    }

}
