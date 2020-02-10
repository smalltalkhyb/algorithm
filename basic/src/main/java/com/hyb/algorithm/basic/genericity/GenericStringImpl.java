package com.hyb.algorithm.basic.genericity;

public class GenericStringImpl implements  GenericInterface<String> {

    @Override
    public String getEntity() {
        return "我是泛型";
    }
}
