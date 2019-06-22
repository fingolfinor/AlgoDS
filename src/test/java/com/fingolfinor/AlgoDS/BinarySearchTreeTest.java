package com.fingolfinor.AlgoDS;

import com.fingolfinor.AlgoDS.algorithms.searching.BinarySearch;
import com.fingolfinor.AlgoDS.datastructures.binarysearchtree.BinarySearchTree;
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
    public void findMin_findsCorrectMin_foundCorrectMin() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(11, "eleven");
        bst.insert(100, "one");
        bst.insert(4, "four");
        bst.insert(3, "three");
        bst.insert(7, "three");

        int expectedValue = 3;
        int actualValue = bst.min().getKey();

        assertEquals(expectedValue, actualValue);
    }

//    @Test
//    public void search_findsKeyEnd_foundKeyEnd() {
//        int expectedValue = 9;
//        int actualValue = BinarySearch.search(listFixture, 79);
//
//        assertEquals(expectedValue, actualValue);
//    }
//
//    @Test
//    public void search_findsKeyNot_keyNotFound() {
//        int expectedValue = -1;
//        int actualValue = BinarySearch.search(listFixture, 9999);
//
//        assertEquals(expectedValue, actualValue);
//    }
}
