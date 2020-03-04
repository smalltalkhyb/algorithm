package com.hyb.algorithm.data.struct.structure.graph;

public class GraphShortestPathMain {


    public static void main(String[] args) {
        String filename = "grappathdata.txt";

        IGraph graph = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(graph, filename);


        GraphShortestPath graphShortestPath = new GraphShortestPath(graph, 0);
        graphShortestPath.showPath(6);

        System.out.println();
        System.out.println(graphShortestPath.pathLength(6));

    }


}
