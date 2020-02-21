package com.hyb.algorithm.data.struct.structure.avl;

public interface IAVLMap<K,V> {
    void add(K k,V v);
    boolean contains(K k);
    void remove(K k);
    int getSize();
    void set(K k,V v);
    V get(K k);
    boolean isEmpty();
}
