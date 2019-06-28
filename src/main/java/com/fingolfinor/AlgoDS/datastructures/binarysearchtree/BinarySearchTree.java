package com.fingolfinor.AlgoDS.datastructures.binarysearchtree;

import java.lang.reflect.Array;
import java.util.List;

/**
 * BINARY SEARCH TREE (BST)
 * Sorted DS that allows fast lookup, additions and removals.
 *
 * Big-O: average O(log n), worst O(n)
 *
 * Note Big-O is slower than a HashTable but has the advange of being sorted.
 *
 *  ~~ If stuck see Wikipedia to start :)
 */
public class BinarySearchTree {

    private Node root;

    // Mainly for unit testing
    private int nodeCount = 0;

    public int getNodeCount() {
        return nodeCount;
    }

    public void insert(int key, String value) {
        Node nodeToInsert = new Node(key, value);
        nodeCount++;

        // check for empty tree
        if (root == null) {
            root = nodeToInsert;
            return;
        }

        // search until empty spot for insertion
        Node current = root;
        Node parent = null;
        while (true) {
            parent = current;

            if (key < current.key) {
                // go left side
                current = current.leftChild;

                // is it empty, insert here
                if (current == null) {
                    parent.leftChild = nodeToInsert;
                    break;
                }
            }
            else {
                // go right
                current = current.rightChild;

                // is it empty, insert here
                if (current == null) {
                    parent.rightChild = nodeToInsert;
                    break;
                }
            }
        }
    }

    public Node getByKey(int key) {
        Node current = root;

        while(current != null) {
            System.out.println("node" + current);
            if (current.getKey() == key) {
                return current;
            }
            else if (key < current.getKey()) {
                current = current.leftChild;
            }
            else {
                current = current.rightChild;
            }
        }

        // Not found
        return null;
    }

    public Node getByKeyRecursively(int key) {
        return getByKeyRecursivelyHelper(key, root);
    }
    public Node getByKeyRecursivelyHelper(int key, Node current) {
        if (current == null) {
            return null;
        }
        if (current.getKey() == key) {
            return current;
        }

        if (key < current.getKey()) {
           return getByKeyRecursivelyHelper(key, current.leftChild);
        } else {
            return getByKeyRecursivelyHelper(key, current.rightChild);
        }
    }

    public void printSortedTree() {
        printSortedTreeHelper(root);
    }
    public void printSortedTreeHelper(Node localRoot) {
        // Recursively call until left most end of tree
        if (localRoot.leftChild != null) {
            printSortedTreeHelper(localRoot.leftChild);
        }

        // For each level of recursion print the value in Order (out of order at top or end oddly)
        System.out.println(localRoot.key);

        // For each level of left recursion visit right side as well
        if (localRoot.rightChild != null) {
            printSortedTreeHelper(localRoot.rightChild);
        }
    }


    // Find the Node with the smallest Key
    // The algorithm traverses the left side of tree from leftChild to leftChild until the bottom of the tree is reached
    // which is the smallest index in the BST.
    public Node minKey() {
        Node current = root;

        // go left until child null, this is the min based on DS
        while (current != null) {
            if (current.leftChild == null) {
                // Found min node, break out of loop
                break;
            }

            // Otherwise keep going down the left side of the tree
            current = current.leftChild;
        }

        // End of Left side of tree, this is the min key.
        return current;
    }


    // Node with max key value will be furthest right Node
    public Node maxKey() {
        Node current = root;

        // Traverses Right side of tree until bottom reached which is the greatest index in the BST.
        while (current != null && current.rightChild != null) {
            current = current.rightChild;
        }

        // End of Right side of tree, this is the max key.
        return current;
    }


    public boolean remove(int key) {
        Node currentNode = root;
        Node parent = root;
        boolean isLeftChild = false;

        // Find the target Node to delete
        while (currentNode.key != key) {
            parent = currentNode;

            // Node doesn't exist - exit
            if (currentNode == null) {
                return false;
            }

            if (currentNode.key < key) {
                isLeftChild = true;
                currentNode = currentNode.leftChild;
            } else {
                isLeftChild = false;
                currentNode = currentNode.rightChild;
            }
        }

        // Node found at this point, more readable name here
        Node nodeToDelete = currentNode;

        // Case Leaf - Parent null reference on Node
        if (nodeToDelete.leftChild == null && nodeToDelete.rightChild == null) {
            if (nodeToDelete == root) {     //~forgot this one
                nodeToDelete = null;
            }
            else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }

        // Case 1-Child on Target Right - delete by assigning Parent reference to Child's Right Child.
        else if (nodeToDelete.leftChild == null) { //~tried to combine them both and this won't work
            if (nodeToDelete == root) {     //~forgot this one
                root = nodeToDelete.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = nodeToDelete.rightChild;
            } else {
                parent.rightChild = nodeToDelete.rightChild;
            }
        }
        // Case 1-Child on Target Left - delete by assigning Parent reference to Child's Left Child.
        else if (nodeToDelete.rightChild == null) {
            if (nodeToDelete == root) {
                root = nodeToDelete.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = nodeToDelete.leftChild;
            } else {
                parent.rightChild = nodeToDelete.leftChild;
            }
        }

        // Case 2-Children+ - Current find smallest Node down Left sub-tree, Replace this node with nodeDeleting
        else {
            Node successor = getSuccessor(nodeToDelete);    //smallest left node of right child

            //1 connect parent of nodeToDelete to successor instead
            if (nodeToDelete == root) {
                root = successor;
            } else if(isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }

            //2 replace
            successor.leftChild = nodeToDelete.leftChild;
        }

        return true;
    }

    public Node getSuccessor(Node nodeToDelete) {   // Not following SOLID
        Node successorParent = nodeToDelete;
        Node successor = nodeToDelete;

        // Go right
        Node current = nodeToDelete.rightChild;

        // Then go left all the way until Node has no left child
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        // if succor is left descendent of right child
        if (successor != nodeToDelete.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = nodeToDelete.rightChild;
        }

        return successor;
    }
}
