package com.hyb.algorithm.basic.cl;

public class StringInternMain {

    public static void main(String[] args) {

        String s=new String("a");
        s.intern();
        String a2="a";

        System.out.println(s==a2);


        String s3=new String("a")+new String("a");
        s3.intern();

        String s4="aa";

        System.out.println(s3==s4);

    }
}
