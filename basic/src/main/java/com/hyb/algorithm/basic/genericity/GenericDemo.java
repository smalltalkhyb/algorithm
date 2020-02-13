package com.hyb.algorithm.basic.genericity;


import java.util.LinkedList;

//此处E可以随便写为任意的标识，比如T、E、K、V 等形式的参数，常用于表示泛型
//实例化泛型类时，必须制定E 的具体类型
public class GenericDemo<E> {

    private E  val;


    //泛型构造方法形参key的类型也为E，E的类型由外部指定
    public GenericDemo(E val){
        this.val=val;
    }


    //泛型方法getKey的返回值类型为E，E的类型由外部指定
    public E getVal(){
        return val;
    }


    public static void main(String[] args) {
        GenericDemo<Integer> integerGenericDemo=new GenericDemo<Integer>(123456789);
        GenericDemo<String> stringGenericDemo=new GenericDemo<String>("泛型测试");

        //也可以不指定具体类型 相当于GenericDemo<Object>
        GenericDemo generic1 = new GenericDemo("111111");
        GenericDemo generic2 = new GenericDemo(false);


        GenericDemo<Object> objectGenericDemo=new GenericDemo<>("tttt");


        System.out.println(objectGenericDemo.getVal());
        System.out.println(objectGenericDemo.getClass().equals(integerGenericDemo.getClass()));


//        if(integerGenericDemo instanceof GenericDemo<Integer> ){
//
//        }

    }
}

