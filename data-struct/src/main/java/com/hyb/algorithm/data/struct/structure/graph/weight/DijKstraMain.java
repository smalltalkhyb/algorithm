package com.hyb.algorithm.data.struct.structure.graph.weight;

public class DijKstraMain {

    public static void main(String[] args) {

        String filename = "testShortPath.txt";
        SparseWeightGraph<Integer> sparseWeightGraph = new SparseWeightGraph<>(5, false);

        ReadWeightedGraph readWeightedGraph = new ReadWeightedGraph();

        readWeightedGraph.readInteger(sparseWeightGraph, filename);

        sparseWeightGraph.show();


        int start = 0;
        DijKstra<Integer> dijKstra = new DijKstra<>(sparseWeightGraph, start);

        for (int i = 1; i < sparseWeightGraph.getNodeCount(); i++) {

            if (dijKstra.hasPathTo(i)) {
                System.out.println(String.format(" %s 到 %s 的最短路径为：%s", start, i, dijKstra.getShortPath(i)));

                System.out.println("路径为：");
                dijKstra.showShortPath(i);

            }
        }
    }
}
