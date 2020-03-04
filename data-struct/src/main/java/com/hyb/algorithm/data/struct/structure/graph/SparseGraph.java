package com.hyb.algorithm.data.struct.structure.graph;

import java.util.Vector;

// 稀疏图 - 邻接表
public class SparseGraph implements IGraph {

    private int nodeCount;  // 节点数
    private int edgeCount;  // 边数
    private boolean direct; // 是否为有向图
    private Vector<Integer>[] graphList; // 图的具体数据


    public SparseGraph(int nodeCount, boolean direct) {
        this.nodeCount = nodeCount;
        this.direct = direct;
        this.edgeCount = 0;

        // g初始化为n个空的vector, 表示每一个g[i]都为空, 即没有任和边
        this.graphList = new Vector[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            this.graphList[i] = new Vector<>();
        }
    }


    //返回节点个数

    @Override
    public int getNodeCount() {
        return this.nodeCount;
    }

    //返回边数

    @Override
    public int getEdgeCount() {
        return this.edgeCount;
    }

    //向图中添加一个边

    @Override
    public void addEdge(int v, int w) {
        if (v < 0 || v > nodeCount || w < 0 || w > nodeCount) {
            throw new IllegalArgumentException("index is out of bound");
        }
        this.graphList[v].add(w);
        edgeCount++;

        if (direct || v == w) {
            return;
        }
        this.graphList[w].add(v);

    }

    //验证图中是否有从v到w的边
    @Override
    public boolean hasEdge(int v, int w) {
        if (v < 0 || v > nodeCount || w < 0 || w > nodeCount) {
            throw new IllegalArgumentException("index is out of bound");
        }

        Vector<Integer> vector = this.graphList[v];
        for (int i = 0; i < vector.size(); i++) {
            if (vector.elementAt(v) == w) {
                return true;
            }
        }

        return false;
    }


    //返回图中一个顶点所有邻边
    //由于java 使用引用机制，返回一个Vector不会带来额外开销

    @Override
    public Iterable<Integer> adj(int v) {
        return graphList[v];
    }

    @Override
    public void show() {
        for (int i = 0; i < nodeCount; i++) {
            Vector<Integer> vector = graphList[i];
            for (int j = 0; j < vector.size(); j++) {
                System.out.print(vector.elementAt(j) + ",");
            }
            System.out.println();
        }
    }


}
