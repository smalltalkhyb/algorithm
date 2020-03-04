package com.hyb.algorithm.data.struct.structure.graph;

import java.nio.file.Path;

public class GraphPathMain {
    public static void main(String[] args) {

        String filename="grappathdata.txt";

        SparseGraph graph=new SparseGraph(7,false);
        ReadGraph readGraph=new ReadGraph(graph,filename);
        graph.show();
        System.out.println();

        GraphPath graphPath=new GraphPath(graph,0);

        System.out.println("path from 0 to 6 :");
        graphPath.showPath(6);
    }
}
