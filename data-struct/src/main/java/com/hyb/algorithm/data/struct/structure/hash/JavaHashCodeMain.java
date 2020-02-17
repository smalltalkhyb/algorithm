package com.hyb.algorithm.data.struct.structure.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

public class JavaHashCodeMain {

    public static void main(String[] args) {
        int t1=100;
        System.out.println(((Integer)t1).hashCode());   //输出100

        int t2=-100;
        System.out.println(  ((Integer)t2).hashCode());//输出-100

        double t3=3.1415296;
        System.out.println( ((Double)t3).hashCode() );// 输出89289278

        String t4="bing";
        System.out.println(t4.hashCode()); //3023936


        Student student=new Student(3,5,"bing");
        Student student2=new Student(3,5,"bing");

        HashSet<Student> hashSet=new HashSet<>();

        hashSet.add(student);
        hashSet.add(student2);
        System.out.println(hashSet.size()); //不重写 equals  会是2  自定义重写是 1

        HashMap<Student,Integer> hashMap=new HashMap<>();
        

        hashMap.put(student,100);
        hashMap.put(student2,200);

        System.out.println(hashMap.size()); //不重写 equals  会是2  自定义重写是 1


    }
}
