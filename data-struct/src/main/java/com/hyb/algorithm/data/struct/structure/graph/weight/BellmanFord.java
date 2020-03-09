package com.hyb.algorithm.data.struct.structure.graph.weight;

import java.util.List;
import java.util.Stack;

public class BellmanFord<Weight extends Number & Comparable> {

    private IWeightGraph<Weight> graph;
    private Edge<Weight>[] from;
    private Number[] destTo;
    private boolean hasNegativeCycle;
    private int start;

    public BellmanFord(IWeightGraph<Weight> graph, int start) {
        this.graph = graph;
        this.start = start;
        this.from = new Edge[this.graph.getNodeCount()];
        this.hasNegativeCycle = false;
        this.destTo = new Number[this.graph.getNodeCount()];

        builder();
    }

    private void builder() {

        //设置distTo[s]=0; 并且让from[s]不为NULL ,表示初始s节点可达且距离为0
        destTo[start] = 0.0;
        from[start] = new Edge<Weight>(start, start, (Weight) (Number) (0.0));


        //Bellman-Ford的过程
        //进行V-1次循环，每一次循环求出从起点到其余所有点，最多使用pass步可到达的最短距离
        for (int pass = 1; pass < graph.getNodeCount(); pass++) {
            //每次循环中对所有的边进行一遍松弛操作
            //遍历所有边的方式是先遍历所有的顶点，然后遍历和所有顶点相邻的所有边
            for (int i = 0; i < graph.getNodeCount(); i++) {
                //使用邻边迭代器遍历和所有顶点相邻的所有边
                for (Object item : graph.getEdgeList(i)) {
                    Edge<Weight> edge = (Edge<Weight>) item;
                    //对于每一个边首先判断e->start可达
                    //之后看如果 e->end 以前有没有达到过，显然我们可以更新distTo[end]
                    //或者 end 以前到达过，但是通过这个e 我们可以获得更短的距离，即可以进行一次松弛操作。
                    //更新distTo[end]

                    if (from[edge.getStart()] == null) {
                        continue;
                    }
                    Number sum = destTo[edge.getStart()].doubleValue() + edge.getWeight().doubleValue();
                    if (from[edge.getEnd()] == null || sum.doubleValue() < destTo[edge.getEnd()].doubleValue()) {
                        destTo[edge.getEnd()] = sum;
                        from[edge.getEnd()] = edge;
                    }
                }
            }
        }

        hasNegativeCycle = detectNegativeCycle();
    }


    //判断图中是否有负向环
    private boolean detectNegativeCycle() {

        for (int i = 0; i < graph.getNodeCount(); i++) {
            List<Edge<Weight>> edgeList = graph.getEdgeList(i);
            for (Edge<Weight> edge : edgeList) {
                Number sum = destTo[edge.getStart()].doubleValue() + edge.getWeight().doubleValue();
                if (from[edge.getEnd()] == null || sum.doubleValue() < destTo[edge.getEnd()].doubleValue()) {
                    return true;
                }
            }
        }

        return false;
    }


    public boolean isHasNegativeCycle() {
        return hasNegativeCycle;
    }


    public Number getShortestWeight(int end) {
        return destTo[end];
    }


    public void showShortestPath(int end) {

        Stack<Edge<Weight>> stack = new Stack<>();
        while (from[end] != null && from[end].getStart() != start) {
            stack.push(from[end]);
            end = from[end].getStart();
        }

       stack.push(from[end]);

        int index = 0;
        int size = stack.size();

        while (!stack.isEmpty()) {
            Edge<Weight> edge = stack.pop();
            System.out.print(edge.getStart() + "->");

            if (index == size - 1) {
                System.out.print(edge.getEnd());
            }
            index++;
        }

        System.out.println();
    }


}
