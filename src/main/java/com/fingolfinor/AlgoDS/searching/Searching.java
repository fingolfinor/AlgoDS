package com.fingolfinor.AlgoDS.searching;

import java.util.List;

public class Searching {

    public static int linearSearch(List list, int searchingFor) {
        int answer = -1;
        for (Object item: list) {
            if ((int) item == searchingFor) {
                answer = searchingFor;                                          // Optimize: return here
            }
        }
        return answer;
    }

    public static int binarySearchWhile(int target, int list[]) {
        int startIndex = 0;
        int endIndex = list.length-1;
        int midIndex;

        while (startIndex <= endIndex) {
            // Divide and conquer
            midIndex = (int) Math.floor( (startIndex + endIndex) / 2);  //Forgot parentheses around addition first.. :)
            //Just always use parentheses PRO TIP

            // Found it
            if (list[midIndex] == target) {
                return midIndex;
            }

            // Left side (target is smaller than val)
            if (target < list[midIndex]) {
                endIndex = midIndex-1;
            }
            // Right side (target is bigger than val)
            else {
                startIndex = midIndex+1;
            }
        }

        return -1;
    }

    // Handier API
    public static int binarySearchRecursive(int list[], int target) {
        return binarySearchRecursiveAllParams(list, 0, list.length, target);
    }

    public static int binarySearchRecursiveAllParams(int list[], int startIndex, int endIndex, int target) {
        // Not found - reached "end" of list, exit
        if (startIndex > endIndex) {
            return -1;
        }

        int midIndex = (startIndex + endIndex) / 2;

        // Found it -  exit by returning it
        if (target == list[midIndex]) {
            return midIndex;
        }

        // Go left
        if (target < list[midIndex]) {
            return binarySearchRecursiveAllParams(list, startIndex,  midIndex - 1, target);
        }
        // Go right,  (target > list[midIndex])
        else {
            return binarySearchRecursiveAllParams(list, midIndex + 1, endIndex, target);
        }
    }
}
