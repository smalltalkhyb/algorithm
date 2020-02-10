package com.hyb.algorithm.basic.genericity;

public class GenericInterImpl implements GenericInterface<Integer> {
    @Override
    public Integer getEntity() {
        return 100;
    }
}
