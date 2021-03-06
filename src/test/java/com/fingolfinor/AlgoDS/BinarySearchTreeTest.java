package com.fingolfinor.AlgoDS;

import com.fingolfinor.AlgoDS.algorithms.searching.BinarySearch;
import com.fingolfinor.AlgoDS.datastructures.binarysearchtree.BinarySearchTree;
import com.fingolfinor.AlgoDS.datastructures.binarysearchtree.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTreeTest {


    // TODO unit tests

    // BinarySearchTree
//    BinarySearchTree bst = new BinarySearchTree();
//		bst.insert(10, "Ten");
//		bst.insert(20, "Twenty");
//		bst.insert(15, "Fifteen");
//		bst.insert(3, "Three");
//		bst.insert(33, "Thirty Three");
//		bst.insert(12, "Twelve");
//		System.out.println("BST min: " + bst.findMin());
//		System.out.println("BST max: " + bst.findMax());
//		System.out.println("Removed node: " + bst.remove(10));
//		System.out.println("BST min: " + bst.findMin());
//		System.out.println("BST Tree: ");
//		bst.printTree();


    @Test
    public void insert_insertsInRightSpot_insertedInRightSport() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(11, "eleven");
        bst.insert(1, "one");
        bst.insert(4, "four");
        bst.insert(3, "three");

        int expectedValue = 4;
        int actualValue = bst.getNodeCount();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void minKey_findsCorrectMin_foundCorrectMin() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(11, "eleven");
        bst.insert(100, "one");
        bst.insert(4, "four");
        bst.insert(3, "three");
        bst.insert(7, "three");

        int expectedValue = 3;
        int actualValue = bst.minKey().getKey();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void maxKey_findsCorrectMax_foundCorrectMax() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(11, "eleven");
        bst.insert(100, "one");
        bst.insert(4, "four");
        bst.insert(3, "three");
        bst.insert(7, "three");

        int expectedValue = 100;
        int actualValue = bst.maxKey().getKey();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getByKey_findsCorrectNode_foundCorrectNode() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(11, "eleven");
        bst.insert(100, "one");
        bst.insert(4, "four");
        bst.insert(3, "three");
        bst.insert(7, "three");

        int expectedValue = 7;
        int actualValue = bst.getByKeyRecursively(7).getKey();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getByKey_nullOnNotFound_nullOnNotFound() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(11, "eleven");
        bst.insert(100, "one");
        bst.insert(4, "four");
        bst.insert(3, "three");
        bst.insert(7, "three");

        assertEquals(null, bst.getByKeyRecursively(7777));
    }

    //TODO maybe returns an array or something
    @Test
    public void getSortedTree_sortsTreeCorrectly_sortedTreeCorrectly() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(11, "eleven");
        bst.insert(100, "one");
        bst.insert(4, "four");
        bst.insert(3, "three");
        bst.insert(7, "three");

        bst.printSortedTree();
    }
}