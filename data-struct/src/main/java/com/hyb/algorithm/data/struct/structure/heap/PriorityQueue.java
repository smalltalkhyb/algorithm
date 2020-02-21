package com.hyb.algorithm.data.struct.structure.heap;


public class PriorityQueue<E extends  Comparable<E>> implements IPriorityQueue<E> {


    MaxHeap<E> maxHeap;

    public  PriorityQueue(){
        maxHeap=new MaxHeap<>();
    }


    public PriorityQueue(E[] arr){
        maxHeap=new MaxHeap<>(arr);
    }

    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}
