package com.hyb.algorithm.data.struct.structure.uf;


public  class UnionFindV6 implements IUnionFind{

    private int[] parent;
    private int[] rank;  //父节点的深度


    public UnionFindV6(int size){
        parent=new int[size];
        rank=new int[size];

        for(int i=0;i<size;i++){
            parent[i]=i;
            rank[i]=1;
        }
    }


    @Override
    public int getSize() {
        return parent.length;
    }


    private int find(int p){
        if(p<0||p>parent.length){
            throw new IllegalArgumentException(" p is  out of bound!");
        }
        // path compression 2, 递归算法
        if(p!=parent[p]){
            parent[p]=find(parent[p]);
        }

        return  parent[p];
    }
    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }

    @Override
    public void unionElements(int p, int q) {

        if(p<0||p>parent.length){
            throw new IllegalArgumentException(" p is  out of bound!");
        }

        if(q<0||q>parent.length){
            throw new IllegalArgumentException(" q is  out of bound!");
        }

        int pParent=find(p);
        int qParent=find(q);


        //判断谁的高度高，如果pParent的高度小于 qParent 则将p的父节点接入到 q的父节点上

        // 根据两个元素所在树的元素个数不同判断合并方向
        // 将元素个数少的集合合并到元素个数多的集合上
        if(rank[pParent]<rank[qParent]){
            parent[pParent]=qParent;
            return;
        }

        if(rank[pParent]>rank[qParent]){
            parent[qParent]=pParent;
            return;
        }

        parent[qParent]=pParent;
        rank[qParent]+=1;

    }
}