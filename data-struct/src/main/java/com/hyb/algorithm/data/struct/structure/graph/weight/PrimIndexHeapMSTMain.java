package com.hyb.algorithm.data.struct.structure.graph.weight;

import java.util.List;

public class PrimIndexHeapMSTMain {

    public static void main(String[] args) {
        String filename = "testWeightG1.txt";
        DenseWeightGraph<Double> sparseWeightGraph = new DenseWeightGraph<>(8, false);
        ReadWeightedGraph readWeightedGraph = new ReadWeightedGraph(sparseWeightGraph, filename);
        PrimIndexHeapMST<Double> primIndexHeapMST = new PrimIndexHeapMST<>(sparseWeightGraph);


        List<Edge<Double>> edgeList = primIndexHeapMST.getMinEdgeList();

        for (Edge<Double> edge : edgeList) {
            System.out.println(edge);
        }

        System.out.println("min weight=" + primIndexHeapMST.getMinEdgeWeight());
    }

}
