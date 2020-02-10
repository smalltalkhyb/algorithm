package com.hyb.algorithm.basic.genericity;

public class GenericExtend<E> {

    public void add(E e) {
        System.out.println("GenericExtend.add");
    }

    public void addAll(GenericExtend<E> genericExtend){
        System.out.println("GenericExtend.addAll");
    }

    public <T extends E> void addAllExtend(GenericExtend<T> genericExtend) {
        System.out.println("GenericExtend.addAllExtend");
    }

    public  void addAllExtendSimple(GenericExtend<? extends  E> genericExtend) {
        System.out.println("GenericExtend.addAllExtendSimple");
    }
}
