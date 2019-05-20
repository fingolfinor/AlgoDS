package com.fingolfinor.AlgoDS;

//import org.springframework.boot.SpringApplication;
import com.fingolfinor.AlgoDS.datastructures.*;
import com.fingolfinor.AlgoDS.datastructures.linkedlist.CircularLinkedList;
import com.fingolfinor.AlgoDS.datastructures.linkedlist.DoublyLinkedList;
import com.fingolfinor.AlgoDS.datastructures.linkedlist.LinkedList;
import com.fingolfinor.AlgoDS.searching.Searching;
import com.fingolfinor.AlgoDS.sorting.Sorting;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class AlgoDsApplication {

	//TODO maybe One Day as a Spring App
	//public static void main(String[] args) { SpringApplication.run(AlgoDsApplication.class, args); }


	public static void main(String args[]) {
//        CounterADT counterADT = new CounterADT("MyCounter");
//        System.out.println(counterADT.increment().increment().increment());
//
//        // Stack: playing
//        Stack stack = new Stack(2);
//        stack.push(1); stack.push(2); stack.push(3);
//        while (!stack.isEmpty()) { System.out.println(stack.pop()); }
//        System.out.println("Reverse word Hello: " + reverseWord("Hello"));

		// Queue: playing
		Queue myQueue = new Queue(3);
		myQueue.enQueue(1);
		myQueue.enQueue(2);
		myQueue.enQueue(3);
		myQueue.view();

		// LinkedList: playing
		LinkedList linkedList = new LinkedList();
		linkedList.insertFirst(1);
		linkedList.insertFirst(3);
		linkedList.insertFirst(7);
		linkedList.displayList();

		// Circular LinkedList as Queue
		// - use inserLast() to queue up to the end of the chain
		// - use deleteFirst() to deQueue the chain
		System.out.println("\n\nCircular LinkedList as Queue");
		CircularLinkedList queueLinkedList = new CircularLinkedList();
		queueLinkedList.insertLast(1);
		queueLinkedList.insertLast(3);
		queueLinkedList.insertLast(7);
		System.out.println("DeQueued: {" + queueLinkedList.deleteFirst().data + "}");
		queueLinkedList.displayList();

		// LinkedList as Stack
		// - use insertFirst() to push on the first of the chain
		// - use deleteFirst() to pop off from the first part of the chain
		System.out.println("\nCircular LinkedList as Stack");
		CircularLinkedList stackLinkedList = new CircularLinkedList();
		stackLinkedList.insertFirst(1);
		stackLinkedList.insertFirst(3);
		stackLinkedList.insertFirst(7);
		System.out.println("Pop off Stack: {" + stackLinkedList.deleteFirst().data + "}");
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
		System.out.println("\nLinear Search result: " + Searching.linearSearch(listOfNumbers, 2));

		// BinarySearch:
		// - list MUST be sorted
		int sortedListA[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println("\nBinary Search (while): found at Index " + Searching.binarySearchWhile(7, sortedListA));
		System.out.println("Binary Search (recursive): fount at Index " + Searching.binarySearchRecursive(sortedListA, 7));


		int unsortedListA[] = {9,8,3,13,87,12,99};                  //Note arrays passed by reference, so clone before alter

		// SelectionSort:
		System.out.println("\nSelections sort: " + Arrays.toString( Sorting.selectionSort(unsortedListA) ));

		// Insertion Sort:
		System.out.println("Insertion sort: " + Arrays.toString( Sorting.insertionSort(unsortedListA)));

		// Merge sort: (NOT WORKING)
		int unsortedListMergeSort[] = {9,8,3,13,87,12,99};
		Sorting.mergeSort(unsortedListMergeSort);
		System.out.println("Merge sort: " + Arrays.toString(unsortedListMergeSort));

		// Quick-Partition Sort
		int unsortedListQuickSort[] = {12,81,74,43,1098,0,8,92,17,754,912,0,6,4};
		Sorting.quickSort(unsortedListQuickSort);
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




	///////////////////////////////////
	// Playing with stacks
	///////////////////////////////////

	// Note: would probably want to update custom Stack class to accept Objects or at least Chars for this case
	public static String reverseWord(String word) {
		int stackSize = word.length();
		Stack stack = new Stack(stackSize);
		String reversedWord = "";

		// Push vals on stack
		for (int i = 0; i < stackSize; i++) {
			stack.push(i);
		}

		// Reverse vals by popping off stack onto string
		while (!stack.isEmpty()) {
			int charIndex = (int) stack.pop();
			reversedWord = reversedWord + word.charAt(charIndex);
		}

		return reversedWord;
	}
}
