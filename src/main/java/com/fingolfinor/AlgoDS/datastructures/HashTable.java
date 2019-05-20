package com.fingolfinor.AlgoDS.datastructures;

/**
 * Big-O Insert, Retrieve, (often delete) - O(1) constant time!
 * Simple and Efficient, a beautiful algorithm!!
 *
 * Uses an Array DS and accesses via Index, using a Hashing function that maps Objects to Indexes.
 *
 * Hashing Function Conflict Resolution (conflicts will eventually happen):
 * - Linear Probing: on conflict (at x), try next slot to right (x + 1) until finding an empty one (aka. Open Addressing)
 *      (on insert and lookup, follow the linear probing strat. problem will cause Clustering that lookup
 *      can go from O(1) to O(n) )
 * - Quadratic Probing: same as above but advance (x + 1^2) if full then (x + 2^2).. better but same problem of Clusters
 * - *Double Hashing: on conflict, use a second Hashing function. (until find) Can still Cluster but less likely.
 *      (aka. Double Open Addressing) (BEST APPROACH)
 *      Note: Array Size must be a *Prime Number when Double Hashing.
 *      Note: since Array, *size must be fixed.
 * - Separate Chaining: on conflict, use a LinkedList to just add collided Elements into the same Slot.
 *
 * e.g. SpellCheck uses this, to look up words for super fast retrieval
 */
public class HashTable {

    /**
     * Note: Array Size must be a Prime Number.
     * Since Using Modulus for Hashing, if it was not Prime, eventually the remainder would be even and the Step-1 to
     * Step-2 process would start again and we'd be in an infinite loop stuck in the same sequence. If Prime, when the
     * Steps get to a stepsize bigger than arraysize, the remainder will be bigger than 1 (not 0 if not a prime) and
     * the positions can increase.
     */
    String[] hashArray; //TODO with different type (enhance e.g. as a Dictionary <-- lookup DS)

    int arraySize;

    // Counter for number of elements in hash table
    int size = 0;


    public HashTable(int noOfSlots) {
        if (isPrime(noOfSlots)) {
            hashArray = new String[noOfSlots];
            arraySize = noOfSlots;
        } else {
            int primeCount = getNextPrime(noOfSlots);
            hashArray = new String[primeCount];
            arraySize = primeCount;

            System.out.println("Hash tame size given " + noOfSlots + " is not a Prime. Changed to size " + primeCount);
        }
    }

    public void insert(String word) {
        int preferedHashVal = hashFunc1(word);
        int stepSize = hashFunc2(word);

        /**
         * Looking for empty slot. Repeat until an empty slot:
         *
         * Step 1: index = index + step_size
         * Step 2: index = index % array_size
         */
        while (hashArray[preferedHashVal] != null) {
            preferedHashVal = preferedHashVal + stepSize;
            preferedHashVal = preferedHashVal % arraySize;
        }

        // Insert the val!
        hashArray[preferedHashVal] = word;
        size++;
        System.out.println("Inserted word " + word);
    }

    // Same process as insert (almost)
    public String find(String word) {
        int preferedHashVal = hashFunc1(word);
        int stepSize = hashFunc2(word);

        while (hashArray[preferedHashVal] != null) {
            // Here is difference from insert()
            if (hashArray[preferedHashVal].equals(word)) {                  // ! .equals() for comparing Objects and strings and.. (non primitives)
                return hashArray[preferedHashVal];
            }

            preferedHashVal = preferedHashVal + stepSize;
            preferedHashVal = preferedHashVal % arraySize;
        }

        // Just return where left off, should be null
        return hashArray[preferedHashVal];
    }

    public void displayTable() {
        System.out.println("Table: ");
        for (int i = 0; i < arraySize; i++) {
            // Data in this slot
            if (hashArray[i] != null) {
                System.out.print(hashArray[i] + " ");
            }
            // Data not in this slot
            else {
                System.out.print("** ");
            }
            System.out.println("");
        }
    }

    private boolean isPrime(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int getNextPrime(int minNumber) {
        for (int i = minNumber; true; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
    }

    // Returns preferred index position
    // Convert Word into a hash code (value)
    private int hashFunc1(String word) {
        int hashVal = word.hashCode();
        hashVal = hashVal % arraySize;

        // Java can return negative vals with hashCode() it's biggg so need to check for this
        if (hashVal < 0) {
            hashVal += arraySize;
        }

        return hashVal; // Idea index position we'd like to insert or search in
    }

    // Returns Step Size (greater than 0, or would get into an infinite loop)
    private  int hashFunc2(String word) {
        int hashVal = word.hashCode();
        hashVal = hashVal % arraySize;

        if (hashVal < 0) {
            hashVal += arraySize;
        }

        // Research shows that you can use a Prime number Less than the array size to calculate the step value.
        // Prime Number 3 arbitrarily chosen.
        return 3 - hashVal % 3;
    }
}
