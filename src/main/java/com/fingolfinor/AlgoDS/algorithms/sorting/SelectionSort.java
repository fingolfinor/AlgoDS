package com.fingolfinor.AlgoDS.algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static int[] sort(int[] unsorted) {
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

}
