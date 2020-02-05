package com.hyb.algorithm.data.struct.structure.queue;

public interface IQueue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}

