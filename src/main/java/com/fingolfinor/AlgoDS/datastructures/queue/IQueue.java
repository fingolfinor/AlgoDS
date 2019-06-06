package com.fingolfinor.AlgoDS.datastructures.queue;


public interface IQueue {

    void enQueue(Object o);

    Object deQueue();

    Object peakFront();

    boolean isEmpty();

    // Note: Does not make sense for dynamic list types like a LinkedList
    // boolean isFull();
}
