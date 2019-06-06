package com.fingolfinor.AlgoDS.datastructures.queue;


import com.fingolfinor.AlgoDS.datastructures.linkedlist.LinkedList;
import com.fingolfinor.AlgoDS.datastructures.linkedlist.Node;

public class QueueLinkedList implements IQueue {

    private LinkedList queue;

    public QueueLinkedList() {
        queue = new LinkedList();
    }

    public void enQueue(Object o) {
        queue.insertLast(o);
    }

    public Object deQueue() {
        if (isEmpty()) {
            return -1;
        }

        return queue.deleteFirst().data;
    }

    public Object peakFront() {
        // LinkedList DS doesn't have a peak, so will have to create our own
        Node temp = queue.deleteFirst();
        queue.insertFirst(temp);

        return temp.data;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
