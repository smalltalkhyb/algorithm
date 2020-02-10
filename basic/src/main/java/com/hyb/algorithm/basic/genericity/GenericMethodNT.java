package com.hyb.algorithm.basic.genericity;

import java.util.ArrayList;
import java.util.List;

public class GenericMethodNT {

    public  <T> void copy(List<T> source, List<T> dest,T t) {
        System.out.println("普通类的泛型方法！");
    }

    public static void main(String[] args) {

        GenericMethodNT genericMethodNT=new GenericMethodNT();
        genericMethodNT.<String>copy(new ArrayList<>(),new ArrayList<>(),"泛型方法测试");
    }
}
