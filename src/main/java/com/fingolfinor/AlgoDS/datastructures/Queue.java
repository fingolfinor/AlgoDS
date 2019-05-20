package com.fingolfinor.AlgoDS.datastructures;

public class Queue {

    private int maxSize;
    private long[] queueArray;
    private int front;              //(used like a pointer) index position for element in front of line
    private int rear;               //(used like a pointer) index position for element at back of line
    private int nItems;             //counter to maintain number of items in queue
                                    //Note: could also use queueArray.length()

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.queueArray = new long[maxSize];
        this.front = 0;
        this.rear = -1;             //no item in array to be considered last item yet
        this.nItems = 0;
    }

    // CIRCULAR QUEUE: Aha just overwrite beginning when get to end
    public void enQueue(long newItem) {
                                    // Strange: (IS GOOD, is a Circular Queue)
                                    // to loop like this No? (loose members in line :)
        if (rear == maxSize-1) {    // So  bring rear back to the beginning, then things will just overwrite (hmm??)
                                    // but overwriting the first item may not be what want..
            rear = -1;
        }

        rear++;                     //If would have been 0, then miss
        queueArray[rear] = newItem;
        nItems++;
    }

    public long deQueue() {
        long frontOfLine = queueArray[front];
        front++;
        if (front == maxSize) {     //we've removed everything from line, so reset it to use entire array again
            front = 0;
        }
        nItems--;
        return frontOfLine;
    }

    public long peakFront() {
        return queueArray[front];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (maxSize == nItems);     //no -1 case since var not used as array indexes
    }

    public void view() {
        for (long item: queueArray) {
            System.out.print(item + " ");
        }
    }
}
