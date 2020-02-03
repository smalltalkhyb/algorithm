package com.hyb.algorithm.data.struct.structure;

public class MaintTest {

    public static void main(String[] args) {
        ArrayStruct arrayStruct=new ArrayStruct(10);


        for(int i=0;i<20;i++){
            arrayStruct.addFirst(i);
        }

        System.out.println(arrayStruct);

        arrayStruct.addFirst(-1);

        System.out.println(arrayStruct);

        arrayStruct.remove(10);

        System.out.println(arrayStruct);


        arrayStruct.removeElement(4);

        System.out.println(arrayStruct);

        arrayStruct.removeFirst();
        System.out.println(arrayStruct);
    }
}
