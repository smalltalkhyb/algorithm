package com.hyb.algorithm.data.struct.structure.graph;


//图的接口
public interface  IGraph{
    public int getNodeCount();
    public int getEdgeCount();
    public void addEdge(int v,int w);
    boolean hasEdge(int v,int w);
    void show();
    public Iterable<Integer> adj(int v);
}