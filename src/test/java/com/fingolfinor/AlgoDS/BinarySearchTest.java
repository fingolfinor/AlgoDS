package com.fingolfinor.AlgoDS;

import com.fingolfinor.AlgoDS.algorithms.searching.BinarySearch;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {

    int[] listFixture = {1,3,7,9,11,14,21,44,56,79};  //new int[]{1,3};

    @Test
    public void search_findsKeyMiddle_foundKeyMiddle() {
        int expectedValue = 4;
        int actualValue = BinarySearch.search(listFixture, 11);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void search_findsKeyStart_foundKeyStart() {
        int expectedValue = 0;
        int actualValue = BinarySearch.search(listFixture, 1);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void search_findsKeyEnd_foundKeyEnd() {
        int expectedValue = 9;
        int actualValue = BinarySearch.search(listFixture, 79);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void search_findsKeyNot_keyNotFound() {
        int expectedValue = -1;
        int actualValue = BinarySearch.search(listFixture, 9999);

        assertEquals(expectedValue, actualValue);
    }

    //
    // Same Tests - now for non-recursive Binary Search (if tests size increase use a base class)
    //

    @Test
    public void bsSearchLinear_findsKeyMiddle_foundKeyMiddle() {
        int expectedValue = 4;
        int actualValue = BinarySearch.bsSearchLinear(listFixture, 11);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void bsSearchLinear_findsKeyStart_foundKeyStart() {
        int expectedValue = 0;
        int actualValue = BinarySearch.bsSearchLinear(listFixture, 1);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void bsSearchLinear_findsKeyEnd_foundKeyEnd() {
        int expectedValue = 9;
        int actualValue = BinarySearch.bsSearchLinear(listFixture, 79);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void bsSearchLinear_findsKeyNot_keyNotFound() {
        int expectedValue = -1;
        int actualValue = BinarySearch.bsSearchLinear(listFixture, 9999);

        assertEquals(expectedValue, actualValue);
    }
}
