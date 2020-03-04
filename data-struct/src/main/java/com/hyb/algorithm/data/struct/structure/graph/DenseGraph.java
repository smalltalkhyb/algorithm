package com.hyb.algorithm.data.struct.structure.graph;

import java.util.Vector;

// 稠密图 - 邻接矩阵
public class DenseGraph implements IGraph {

    private int nodeCount;  // 节点数
    private int edgeCount;  // 边数
    private boolean directed;   // 是否为有向图
    private boolean[][] matrix;      // 图的具体数据

    public DenseGraph(int nodeCount, boolean directed) {
        this.nodeCount = nodeCount;
        this.edgeCount = 0;
        this.directed = directed;
        // g初始化为n*n的布尔矩阵, 每一个matrix[i][j]均为false, 表示没有任和边
        // false为boolean型变量的默认值
        this.matrix = new boolean[nodeCount][nodeCount];
    }

    //返回节点个数
    @Override
    public int getNodeCount() {
        return nodeCount;
    }

    //返回边的个数
    @Override
    public int getEdgeCount() {
        return edgeCount;
    }

    @Override
    public void addEdge(int v, int w) {
        if (v < 0 || v > nodeCount || w < 0 || w > nodeCount) {
            throw new IllegalArgumentException("参数不合法！");
        }

        if (hasEdge(v, w)) {
            return;
        }
        matrix[v][w] = true;
        edgeCount++;

        if (directed) {
            return;
        }

        matrix[w][v] = true;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        if (v < 0 || v > nodeCount || w < 0 || w > nodeCount) {
            throw new IllegalArgumentException("参数不合法！");
        }

        return matrix[v][w];
    }

    @Override
    public void show() {
        for (int i = 0; i < nodeCount; i++) {
            for (int j = 0; j < nodeCount; j++) {
                System.out.print((matrix[i][j]?1:0 )+ ",");
            }
            System.out.println();
        }
    }


    //返回图中一个顶点的所有邻边
    //由于java使用引用机制，返回一个Vector不会带来额外开销
    @Override
    public Iterable<Integer> adj(int v) {
        Vector<Integer> adjV = new Vector<>();
        for (int i = 0; i < nodeCount; i++) {
            if (matrix[v][i]) {
                adjV.add(i);
            }
        }

        return adjV;
    }
}
