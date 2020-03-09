package com.hyb.algorithm.data.struct.structure.graph.weight;

import java.util.HashMap;
import java.util.Map;

public class GrapWeightMain {

    //测试通过文件读取图的信息
    public static void main(String[] args) {
        //使用两种图的存储方式读取 data/testWeightG1.txt
        String filename = "testWeightG1.txt";
        SparseWeightGraph<Double> sparseWeightGraph = new SparseWeightGraph<>(8, false);
        ReadWeightedGraph readWeightedGraph = new ReadWeightedGraph(sparseWeightGraph, filename);
        System.out.println("testWeightG1 in Sparse Weighted Graph:");
        sparseWeightGraph.show();

        System.out.println();

        DenseWeightGraph<Double> denseWeightGraph = new DenseWeightGraph<>(8, false);
        ReadWeightedGraph readWeightedGraph2 = new ReadWeightedGraph(denseWeightGraph, filename);

        System.out.println("testWeightG1 in Dense Graph:");

        denseWeightGraph.show();

        System.out.println();
    }

}
