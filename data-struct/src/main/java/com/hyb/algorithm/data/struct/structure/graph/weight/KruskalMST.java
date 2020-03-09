package com.hyb.algorithm.data.struct.structure.graph.weight;


import java.util.ArrayList;
import java.util.List;

public class KruskalMST<Weight extends Number & Comparable> {

    private IWeightGraph<Weight> graph;
    private Number minWeight;
    private List<Edge<Weight>> minEdgeList;


    public KruskalMST(IWeightGraph<Weight> graph) {
        this.graph = graph;
        this.minWeight = 0;
        this.minEdgeList = new ArrayList<>();
        builder();
    }


    private void builder() {
        MinHeap<Edge<Weight>> minHeap = new MinHeap<>(this.graph.getEdgeCount());

        for (int i = 0; i < this.graph.getNodeCount(); i++) {
            List<Edge<Weight>> edgeList = this.graph.getEdgeList(i);
            for (Edge<Weight> edge : edgeList) {

                //只插入一半即可
                if (edge.getStart() > edge.getEnd()) {
                    continue;
                }
                minHeap.add(edge);
            }
        }

        UnionFindGraph unionFindGraph = new UnionFindGraph(this.graph.getNodeCount());

        while (!minHeap.isEmpty() && minEdgeList.size() < this.graph.getNodeCount() - 1) {
            Edge<Weight> edge = minHeap.extractMin();

            if (unionFindGraph.isConnected(edge.getStart(), edge.getEnd())) {
                continue;
            }
            minEdgeList.add(edge);
            unionFindGraph.union(edge.getStart(), edge.getEnd());
        }

        for (Edge<Weight> edge : minEdgeList) {
            minWeight = minWeight.doubleValue() + edge.getWeight().doubleValue();
        }
    }


    public Number getMinWeight() {
        return minWeight;
    }

    public List<Edge<Weight>> getMinEdgeList() {
        return minEdgeList;
    }
}
