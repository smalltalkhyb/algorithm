package com.hyb.algorithm.data.struct.structure.avl;

public class AVLSet<K extends Comparable<K>> implements IAVLSet<K> {

    private AVLTree<K, Object> avlTree;

    @Override
    public boolean isEmpty() {
        return avlTree.isEmpty();
    }

    @Override
    public boolean contains(K k) {
        return avlTree.contains(k);
    }

    @Override
    public void add(K k) {
        avlTree.add(k, null);
    }

    @Override
    public int getSize() {
        return avlTree.getSize();
    }
}
