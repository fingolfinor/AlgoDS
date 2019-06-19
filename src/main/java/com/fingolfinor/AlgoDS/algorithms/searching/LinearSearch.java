package com.fingolfinor.AlgoDS.algorithms.searching;

import java.util.List;

public class LinearSearch {

    public static int search(List list, int searchingFor) {
        int answer = -1;
        for (Object item: list) {
            if ((int) item == searchingFor) {
                answer = searchingFor;  // Optimize: return here
            }
        }
        return answer;
    }
}
