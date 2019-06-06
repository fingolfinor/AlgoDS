# AlgoDS
>>>
>>> Next Up: Implement QueueArray (with interface) and QueueLinkedList
>>>

Algorithms and Data Structures ongoing learning. Written in Java and run mainly through Unit Tests.
(~Tip draw to understand/reason)

Run the JUnit Unit Tests using whatever IDE testing tool. (note Spring Boot comes with JUnit 4 by default)

## Data Structures

Bits and Bytes:
- 1 Bit smallest unit of measure where 8 Bits = 1 Bytes
- 1 Byte can have values 0 to 255. 1024 Bytes = 1 Kilo (10^3) Byte.
  1 Byte = 1 Character (historically). Octet = Byte
- 1024 Kilo Bytes = 1 Mega (10^6) Byte, etc.

Bit String (Bitmap):
- Bit String = Bit Array = Bitmap = is a compact data structure that stores
  bits (binary values). Fast operations though compression should be used.
- This is what people mean when they say stored in raw binary data.

Array:
- One level up from raw memory where a fixed-size segment of allocated memory
  can have internals accessed by a pointer index. In most languages resizing
  an array requires a new memory allocation.
  An array is excellent at retrieval but slow for many additions/removals
  because of memory reallocation.
- ArrayList is a self-resizing Array
- Indexes, 0-N think index position, makes sort of sense to start at 0   (size - 1)
   Size measurement, 1-N think how big, at least a size of 1  (last index + 1)

Linked List:
- (old) A Linked List is a dynamically allocated memory list where a Controller manages a list of nodes that each have
   a Next pointer. The Controller also keeps track of the first and last element in the list, as well get, set, and
   delete. LinkedLists are fast at adding & removing elements but N-times slow as the listsize grows for retrievng elems
- made up of Nodes that are "self referential/recursive class"es having a Next Node point to another Node
- pros: non fixed size, so unlike an array don't have recreate for any *removal/insert or *re-sizing

Doubly Linked List:
- Add a Previous to the node of a Linked List for a DoublyLinkedList that
  improves removal performance.

Stack:
- Follows a LIFO order with the two operations Push, that adds a node to the top
  of the Stack, and that removes the top node (reverse order of being added) from
  the Stack. Commonly used in Recursion for the call and return statements.
- LIFO, two operations - on top = push, take off top = pop (building on array)
- uses: reverse a word, equation string parsing (managing parenthesis)

Queue:
- First In First Out (FIFO) linear DS that retains order & de-queues first added in list and en-queues last pos in list
- Circular queue - when reach end, overwiting beginning of Queue
- uses: doctor queue, printer queue..

Abstract Data Type (ADT)
- "trustworthy containers capable of doing things with data"
- data variables and operations can run on data (a Class is a ADT) through an API

Binary Search Tree: (MOST POPULAR IN CS)
- BST is an ordered tree structure that is balanced where values to the Left of
  the Root node are less, and greater to the Right. Each branch is in turn a is
  BST.
  O(log(n)) for insertions and searches. Example usage is in a Spell Checker.
- A Red-Black Tree is a variant with the least amount of performance fluctation.
- benefits of searching *sorted list, insert/delete like linked-list
- an upside down tree, root then children nodes (node left and right), leaf node has no child
- rule=for any child node, Left node must be less than Right node

Heap
- A binary tree where *Left most child is filled first then to right, array used + math to find rels
- Max Heap: 1) root node is largest (or equal) in tree, 2) Children less or equal to Parent
- Min Heap: (opposite)

Hash
- Simple and Efficient, a beautiful algorithm!! (most popular)
- Uses an Array DS and accesses via Index, using a Hashing function that maps Objects to Indexes.
- Big-O Insert, Retrieve, (often delete) - O(1) constant time!

Graph
- Group of Nodes with relationships that form paths, directional and undirectional graphs


## Algorithms

Algorithms are step-by-step instructions on how the computer should go about solving the problem.

### Big-O Algorithm Analysis
Analysis of algorithms is about How well does a program scale? Efficient if it scales well relative to input size.
Below in decreasing efficiency of Growth Rates/Complexity (with Asymptotic Notation where n=input size):
 - constant O(1): one operation on N-input constant (e.g. array access by index)
 - linear O(n): Single-Loop iterates once for every N-input (scales linearly as the input size of input increases)
 - quadratic O(n^2): Nested-loop so N*N operations (quadratic=squared) input time (acceptable slow)
 - cubic O(n^3): 3-Nested loop (N*N*N operations)
 - exponential O(c^n), c > 1: N-nested loops(very inefficient)
 - logarithmic O(log(n)): 1-loop

Equating:  (looking at worse case always)
e.g. Complexity of: 37n^3 + 18n^2 + 190 = O(n^3)  //dominating term is n^3


### Searching & Sorting

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



