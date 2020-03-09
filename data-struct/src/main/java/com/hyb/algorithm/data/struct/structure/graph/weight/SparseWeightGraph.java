package com.hyb.algorithm.data.struct.structure.graph.weight;

import java.util.ArrayList;
import java.util.List;


//稀疏图-邻接表
public class SparseWeightGraph<Weight extends Number & Comparable> implements IWeightGraph<Weight> {

    private int nodeCount;//节点数
    private int edgeCount;//边数
    private boolean directed;//是否为有向图
    private ArrayList<Edge<Weight>>[] graphList;// 图的具体数据

    //构造函数
    public SparseWeightGraph(int nodeCount, boolean directed) {
        if (nodeCount < 0) {
            throw new IllegalArgumentException("参数错误！");
        }

        this.directed = directed;
        this.nodeCount = nodeCount;
        this.edgeCount = 0;

        //graphList 初始化为 nodeCount 个空list 没有任何边
        this.graphList = new ArrayList[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            this.graphList[i] = new ArrayList<Edge<Weight>>();
        }
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

    //向图中添加一个边，权值为weight
    @Override
    public void addEdge(Edge<Weight> edge) {
        if (edge.getStart() < 0 || edge.getStart() > nodeCount || edge.getEnd() < 0 || edge.getEnd() > nodeCount) {
            throw new IllegalArgumentException("params is out of bounds");
        }

        //注意，由于在邻接表的情况，查找是否有重边需要遍历整个链表
        //我们的程序允许重边的出现

        graphList[edge.getStart()].add(new Edge<>(edge));

        //无向图
        if (edge.getStart() != edge.getEnd() && !directed) {
            graphList[edge.getEnd()].add(new Edge<>(edge.getEnd(), edge.getStart(), edge.getWeight()));
        }
        edgeCount++;
    }


    // 验证图中是否有从v到w的边
    @Override
    public boolean hasEdge(int start, int end) {

        if (start < 0 || start > nodeCount || end < 0 || end > nodeCount) {
            throw new IllegalArgumentException("params is out of bound ");
        }
        for (int i = 0; i < nodeCount; i++) {
            if (this.graphList[start].get(i).other(start) == end) {
                return true;
            }
        }

        return false;
    }


    //显示图的信息
    @Override
    public void show() {
        for (int i = 0; i < nodeCount; i++) {
            System.out.println(" vertex " + i + ":\t");
            for (int j = 0; j < graphList[i].size(); j++) {
                Edge<Weight> edge = graphList[i].get(j);
                System.out.println("{ to :" + edge.getEnd() + ",wt:" + edge.getWeight() + " ) \t");
            }
            System.out.println();
        }
    }


    //返回图中的一个顶点的所有邻边
    @Override
    public List<Edge<Weight>> getEdgeList(int start) {
        if (start < 0 || start > nodeCount ) {
            throw new IllegalArgumentException("params is out of bound ");
        }
        return graphList[start];
    }

}
