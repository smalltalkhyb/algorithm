package com.hyb.algorithm.data.struct.structure.graph.weight;

import java.util.List;

public class LazyPrimMSTMain {

    public static void main(String[] args) {
        String filename = "testWeightG1.txt";
        DenseWeightGraph<Double> denseWeightGraph = new DenseWeightGraph<>(8, false);
        ReadWeightedGraph readWeightedGraph = new ReadWeightedGraph(denseWeightGraph, filename);

        denseWeightGraph.show();


        LazyPrimMST<Double> lazyPrimMST = new LazyPrimMST<>(denseWeightGraph);


        System.out.println("Test Lazy Prim MST:");
        List<Edge<Double>> list = lazyPrimMST.getMinEdgeList();

        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

        System.out.println("The MST weight is: " + lazyPrimMST.getMinWeight());

        lazyPrimMST.getMinWeight();
    }

}
