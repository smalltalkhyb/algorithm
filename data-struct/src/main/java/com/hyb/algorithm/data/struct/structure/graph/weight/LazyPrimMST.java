package com.hyb.algorithm.data.struct.structure.graph.weight;


import java.util.ArrayList;
import java.util.List;

//使用Prim算法求图的最小生成树
public class LazyPrimMST<Weight extends Number & Comparable> {

    private IWeightGraph<Weight> weightGraph; //图的引用
    private MinHeap<Edge<Weight>> minHeap;//最小堆，算法辅助数据结构
    private boolean[] marked;   //标记数组，标记节点是否被访问
    private List<Edge<Weight>> minEdgeList; //最小生成树所包含的所有的边
    private Number minWeight;  //最小生成树的权值


    //构造函数，使用Prim算法求图的最小生成树
    public LazyPrimMST(IWeightGraph<Weight> weightGraph) {
        this.weightGraph = weightGraph;
        minHeap = new MinHeap<>(weightGraph.getEdgeCount());
        marked = new boolean[weightGraph.getNodeCount()];
        minEdgeList = new ArrayList<>();
        builder();
    }


    private void builder() {
        //lazy prim 算法
        visit(0);
        while (!minHeap.isEmpty()) {
            //使用最小堆 找出已经访问的边中权值最小的边
            Edge<Weight> e = minHeap.extractMin();
            //如果这条边的两端都已经访问过了，则扔掉这条边
            if (marked[e.getStart()] == marked[e.getEnd()])
                continue;

            //否则这条边则应该存在最小生成树中
            minEdgeList.add(e);

            //访问和这条边连接的还没有被访问过的节点
            if (!marked[e.getStart()]) {
                visit(e.getStart());
            } else {
                visit(e.getEnd());
            }
        }

        //计算最小生成树的权值
        minWeight = 0;
        for (Edge<Weight> edge : minEdgeList) {
            minWeight = minWeight.doubleValue() + edge.getWeight().doubleValue();
        }
    }

    //访问节点
    private void visit(int start) {
        marked[start] = true;

        List<Edge<Weight>> list = weightGraph.getEdgeList(start);
        //将和节点V 向连接的所有未访问的边放入最小堆中
        for (Edge<Weight> edge : list) {
            if (!marked[edge.other(start)]) {
                minHeap.add(edge);
            }
        }
    }

    //返回最小生成树的所有边
    public List<Edge<Weight>> getMinEdgeList() {
        return minEdgeList;
    }

    //返回最小生成树的权值
    public Number getMinWeight() {
        return minWeight;
    }

}


