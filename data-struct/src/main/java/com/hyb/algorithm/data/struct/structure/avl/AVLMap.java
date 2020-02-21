package com.hyb.algorithm.data.struct.structure.avl;

public class AVLMap<K extends Comparable<K>, V> implements IAVLMap<K, V> {

    private AVLTree<K, V> avlTree;

    public AVLMap() {
        avlTree = new AVLTree<>();
    }

    @Override
    public void add(K k, V v) {
        avlTree.add(k, v);
    }

    @Override
    public boolean contains(K k) {
        return avlTree.contains(k);
    }

    @Override
    public void remove(K k) {
        avlTree.remove(k);
    }

    @Override
    public int getSize() {
        return avlTree.getSize();
    }

    @Override
    public void set(K k, V v) {
        avlTree.set(k, v);
    }

    @Override
    public V get(K k) {
        return avlTree.get(k);
    }

    @Override
    public boolean isEmpty() {
        return avlTree.isEmpty();
    }
}
