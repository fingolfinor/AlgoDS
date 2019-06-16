package com.fingolfinor.AlgoDS.algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {

    // Uses single array for in-array sorting (vs. two arrays how I was taught)
    public static int[] sort(int[] unsorted) {
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
}
