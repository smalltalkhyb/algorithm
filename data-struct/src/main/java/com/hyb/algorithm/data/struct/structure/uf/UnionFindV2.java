package com.hyb.algorithm.data.struct.structure.uf;

public class UnionFindV2 implements IUnionFind {

    private int[] parent;

    public UnionFindV2(int size) {
        parent = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }


    //查找过程，查找元素p 所对应的集合编号
    //O(h)复杂度，h 为树的高度
    private int find(int index) {

        if(index < 0 || index >= parent.length)
            throw new IllegalArgumentException("index is out of bound.");

        //不断去查询自己的父亲节点，直到到达根节点
        //根节点的特点：parent[p]==p
        // 相对于 UnionFindV1的循环来说，因为它的遍历是不连续的 所有它比循环要慢一点 有时候测试是不准的
        while (index != parent[index]) {
            index = parent[index];
        }
        return index;
    }



    //查看元素p和元素q  是否所属一个集合
    //O(h) 复杂度，h为树的高度
    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }


    //合并元素p 和元素q 所属的集合
    //O(h) 复杂度，h 为树的高度
    @Override
    public void unionElements(int p, int q) {

        int pRoot=find(p);
        int qRoot=find(q);

        if(pRoot==qRoot){
            return;
        }

        parent[pRoot]=qRoot;
    }
}
