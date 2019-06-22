package com.fingolfinor.AlgoDS.datastructures.binarysearchtree;

/**
 * Node DS for BinarySearchTree
 */
public class Node {
    int key;

    // TODO replace with Object
    String value;

    // Self referential values
    Node leftChild;
    Node rightChild;

    public Node(int key, String value) {
        //super();
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node with key=" + key + ", value='" + value;
    }
}
