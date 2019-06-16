package com.fingolfinor.AlgoDS.algorithms.sorting;

public class MergeSort {

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
    public static void sort(int list[]) {
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
}
