package com.hyb.algorithm.data.struct.structure.heap;

import com.hyb.algorithm.data.struct.structure.ArrayStruct;

public class MaxHeap<E extends Comparable<E>> {
    private ArrayStruct<E> data;

    public MaxHeap(int capacity) {
        data = new ArrayStruct<>(capacity);
    }

    public MaxHeap() {
        data = new ArrayStruct<>();
    }

    public MaxHeap(E[] arr) {
        data = new ArrayStruct<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }


    public boolean isEmpty() {
        return data.isEmpty();
    }


    public int getSize(){
        return data.getSize();
    }

    //返回父节点
    public int parent(int index) {
        if (index <= 0) {
            throw new IllegalArgumentException("index=0 has no parent");
        }
        return (index - 1) / 2;
    }

    //返回二叉树数组节点的左子树
    public int leftChild(int index) {
        return 2 * index + 1;
    }

    //返回二叉树数组节点的右子树
    public int rightChild(int index) {
        return 2 * index + 2;
    }

    public boolean contains(E e) {
        return data.contains(e);
    }


    //向堆中添加元素
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }


    //上浮
    public void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }


    public E findMax() {
        if (data.getSize() <= 0) {
            throw new IllegalArgumentException(" heap is empty!");
        }
        return data.get(0);
    }

    //取出堆中最大元素
    public E extractMax() {
        E e = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return e;
    }

    public void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int index = leftChild(k);
            //如果右子树大于左子树 用右子树的索引
            if ((index + 1 < data.getSize()) && data.get(index).compareTo(data.get(index + 1)) < 0) {
                index++;
            }

            //data.get(index) 是 左右子树最大值
            if (data.get(k).compareTo(data.get(index)) > 0) {
                break;
            }
            data.swap(k, index);
            k = index;
        }
    }


    //将堆顶元素替换为e
    public E replace(E e) {
        E max = findMax();
        data.set(0, e);
        siftDown(0);
        return max;
    }
}
