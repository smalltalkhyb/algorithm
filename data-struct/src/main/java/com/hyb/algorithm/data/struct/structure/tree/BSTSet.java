package com.hyb.algorithm.data.struct.structure.tree;


public class BSTSet<E extends Comparable<E>> implements IBSTSet<E> {

    private  BST<E> bst=null;

    public BSTSet(){
        bst=new BST<>();
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public void remove(E e) {
         bst.remove(e);
    }
}
