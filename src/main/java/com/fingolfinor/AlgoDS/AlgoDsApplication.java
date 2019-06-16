package com.fingolfinor.AlgoDS;

import com.fingolfinor.AlgoDS.datastructures.*;
import com.fingolfinor.AlgoDS.datastructures.linkedlist.CircularLinkedList;
import com.fingolfinor.AlgoDS.datastructures.linkedlist.DoublyLinkedList;
import com.fingolfinor.AlgoDS.algorithms.searching.BinarySearch;
import com.fingolfinor.AlgoDS.algorithms.sorting.QuickSort;
import com.fingolfinor.AlgoDS.datastructures.queue.QueueCircularArray;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class AlgoDsApplication {


    /**
     *
     * Move below to Unit TEsts then consider removing this app file to avoid confusion.
     *
     */

    //TODO maybe One Day as a Spring App
	//public static void main(String[] args) { SpringApplication.run(AlgoDsApplication.class, args); }


	public static void main(String args[]) {

		// QueueCircularArray: playing
		QueueCircularArray myQueue = new QueueCircularArray(3);
		myQueue.enQueue(1);
		myQueue.enQueue(2);
		myQueue.enQueue(3);
		myQueue.view();

		// Circular LinkedList as QueueCircularArray
		// - use inserLast() to queue up to the end of the chain
		// - use deleteFirst() to deQueue the chain
		System.out.println("\n\nCircular LinkedList as QueueCircularArray");
		CircularLinkedList queueLinkedList = new CircularLinkedList();
		queueLinkedList.insertLast(1);
		queueLinkedList.insertLast(3);
		queueLinkedList.insertLast(7);
		System.out.println("DeQueued: {" + queueLinkedList.deleteFirst().data + "}");
		queueLinkedList.displayList();

		// LinkedList as StackArray
		// - use insertFirst() to push on the first of the chain
		// - use deleteFirst() to pop off from the first part of the chain
		System.out.println("\nCircular LinkedList as StackArray");
		CircularLinkedList stackLinkedList = new CircularLinkedList();
		stackLinkedList.insertFirst(1);
		stackLinkedList.insertFirst(3);
		stackLinkedList.insertFirst(7);
		System.out.println("Pop off StackArray: {" + stackLinkedList.deleteFirst().data + "}");
		stackLinkedList.displayList();

		// DoublyLinkedList: playing
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
		System.out.println("\nPrint doubly linked list: should be empty");
		doublyLinkedList.insertFirst(1);
		doublyLinkedList.insertLast(2);
		doublyLinkedList.insertLast(3);
		doublyLinkedList.deleteFirst();
		doublyLinkedList.deleteLast();
		doublyLinkedList.insertAfter(2, 3);
		doublyLinkedList.insertFirst(1);
		doublyLinkedList.deleteKey(2);
		doublyLinkedList.deleteKey(3);
		doublyLinkedList.deleteKey(1);
		doublyLinkedList.printListForward();

		// LinearSearch: O(n)
		// - list does NOT need to be sorted
		List<Integer> listOfNumbers = Stream.of(1,2,3).collect(Collectors.toList()); // Streams, so hot right now
//		System.out.println("\nLinear Search result: " + BinarySearch.search(listOfNumbers, 2));

		int unsortedListA[] = {9,8,3,13,87,12,99};                  //Note arrays passed by reference, so clone before alter
//
//		// SelectionSort:
//		System.out.println("\nSelections sort: " + Arrays.toString( QuickSort.sort(unsortedListA); ));
//
//		// Insertion Sort:
//		System.out.println("Insertion sort: " + Arrays.toString( QuickSort.sort(unsortedListA)));

		// Merge sort: (NOT WORKING)
		int unsortedListMergeSort[] = {9,8,3,13,87,12,99};
		QuickSort.sort(unsortedListMergeSort);
		System.out.println("Merge sort: " + Arrays.toString(unsortedListMergeSort));

		// Quick-Partition Sort
		int unsortedListQuickSort[] = {12,81,74,43,1098,0,8,92,17,754,912,0,6,4};
		QuickSort.sort(unsortedListQuickSort);
		System.out.println("Quick sort: " + Arrays.toString(unsortedListQuickSort));

		// BinarySearchTree
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10, "Ten");
		bst.insert(20, "Twenty");
		bst.insert(15, "Fifteen");
		bst.insert(3, "Three");
		bst.insert(33, "Thirty Three");
		bst.insert(12, "Twelve");
		System.out.println("BST min: " + bst.findMin());
		System.out.println("BST max: " + bst.findMax());
		System.out.println("Removed node: " + bst.remove(10));
		System.out.println("BST min: " + bst.findMin());
		System.out.println("BST Tree: ");
		bst.printTree();

		// Heap. TODO get working
//        Heap myHeap = new Heap(10);
//        myHeap.insert(10);
//        myHeap.insert(12);
//        myHeap.insert(42);
//        myHeap.insert(35);
//        myHeap.insert(16);
//        myHeap.insert(88);
//        myHeap.insert(42);
//        myHeap.insert(7);
		// TODO print HEAP

		// HashTable
		HashTable hashTable = new HashTable(10);    // Downer that need fixed size upfront.
		hashTable.insert("Apple");
		hashTable.insert("Africa");
		hashTable.insert("Belgium");
		hashTable.insert("Canada");
		hashTable.insert("England");
		hashTable.insert("France");
		hashTable.insert("Germany");
		hashTable.insert("Hungary");
		hashTable.insert("Ireland");
		hashTable.insert("Jamaica");
		hashTable.insert("AWordTeste");
		//TODO HANDLE: hashTable.insert("WE ARE FULL"); <--------- CAUSES AN INFINITE LOOP
		//System.out.println("Find Africa: " + hashTable.find("Africa"));
		//System.out.println("Should Not Find Australia: " + hashTable.find("Australia"));
		//hashTable.displayTable();

		// Graph
		GraphDirectionalArray myGraph = new GraphDirectionalArray(10);
		myGraph.addEdge(0, 1); myGraph.addEdge(0, 2); myGraph.addEdge(0, 3);
		myGraph.addEdge(1, 2); myGraph.addEdge(1, 4);
		myGraph.addEdge(2, 3);
		myGraph.addEdge(3, 1);
		myGraph.addEdge(4, 0);
		myGraph.addEdge(4, 3);
		System.out.println("Graph at 0 length " + myGraph.adj(0).length);
		System.out.println("Graph at 1 length " + myGraph.adj(1).length);

		// Graph LinkedList (better)
		GraphDirectionalLinkedList myBetterGraph = new GraphDirectionalLinkedList(2, "directed");
		myBetterGraph.addVertex("State");
		myBetterGraph.addVertex("Elm");
		myBetterGraph.addEdge("State", "Elm");
		myBetterGraph.print();
	}

}
