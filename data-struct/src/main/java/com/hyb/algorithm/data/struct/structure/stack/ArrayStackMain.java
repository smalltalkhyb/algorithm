package com.hyb.algorithm.data.struct.structure.stack;

public class ArrayStackMain {
    public static void main(String[] args) {


        ArrayStack<Integer> arrayStack=new ArrayStack<>();


        for(int i=0;i<10;i++){
            arrayStack.push(i);
        }

        arrayStack.pop();

        System.out.println(arrayStack);
    }
}
