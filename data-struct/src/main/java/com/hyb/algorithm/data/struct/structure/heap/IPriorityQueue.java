package com.hyb.algorithm.data.struct.structure.heap;

public interface IPriorityQueue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
