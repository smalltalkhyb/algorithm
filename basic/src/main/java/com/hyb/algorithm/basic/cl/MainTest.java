package com.hyb.algorithm.basic.cl;


/**
 *
 *
 基本的类类型
 void 关键字 都存在类类型
 */
public class MainTest {

    public static void main(String[] args) {

        Class c1=int.class;
        Class c2=Integer.class;

        Class c3=String.class;

        Class c4=double.class;
        Class c5=Double.class;

        Class c6=void.class;
        Class c7=Void.class;


        System.out.println(c1.getName());
        System.out.println(c2.getName());
        System.out.println(c2.getSimpleName());

        System.out.println(c4.getName());

        System.out.println(c6.getName());
    }
}
