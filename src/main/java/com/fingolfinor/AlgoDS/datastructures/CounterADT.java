package com.fingolfinor.AlgoDS.datastructures;

/**
 *  Abstract Data Type (ADT)
 *  - "trustworthy containers capable of doing things with data"
 *  - data variables and operations can run on data (a Class is a ADT) through an API
 *
 *  e.g. COUNTER BELOW
 */

public class CounterADT {
    private int count;
    private String name;

    public CounterADT(String name) {
        this.count = 0;
        this.name = name;
    }

    public CounterADT increment() {
        count++;
        return this;    // Just for fun - allows chaining
    }

    public int getCurrentValue() {
        return count;
    }

    @Override
    public String toString() {
        return "CounterADT{" +
                "count=" + count +
                ", name='" + name + '\'' +
                '}';
    }
}
