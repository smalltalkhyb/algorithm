package com.hyb.algorithm.basic.cl;

public class ReferenceCountMain {
    public static void main(String[] args) {

        MyObject myObject1=new MyObject();
        MyObject myObject2=new MyObject();


        myObject1.childrenObject=myObject2;
        myObject2.childrenObject=myObject1;
    }
}
