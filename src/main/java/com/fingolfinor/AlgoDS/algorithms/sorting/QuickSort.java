package com.fingolfinor.AlgoDS.algorithms.sorting;


public class QuickSort {

    /**
     * QUICK SORT aka Partition Sort
     * if (p<r) {
     *     q = Partition(A, p, r)   // *Heart of algo, sorting done around Partition pivot
     *     qs(A, p, q-1)    // Sort left of partition
     *     qs(A, q + 1, r)  // Sort right of parition
     * }
     */
    public static void sort(int[] list) {
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
