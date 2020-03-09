package com.hyb.algorithm.data.struct.structure.graph.weight;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DijKstra<Weight extends Number & Comparable> {

    private IWeightGraph<Weight> graph;
    private Edge<Weight>[] from;
    private boolean[] marked;
    private Number[] destTo;
    private int start;


    public DijKstra(IWeightGraph<Weight> graph, int start) {

        this.graph = graph;
        this.start = start;

        this.from = new Edge[this.graph.getEdgeCount()];
        this.marked = new boolean[this.graph.getNodeCount()];
        this.destTo = new Number[this.graph.getNodeCount()];

        for (int i = 0; i < this.graph.getNodeCount(); i++) {
            this.destTo[i] = 0;
        }

        builder();
    }

    private void builder() {

        IndexMinHeap<Weight> indexMinHeap = new IndexMinHeap<>(this.graph.getEdgeCount());
        from[start] = new Edge<Weight>(start, start, (Weight) (Number) (0.0));
        indexMinHeap.add(start, from[start].getWeight());
        marked[start] = true;

        while (!indexMinHeap.isEmpty()) {
            int node = indexMinHeap.extractMinIndex();

            List<Edge<Weight>> edgeList = this.graph.getEdgeList(node);

            marked[node] = true;

            for (Edge<Weight> edge : edgeList) {

                int end = edge.getEnd();

                // 如果从start点到end点的最短路径还没有找到
                if (marked[end]) {
                    continue;
                }

                // 如果end点以前没有访问过,
                // 或者访问过, 但是通过当前的start点到end点距离更短, 则进行更新

                Number sumOldWeight = destTo[node].doubleValue() + edge.getWeight().doubleValue();
                Number currentWeight = destTo[end].doubleValue();
                if (from[end] == null || sumOldWeight.doubleValue() < currentWeight.doubleValue()) {
                    from[end] = edge;
                    destTo[end] = sumOldWeight;

                    if (indexMinHeap.contain(end)) {
                        indexMinHeap.change(end, (Weight) sumOldWeight);
                        continue;
                    }

                    indexMinHeap.add(end, (Weight) sumOldWeight);
                }
            }
        }
    }


    //
    public Number getShortPath(int end) {
        if (!hasPathTo(end)) {
            return 0;
        }
        return destTo[end];
    }


    //判断是否有路径通过
    public boolean hasPathTo(int end) {
        return marked[end];
    }

    //打印 从 start 到 end 的路径

    public void showShortPath(int end) {

        Stack<Edge<Weight>> stack = new Stack<>();

        Edge<Weight> e = from[end];
        while (e.getStart() != this.start) {
            stack.push(e);
            e = from[e.getStart()];
        }
        stack.push(e);


        int i = 0;
        int size = stack.size();
        while (!stack.isEmpty()) {
            Edge<Weight> edge = stack.pop();
            System.out.print(edge.getStart() + "->");

            if (i == size - 1) {
                System.out.print(edge.getEnd());
            }

            i++;

        }

        System.out.println();
    }


}
