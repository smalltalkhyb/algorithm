package com.hyb.algorithm.data.struct.structure.tree;

public interface IBSTSet<E> {
    boolean contains(E e);
    boolean isEmpty();
    void add(E e);
    int getSize();
    void remove(E e);
}
