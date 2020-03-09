package com.hyb.algorithm.data.struct.structure.graph.weight;


import java.util.List;

public class KruskalMSTMain {


    public static void main(String[] args) {
        String filename = "testWeightG1.txt";

        SparseWeightGraph<Double> sparseWeightGraph = new SparseWeightGraph<>(8, false);

        ReadWeightedGraph readWeightedGraph = new ReadWeightedGraph(sparseWeightGraph, filename);

//        sparseWeightGraph.show();


        KruskalMST<Double> kruskalMST = new KruskalMST<>(sparseWeightGraph);

        List<Edge<Double>> edgeList = kruskalMST.getMinEdgeList();

        for(Edge<Double> edge:edgeList){
            System.out.println(edge);
        }

        System.out.println(" minWeight:"+kruskalMST.getMinWeight());

    }
}
