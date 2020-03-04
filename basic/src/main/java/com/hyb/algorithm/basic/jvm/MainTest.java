package com.hyb.algorithm.basic.jvm;

public class MainTest {


    private int compute() {
        int a = 1;
        int b = 2;
        int c = a * b + 10;

        return c;
    }

    public static void main(String[] args) {

        MainTest mainTest = new MainTest();
        int ret = mainTest.compute();

        System.out.println(ret);
    }
}
