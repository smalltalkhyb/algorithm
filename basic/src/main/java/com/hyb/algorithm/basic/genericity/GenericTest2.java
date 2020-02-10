package com.hyb.algorithm.basic.genericity;

import java.util.ArrayList;

public class GenericTest2 {

    public static void main(String[] args) {

        ArrayList<String> arrayList=new ArrayList();

//        arrayList.add(1);  //编译器直接报错
//        arrayList.add(2); //编译器直接报错
        arrayList.add("泛型测试");


        for(Object item:arrayList){
            String t=(String)item;
            System.out.println(t);
        }
    }
}
