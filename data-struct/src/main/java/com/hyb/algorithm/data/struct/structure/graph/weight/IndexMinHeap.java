package com.hyb.algorithm.data.struct.structure.graph.weight;

public class IndexMinHeap<E extends Comparable> {

    private E[] data;
    private int[] indexArray;
    private int[] reverseArray;
    private int size;
    private int capacity;

    public IndexMinHeap(int capacity) {
        this.capacity = capacity + 1;
        data = (E[]) new Comparable[capacity + 1];
        indexArray = new int[capacity + 1];
        reverseArray = new int[capacity + 1];
    }


    public void add(int index, E e) {

        index = index + 1;
        data[index] = e;
        indexArray[size + 1] = index;
        reverseArray[index] = size + 1;
        size++;
        siftUp(size);
    }


    private void siftUp(int index) {

        if (index <= 1 || index > size) {
            return;
        }

        while (index > 1) {
            int j = index / 2;
            if (data[indexArray[j]].compareTo(data[indexArray[index]]) > 0) {
                swapIndex(index, j);
            }
            index = j;
        }
    }

    private void swapIndex(int src, int dest) {
        int tmp = indexArray[src];
        indexArray[src] = indexArray[dest];
        indexArray[dest] = tmp;


        reverseArray[indexArray[src]] = src;
        reverseArray[indexArray[dest]] = dest;
    }


    public E extractMin() {

        if (size <= 0) {
            throw new IllegalArgumentException("队列为空！");
        }
        E ret = data[indexArray[1]];
        swapIndex(1, size);
        reverseArray[indexArray[size]] = 0;
        size--;
        siftDown(1);
        return ret;
    }

    // 从最小索引堆中取出堆顶元素的索引
    public int extractMinIndex() {

        int ret = indexArray[1] - 1;
        swapIndex(1, size);
        reverseArray[indexArray[size]] = 0;
        size--;
        siftDown(1);
        return ret;
    }


    private void siftDown(int index) {

        while (index * 2 <= size) {
            int j = index * 2;

            if (j + 1 > size) {
                break;
            }

            if (data[indexArray[j]].compareTo(data[indexArray[j + 1]]) > 0) {
                j++;
            }

            if (data[indexArray[j]].compareTo(data[indexArray[index]]) < 0) {
                swapIndex(index, j);
            }
            index = j;
        }
    }

    public void change(int index, E e) {

        if (index < 0 || index > capacity - 1) {
            throw new IllegalArgumentException("参数错误");
        }

        index = index + 1;
        data[index] = e;

        int siftIndex = reverseArray[index];
        siftUp(siftIndex);

        siftIndex = reverseArray[index];
        siftDown(siftIndex);

    }


    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contain(int index) {
        return reverseArray[index + 1] != 0;
    }
}
