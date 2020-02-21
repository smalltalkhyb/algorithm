package com.hyb.algorithm.data.struct.structure.segement;


public class SegmentTree<E> {
    private E[] tree;
    private E[] data;
    private IMerger<E> merger;

    public SegmentTree(E[] arr, IMerger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }

        tree = (E[]) new Object[4 * arr.length];

        builderSegmentTree(0, 0, data.length - 1);
    }


    private void builderSegmentTree(int treeIndex, int left, int right) {
        if (left == right) {
            tree[treeIndex] = data[left];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = left + (right - left) / 2;

        builderSegmentTree(leftTreeIndex, left, mid);
        builderSegmentTree(rightTreeIndex, mid + 1, right);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }


    public int getSize() {
        return data.length;
    }


    public boolean isEmpty() {
        return data.length == 0;
    }

    public E getIndex(int index) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal.");
        return data[index];
    }


    //获取左子树索引
    public int leftChild(int index) {
        return 2 * index + 1;
    }

    // 获取右子树索引
    public int rightChild(int index) {
        return 2 * index + 2;
    }

    // 返回区间[queryL, queryR]的值
    public E query(int queryL,int queryR){
        if(queryL<0||queryL>data.length||queryR<0||queryR>data.length||queryL>queryR){
            throw  new IllegalArgumentException(" 参数错误！");
        }

       return   queryTree(0,0,data.length-1,queryL,queryR);
    }

    // 在以treeIndex为根的线段树中[l...r]的范围里，搜索区间[queryL...queryR]的值
    private E queryTree(int treeIndex,int left,int right,int queryL,int queryR){

        if(left==queryL&&right==queryR){
            return tree[treeIndex];
        }

        // treeIndex的节点分为[l...mid]和[mid+1...r]两部分
        int mid=left+(right-left)/2;
        int leftChildIndex=leftChild(treeIndex);
        int rightChildIndex=rightChild(treeIndex);


        if(queryL>=mid+1){
            return  queryTree(rightChildIndex,mid+1,right,queryL,queryR);
        }

        if(queryR<=mid){
            return  queryTree(leftChildIndex,left,mid,queryL,queryR);
        }

        E leftResult=queryTree(leftChildIndex,left,mid,queryL,mid);
        E rightResult=queryTree(rightChildIndex,mid+1,right,mid+1,queryR);

        return  merger.merge(leftResult,rightResult);
    }


    // 更新 index上的值为e
    public void  update(int index ,E e){
        if(index<0||index>data.length){
            throw new IllegalArgumentException(" index illegal !");
        }
        data[index]=e;
        update(0,0,data.length-1,index,e);
    }

    public void update(int treeIndex,int left,int right,int index,E e){
        if(left==right){
            tree[treeIndex]=e;
            return;
        }

        int mid=left+(right-left)/2;
        int leftTreeIndex=leftChild(treeIndex);
        int rightTreeIndex=rightChild(treeIndex);

        if(index>=mid+1){
            update(rightTreeIndex,mid+1,right,index,e);
        }

        if(index<=mid){
            update(leftTreeIndex,left,mid,index,e);
        }

        tree[treeIndex]=merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);

    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] == null) {
                continue;
            }
            if (i <tree.length - 1)
                stringBuilder.append(tree[i] + ",");
        }
        return stringBuilder.toString();
    }

}
