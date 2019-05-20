package com.fingolfinor.AlgoDS.datastructures;

// Array implementation (once created has a fixed max size)
public class Heap {
    private Node[] heapArray;
    private int maxSize;        // max slots available
    private int currentSize;    // how many slots filled

    public Heap(int size) {
        this.maxSize = size;
        currentSize = 0;
        heapArray = new Node[this.maxSize];
    }

    public int getSize() { return currentSize; }

    public boolean isEmpty() { return (currentSize == 0); }

    //TODO
    public void printHeap() {}

    public boolean insert(int key) {
        if (currentSize >= maxSize) {   // array full
            return false;
        }

        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;   // Put node into bottom position of heap

        trickleUp(key); // Place new node in proper position

        currentSize++;

        return true;
    }

    // Trickle new node up until find place in tree
    private void trickleUp(int index) {    //idx = index
        int parentIndex = (index - 1) / 2;
        Node nodeToInsert =  heapArray[index];

        // loop as long as we haven't reached the root and key of nodeToInsert's parent is less than new node
        while(index > 0 && heapArray[parentIndex].getKey() < nodeToInsert.getKey()) {   // Run while parent less than child
            heapArray[index] = heapArray[parentIndex];  // move parent down
            index = parentIndex;

            // Math to get parent, moving up
            parentIndex = (parentIndex - 1) / 2;
        }

        // Index Reached proper position
        heapArray[index] = nodeToInsert;
    }

    // Only ever take from the top?
    public Node remove() {
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];    // Need --currentSize since insert increased currentSize for next insert

        trickleDown(0); //Take node from root and bring down

        return root;    //captured above - what removed
    }

    private void trickleDown(int index) {
        int largerChildIndex;

        //save last node into top variable
        Node top = heapArray[index];

        // run as long as index is not on the bottom row (at least 1-child)
        while (index < currentSize / 2) {
            // Left child index position math formula
            int leftChildIndex = (2 * index) + 1;

            // Right child index position math formula
            int rightChildIndex = leftChildIndex + 1;

            // Which child is larger? for swapping
            if (rightChildIndex < currentSize &&
                    heapArray[leftChildIndex].getKey() < heapArray[rightChildIndex].getKey()) {
                largerChildIndex = rightChildIndex;
            } else {
                largerChildIndex = leftChildIndex;
            }

            if (top.getKey() >= heapArray[largerChildIndex].getKey()) {
                // successfully made root largest key, can exit look
                break;
            }

            heapArray[index] = heapArray[largerChildIndex];

            // Go down
            index = largerChildIndex;
        }

        // assign node to proper position
        heapArray[index] = top;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public class Node {
        private int key;

        public Node(int key) {
            this.key = key;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }
    }
}
