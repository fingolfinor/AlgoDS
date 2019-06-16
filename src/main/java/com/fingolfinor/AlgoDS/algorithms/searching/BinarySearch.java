package com.fingolfinor.AlgoDS.algorithms.searching;



/**
 * BinarySearch like it's name suggests, searches either one direction (left if less) or the other (right if greater).
 * It is a divide an conquer algorithm by each iteration halving the List for the direction in that iteration.
 *
 * Big-O: O(log n)
 * Memory: O(1) (Array DS)
 * Requirement: List is *Sorted*
 *
 * Note: is *not* related to a Binary Tree DS, other than a Binary Tree being sorted and it can implement BS.
 */
public class BinarySearch {

    /**
     *
     * @param list
     * @param key
     * @return int index of found key in sent list
     */
    public static int search(int[] list, int key) {
        // Facade over bsSearch to make the User API a little simpler
        return bsSearch(list, key, 0, list.length - 1);
    }
    // Note: Save space by sending array indexes vs. cloning a smaller copy of the array each iteration
    public static int bsSearch(int[] list, int key, int leftIndex, int rightIndex) {
        // Not found - reached "end" of list, exit
        if (leftIndex > rightIndex) {   // Original way, wrong - //if (list.length <= 1) {
            return -1;
        }

        // note: int auto floors a decimal number
        int midPoint = (leftIndex + rightIndex) / 2;

        // Found it -  exit by returning list index position of matched item
        if (key == list[midPoint]) {
            return midPoint;
        }

        // Go Left (side of midPoint)
        if (key < list[midPoint]) {
            return bsSearch(list, key, leftIndex, midPoint - 1);
        }
        // Go Right (side of midPoint)
        else { //if (key > list[midPoint]) {
            return bsSearch(list, key, midPoint + 1, rightIndex);
        }
    }


    // COPIED re-do
    public static int bsSearchLinear(int list[], int target) {
        int startIndex = 0;
        int endIndex = list.length - 1;
        int midIndex;

        while (startIndex <= endIndex) {
            // Divide and conquer
            midIndex = (int) Math.floor((startIndex + endIndex) / 2);  //Forgot parentheses around addition first.. :)
            //Just always use parentheses PRO TIP

            // Found it
            if (list[midIndex] == target) {
                return midIndex;
            }

            // Left side (target is smaller than val)
            if (target < list[midIndex]) {
                endIndex = midIndex - 1;
            }
            // Right side (target is bigger than val)
            else {
                startIndex = midIndex + 1;
            }
        }

        return -1;
    }

}