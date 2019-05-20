# AlgoDS
Algorithms and Data Structures life-ling learning. Written in Java and run mainly through Unit Tests.


* Unit Tests (note Spring Boot comes with JUnit 4 by default)
Run Unit tests --


 --
 Big-O Algorithm Analysis:
 How well does a program scale? - analysis of algorithms. Algo step-by-step instructions on how the computer should go about solving the problem.
 Efficient if it scales well relative to input size. Below in decreasing efficiency of Growth Rates/Complexity (with Asymptotic Notation where n=input size):
 - constant O(1): one operation on N-input constant (e.g. array access by index)
 - linear O(n): Single-Loop iterates once for every N-input (scales linearly as the input size of input increases)
 - quadratic O(n^2): Nested-loop so N*N operations (quadratic=squared) input time (acceptable slow)
 - cubic O(n^3): 3-Nested loop (N*N*N operations)
 - exponential O(c^n), c > 1: N-nested loops(very inefficient)
 - logarithmic O(log(n)): 1-loop
 Equating:  (looking at worse case always)
 - Complexity of: 37n^3 + 18n^2 + 190 = O(n^3)  //dominating term is n^3

 --
 Searching & Sorting

 Linear Search - O(n)
 - *unordered, list where every item is search

 Binary Search - O(log n) if a Balanced Tree, or if Unbalanced worst case could even be O(n)
 - *sorted, keep halfing until find target

 Selection Sort, O(n^2) worst case
 - find the smallest and swap in place, go to next and repeat to end of list

 Insertion Sort, O(n^2) worst case
 - "sort on insertion" in sorted area, like using 2 arrays but think of left sorted half as sorted insert array

 Merge Sort, O(n Log n) worst and best case,  divide and conquer
 1) "splitting" data in halves until 1-size base-case,
 2) "merge" each split *sorted array by merging (sort) two parts together, until complete
 - con requires copies of array, so more memory

 Quick Sort (aka Partition Sort), O(n Log n) avg case and O(n^2) worst case
 1) Partitioning to get pivot index
 2) less recursive left, greater recursive right,  shrinking range each iteration then sorted
 + less space since in memory array

 --
 DATA STRUCTURES

 Linked List:
 - made up of Nodes that are "sef referential/recursive class"es having a next point to another Node
 - pros: non fixed size, so unlike an array don't have recreate for any *removal/insert or *re-sizing

 Stack:
 - LIFO, two operations - on top = push, take off top = pop (building on array)
 - uses: reverse a word, equation string parsing (managing parenthesis)

 Queue:
 - FIFO, two operations - fairly address items that come first (building on array)
 - Circular queue - when reach end, overwiting beginning of Queue (not so fair :)
 - uses: doctor queue, printer queue..

 Abstract Data Type (ADT)
 - "trustworthy containers capable of doing things with data"
 - data variables and operations can run on data (a Class is a ADT) through an API

 Binary Search Tree: (MOST POPULAR IN CS)
 - benefits of searching *sorted list, insert/delete like linked-list
 - an upside down tree, root then children nodes (node left and right), leaf node has no child
 - rule=for any child node, Left node must be less than Right node

 Heap
 - A binary tree where *Left most child is filled first then to right, array used + math to find rels
 - Max Heap: 1) root node is largest (or equal) in tree, 2) Children less or equal to Parent
 - Min Heap: (opposite)


 --
Reminders

 Arrays..
 Indexes, 0-N think index position, makes sort of sense to start at 0   (size - 1)
 Size measurement, 1-N think how big, at least a size of 1  (last index + 1)

