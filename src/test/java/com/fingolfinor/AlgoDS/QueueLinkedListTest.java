package com.fingolfinor.AlgoDS;

import com.fingolfinor.AlgoDS.datastructures.queue.QueueLinkedList;

public class QueueLinkedListTest extends QueueTestBase<QueueLinkedList> {

    @Override
    protected QueueLinkedList createInstance() {
        return new QueueLinkedList();
    }
}
