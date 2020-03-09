package com.hyb.algorithm.data.struct.structure.graph.weight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DenseWeightGraph<Weight extends Number & Comparable> implements IWeightGraph<Weight> {

    private int nodeCount;  //节点个数
    private int edgeCount;  //边的个数
    private Edge<Weight>[][] graphMatrix;  //图的数据列表'
    private boolean directed;


    public DenseWeightGraph(int nodeCount, boolean directed) {

        this.nodeCount = nodeCount;
        this.directed = directed;

        this.graphMatrix = new Edge[nodeCount][nodeCount];

        for (int i = 0; i < nodeCount; i++) {
            for (int j = 0; j < nodeCount; j++) {
                graphMatrix[i][j] = null;
            }
        }
    }

    @Override
    public int getNodeCount() {
        return nodeCount;
    }

    @Override
    public int getEdgeCount() {
        return edgeCount;
    }

    @Override
    public void addEdge(Edge<Weight> edge) {
        if (edge == null || edge.getStart() < 0 || edge.getStart() > nodeCount
                || edge.getEnd() < 0 || edge.getEnd() > nodeCount) {
            throw new IllegalArgumentException("params is Illegal!");
        }

        graphMatrix[edge.getStart()][edge.getEnd()] = new Edge<>(edge);
        if (!directed) {
            graphMatrix[edge.getEnd()][edge.getStart()] = new Edge<>(edge.getEnd(), edge.getStart(), edge.getWeight());
        }
        edgeCount++;

    }

    @Override
    public boolean hasEdge(int start, int end) {

        if (start < 0 || start > nodeCount
                || end < 0 || end > nodeCount) {
            throw new IllegalArgumentException("params is Illegal!");
        }

        return graphMatrix[start][end] != null;
    }

    @Override
    public void show() {
        for (int i = 0; i < nodeCount; i++) {
            for (int j = 0; j < nodeCount; j++)
                if (graphMatrix[i][j] != null)
                    System.out.print(graphMatrix[i][j].getWeight() + "\t");
                else
                    System.out.print("NULL\t");
            System.out.println();
        }
    }

    @Override
    public List<Edge<Weight>> getEdgeList(int start) {

        if (start < 0 || start > nodeCount) {
            throw new IllegalArgumentException("params is Illegal!");
        }

        Edge<Weight>[] edgeArray = graphMatrix[start];

        List<Edge<Weight>> list = new ArrayList<>();

        for (int i = 0; i < edgeArray.length; i++) {
            Edge<Weight> edge = edgeArray[i];
            if (edge == null) {
                continue;
            }

            list.add(edge);
        }
        return list;
    }
}
