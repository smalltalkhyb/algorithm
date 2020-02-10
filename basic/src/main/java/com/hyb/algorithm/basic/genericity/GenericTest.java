package com.hyb.algorithm.basic.genericity;

import java.util.ArrayList;

public class GenericTest {

    public static void main(String[] args) {

        ArrayList arrayList=new ArrayList();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add("泛型测试");


        for(Object item:arrayList){
            String t=(String)item;
            System.out.println(t);
        }
    }
}
