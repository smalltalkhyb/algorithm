package com.hyb.algorithm.data.struct.structure.queue;

import com.hyb.algorithm.data.struct.structure.ArrayStruct;

public class ArrayQueue<E> implements IQueue<E> {

    private ArrayStruct<E> arrayStruct;

    public ArrayQueue(int capacity) {
        arrayStruct = new ArrayStruct<>(capacity);
    }


    public ArrayQueue() {
        arrayStruct = new ArrayStruct<>();
    }

    @Override
    public int getSize() {
        return arrayStruct.getSize();
    }

    @Override
    public boolean isEmpty() {
        return arrayStruct.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        arrayStruct.addLast(e);
    }

    @Override
    public E dequeue() {
        return arrayStruct.removeFirst();
    }

    @Override
    public E getFront() {
        return arrayStruct.getFirst();
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < arrayStruct.getSize(); i++) {
            res.append(arrayStruct.get(i));
            if (i != arrayStruct.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }


    public static void main(String[] args) {

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();

        for (int i = 0; i < 10; i++) {

            arrayQueue.enqueue(i);

            System.out.println(arrayQueue);
            if (i % 3 == 0) {
                arrayQueue.dequeue();
                System.out.println(arrayQueue);
            }


        }

        System.out.println(arrayQueue);


    }
}
