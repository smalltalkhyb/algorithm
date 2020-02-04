package com.hyb.algorithm.data.struct.structure.stack;


import com.hyb.algorithm.data.struct.structure.ArrayStruct;

public class ArrayStack<E> implements IStack<E> {


    private ArrayStruct<E> array;

    public ArrayStack(int capactiy){
        array=new ArrayStruct<>(capactiy);
    }

    public ArrayStack(){
        array=new ArrayStruct<>();
    }


    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity(){
        return array.getCapactiy();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder  res=new StringBuilder();
        res.append("Stack: ");
        res.append("[");

        for(int i=0;i<array.getSize();i++){
            res.append(array.get(i));
            if(i!=array.getSize()-1){
                res.append(", ");
                continue;
            }
        }
        res.append(" ] top");

        return res.toString();
    }
}

