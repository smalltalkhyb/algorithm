package com.hyb.algorithm.data.struct.structure.graph.weight;

import java.util.ArrayList;
import java.util.List;

public class PrimIndexHeapMST<Weight extends Number & Comparable> {

    private IndexMinHeap<Weight> indexMinHeap;
    private IWeightGraph<Weight> graph;
    private boolean[] marked;
    private List<Edge<Weight>> minEdgeList;
    private Edge<Weight>[] weightList;
    private Number minEdgeWeight;


    public PrimIndexHeapMST(IWeightGraph<Weight> graph) {
        this.graph = graph;
        this.marked = new boolean[this.graph.getNodeCount()];
        this.weightList = new Edge[this.graph.getNodeCount()];
        this.indexMinHeap = new IndexMinHeap<>(this.graph.getNodeCount());
        this.minEdgeList = new ArrayList<>();
        this.minEdgeWeight = 0;


        builder();
    }


    private void builder() {
        visited(0);

        while (!indexMinHeap.isEmpty()) {
            int nodeIndex = indexMinHeap.extractMinIndex();
            minEdgeList.add(weightList[nodeIndex]);
            visited(nodeIndex);
        }


        for (Edge<Weight> edge : minEdgeList) {
            minEdgeWeight = minEdgeWeight.doubleValue() + edge.getWeight().doubleValue();
        }
    }


    // 将和节点start相连接的未访问的另一端点, 和与之相连接的边, 放入最小堆中
    private void visited(int start) {
        marked[start] = true;

        List<Edge<Weight>> edgeList = graph.getEdgeList(start);

        for (Edge<Weight> edge : edgeList) {

            int other = edge.other(start);
            if (marked[other]) {
                continue;
            }


            if (weightList[other] == null) {
                indexMinHeap.add(other, edge.getWeight());
                weightList[other] = edge;
                continue;
            }

            //如果大于 则跳过
            if (edge.getWeight().compareTo(weightList[other].getWeight()) > 0) {
                continue;
            }
            weightList[other] = edge;
            indexMinHeap.change(other, edge.getWeight());

        }
    }


    public List<Edge<Weight>> getMinEdgeList() {
        return minEdgeList;
    }

    public Number getMinEdgeWeight() {
        return minEdgeWeight;
    }
}
