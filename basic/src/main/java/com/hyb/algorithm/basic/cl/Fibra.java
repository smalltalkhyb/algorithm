package com.hyb.algorithm.basic.cl;

public class Fibra {

    public int fibraFun(int n) {
        if (n ==0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fibraFun(n-1) + fibraFun(n - 2);
    }


    public static void main(String[] args) {
        Fibra fibra=new Fibra();

        System.out.println(fibra.fibraFun(1000000));
    }

}
