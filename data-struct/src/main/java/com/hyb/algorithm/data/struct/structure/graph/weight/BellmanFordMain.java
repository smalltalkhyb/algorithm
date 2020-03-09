package com.hyb.algorithm.data.struct.structure.graph.weight;

public class BellmanFordMain {

    public static void main(String[] args) {

        String filename = "bellman-ford.txt";

        SparseWeightGraph<Integer> sparseWeightGraph = new SparseWeightGraph<>(5, true);

        ReadWeightedGraph readWeightedGraph = new ReadWeightedGraph();

        readWeightedGraph.readInteger(sparseWeightGraph, filename);

        sparseWeightGraph.show();


        int start = 0;
        BellmanFord<Integer> bellmanFord = new BellmanFord<>(sparseWeightGraph, start);

        for (int i = 1; i < sparseWeightGraph.getNodeCount(); i++) {
            Number pathDistance = bellmanFord.getShortestWeight(i);
            System.out.println(String.format("%s to %s   min distance=%s", start, i, pathDistance));

            bellmanFord.showShortestPath(i);
        }

    }
}
