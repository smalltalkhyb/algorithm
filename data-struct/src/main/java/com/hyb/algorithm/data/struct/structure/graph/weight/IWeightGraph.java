package com.hyb.algorithm.data.struct.structure.graph.weight;

import java.util.List;

public interface IWeightGraph<Weight extends Number & Comparable> {
    int getNodeCount();

    int getEdgeCount();

    void addEdge(Edge<Weight> edge);

    boolean hasEdge(int start, int end);

    void show();

    List<Edge<Weight>> getEdgeList(int start);
}



