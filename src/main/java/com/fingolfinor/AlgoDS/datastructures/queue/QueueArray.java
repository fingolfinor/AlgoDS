package com.fingolfinor.AlgoDS.datastructures.queue;

import java.util.ArrayList;

public class QueueArray implements IQueue {

    private ArrayList<Object> queue;

    public QueueArray() {
        this.queue = new ArrayList<Object>();
    }

    public void enQueue(Object o) {
        // Adds to end of Array (queue)
        queue.add(o);
    }

    public Object deQueue() {
        if (isEmpty()) {
            return -1;
        }

        // Dequeues first element added to list - always position 0
        return queue.remove(0);
    }

    public Object peakFront() {
        if (isEmpty()) {
            return -1;
        }

        return queue.get(0);
    }

    public boolean isEmpty() {
        return 0 == queue.size();
    }
}
