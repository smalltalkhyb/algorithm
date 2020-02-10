package com.hyb.algorithm.basic.genericity;


public class GenericMethodMain {
    public static void main(String[] args) {
        GenericMethod<Integer> genericMethod = new GenericMethod(123456);
        Integer t = genericMethod.<Integer>showValName(genericMethod);
        System.out.println(t);
    }
}
