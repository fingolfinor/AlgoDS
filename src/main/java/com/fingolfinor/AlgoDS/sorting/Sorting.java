package com.fingolfinor.AlgoDS.sorting;

import java.util.Arrays;

public class Sorting {

    public static int[] selectionSort(int[] unsorted) {
        //Note arrays passed by reference, so clone before alter
        int sorted[] = Arrays.copyOfRange(unsorted, 0, unsorted.length);

        // Loop through each element
        // increase outerPosition
        for (int i = 0; i < sorted.length; i++) {
            int minimum = i;

            // Loop from position, increase innerPosition, noting smallest
            for (int j = i + 1; j < sorted.length; j++) {                 //i + 1, since comparing current with next to start
                if (sorted[j] < sorted[i]) {
                    minimum = j;
                }
            }

            // swap outerPosition with smallest
            int temp = sorted[i];
            sorted[i] = sorted[minimum];
            sorted[minimum] = temp;
        }

        return sorted;
    }


    // Uses single array for in-array sorting (vs. two arrays how I was taught)
    public static int[] insertionSort(int[] unsorted) {
        //Note arrays passed by reference, so clone before alter
        int list[] = Arrays.copyOfRange(unsorted, 0, unsorted.length);

        // Hit every element, past first - first is considered sorted
        for (int unsortedIndex = 1; unsortedIndex < list.length; unsortedIndex++) {
            // variable contains data we intend to bring over to the sorted area
            int unsortedElement = list[unsortedIndex];

            // points to last value in sorted area
            int sortedIndex = unsortedIndex - 1;

            // insert new element into sorted portion by swapping each greater than element
            while (sortedIndex >= 0 && list[sortedIndex] > unsortedElement) {        //Messed up J: for (int j = i - 1; j >= 0 && sorted[j] > element; j--) {
                list[sortedIndex + 1] = list[sortedIndex];
                sortedIndex--;
            }

            list[sortedIndex + 1] = unsortedElement;                                 //Messed up J: sorted[i + 1] = element;
        }

        return list;
    }


    /**
     * MERGESORT ( A, p, r) {
     *      if (p < r) {
     *          q = [(p + r) / 2]       // Midpoint (floored)
     *          mergeSort(A, p, q)      // Left side including midpoint
     *          mergeSort(A, q + 1, r)  // Right side of midpoint
     *          merge(A, p, q, r)       // *Heart of algo, sorting done on Merge
     *      }
     * }
     *
     * Separates recursively into 1-sized arrays, and sorts on Merging arrays back together.
     * Con: lots of space to create all those arrays.
     */
    public static void mergeSort(int list[]) {
        ms(list, 0, list.length - 1);
    }
    public static void ms(int inputArray[], int start, int end) {
        if (start >= end) { // Base case
            return;
        }

        int mid = (start + end) / 2; // middle index *floored.
        ms(inputArray, start, mid); // Split left side of array
        ms(inputArray,  mid + 1, end); // Split right side of array
        msMerge(inputArray, start, mid, end); // merge sorted results into the input array
    }

    /**
     * MERGE (A, p=start, q=mid, r=end) { //Requires sub-arrays *must be sorted
     *     left_cnt = q - p + 1     // number elements in left sorted array
     *     right_cnt = r - q    // number of elements in right sorted array
     *     Let L[0...left_cnt + 1] and R[1...right_cnt + 1] be new arrays
     *     Copy A into respective L and R arrays
     *     i = 0, j = 0
     *     For (k = p to r) {
     *         if L[i] > R[i] {
     *             A[k] = L[i]
     *             i++
     *         } else {
     *             A[k] = R[j]
     *             j++
     *         }
     *     }
     * }
     */
    public static void msMerge(int inputArray[], int start, int mid, int end) {
        int tempArray[] = new int[end - start + 1]; // +1 since giving a size and index starts at 0
        int leftSlot = start; // Left starting position index
        int rightSlot = mid + 1; //Right starting position index after midpoint (+1 since after mid point)
        int comparisonIndex = 0;  // index for inserting into next available slot

        // Sorts data - compare until the end of each portion of the array
        while(leftSlot <= mid && rightSlot <= end) {
            // comparison at indexes, left is smaller
            if (inputArray[leftSlot] < inputArray[rightSlot]) {
                tempArray[comparisonIndex] = inputArray[leftSlot];
                leftSlot++;
            }
            // by elimination, right is smaller
            else {
                tempArray[comparisonIndex] = inputArray[rightSlot];
                rightSlot++;
            }
            comparisonIndex++;
        }

        // Data is sorted, so  both right and left of the sub-array is sorted at this point.
        // Handle un-balanced sorting of arrays
        // if one is,  copy it's values to the temp array and update indexes to end positions
        if (leftSlot <= mid) {  // Consider right side done being sorted, left must be sorted already
            // Copy over data from right to temp
            while(leftSlot <= mid) {
                tempArray[comparisonIndex] = inputArray[leftSlot];
                leftSlot++;
                comparisonIndex++;
            }
        } else {    //otherwise right side by elimination
            // Copy over data from left to temp
            while (rightSlot <= end) {
                tempArray[comparisonIndex] = inputArray[rightSlot];
                rightSlot++;
                comparisonIndex++;
            }
        }

        // Copy over the tempArray into the appropriate slots of the inputArray
        for (int i = 0; i < tempArray.length; i++) {
            inputArray[start + i] = tempArray[i];
        }
    }

    /**
     * QUICK SORT aka Partition Sort
     * if (p<r) {
     *     q = Partition(A, p, r)   // *Heart of algo, sorting done around Partition pivot
     *     qs(A, p, q-1)    // Sort left of partition
     *     qs(A, q + 1, r)  // Sort right of parition
     * }
     */
    public static void quickSort(int[] list) {
        qs(list, 0, list.length - 1);
    }
    public static void qs(int[] list, int left, int right) {
        if (left < right) {
            int partition = qsPartition(list, left, right); //index of correctly placed position value
            qs(list, left, partition - 1);  // left
            qs(list, partition + 1, right);  // right
        }
    }
    /**
     * PARTITION(A, p, r) {
     *     x = A[r]
     *     i = p - 1
     *     for (j = p to r - 1) {
     *         if (A[j] <= x) {
     *             i = i + 1
     *             swap A[i] with A[j]
     *         }
     *     }
     *     swap A[i + 1] with A[r]
     *     return i + 1;
     * }
     */
    public static int qsPartition(int[] list, int left, int right) {
        // *Use right most element for Pivot (most CS books agree on this)
        int pivot = list[right];

        int pLeft = left - 1; // first iteration starts at -1

        // continue swapping any val less than Pivot unti end of list
        for (int pRight = left; pRight < right; pRight++) {
            if (list[pRight] <= pivot) {
                pLeft++;
                swap(list, pLeft, pRight);
            }
        }

        // swap Pivot into correct slot where values left of Pivot are smaller
        swap(list, pLeft + 1, right);
        return pLeft  + 1;
    }


    // Util function
    public static void swap(int[] list, int indexA, int indexB) {
        int temp = list[indexA];
        list[indexA] = list[indexB];
        list[indexB] = temp;
   }
}
