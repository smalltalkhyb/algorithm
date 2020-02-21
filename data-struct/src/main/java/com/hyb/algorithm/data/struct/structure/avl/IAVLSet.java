package com.hyb.algorithm.data.struct.structure.avl;

public interface IAVLSet<K> {

    boolean isEmpty();
    boolean contains(K k);
    void add(K k);
    int getSize();
}
