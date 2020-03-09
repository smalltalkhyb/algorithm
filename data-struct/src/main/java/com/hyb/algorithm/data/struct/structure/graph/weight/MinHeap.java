package com.hyb.algorithm.data.struct.structure.graph.weight;


public class MinHeap<E extends Comparable<E>> {

    private E[] data;
    private int size;
    private int capactiy;

    public MinHeap(int capacity) {
        this.capactiy = capacity;
        data = (E[]) new Comparable[capacity];
        this.size = 0;
    }


    private int leftChild(int parent) {
        return 2 * parent + 1;
    }

    private int rightChild(int parent) {
        return 2 * parent + 2;
    }

    private int parent(int child) {
        return (child - 1) / 2;
    }

    public void add(E e) {
        data[size] = e;
        siftUp(size);
        size++;
    }


    private void siftUp(int index) {
        if (index < 1) {
            return;
        }
        int parentIndex = parent(index);
        int childIndex = index;

        while (parentIndex >= 0 && data[parentIndex].compareTo(data[childIndex]) > 0) {
            swap(parentIndex, childIndex);
            parentIndex = parent(parentIndex);
            childIndex = leftChild(parentIndex);
        }
    }

    private void siftDown(int index) {

        while (2 * index <= size) {
            int leftChildIndex = leftChild(index);
            int rightChildIndex = leftChildIndex + 1;

            if (leftChildIndex > size - 1) {
                break;
            }

            int childIndex = leftChildIndex;

            if (data[rightChildIndex] != null && data[leftChildIndex].compareTo(data[rightChildIndex]) > 0) {
                childIndex = rightChildIndex;
            }

            if (data[childIndex].compareTo(data[index]) < 0) {
                swap(index, childIndex);
            }

            index = childIndex;


        }
    }

    private void swap(int src, int dest) {
        E temp = data[src];
        data[src] = data[dest];
        data[dest] = temp;
    }


    public E extractMin() {
        E entity = data[0];
        swap(0, size - 1);
        data[size - 1] = null;
        size--;

        siftDown(0);
        return entity;
    }

    private E peek() {
        return data[0];
    }


    public boolean isEmpty() {
        return size == 0;
    }
}
