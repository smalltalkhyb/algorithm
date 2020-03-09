package com.hyb.algorithm.data.struct.structure.graph.weight;

public class UnionFindGraph {

    private int[] parentArray;
    private int[] rank;
    private int size;

    public UnionFindGraph(int size) {
        this.parentArray = new int[size];
        this.rank = new int[size];
        this.size = size;

        for (int i = 0; i < size; i++) {
            this.parentArray[i] = i;
            this.rank[i] = 1;
        }
    }


    public boolean isConnected(int start, int end) {
        return parent(start) == parent(end);
    }

    public int parent(int start) {
        int parent = start;
        while (parent != parentArray[parent]) {
            // path compression 1
            parentArray[parent] = parentArray[parentArray[parent]];
            parent = parentArray[parent];
        }
        return parent;
    }

    public void union(int start, int end) {
        int startParent = parent(start);
        int endParent = parent(end);

        if (startParent == endParent)
            return;

        if (rank[startParent] > rank[endParent]) {
            parentArray[endParent] = startParent;
            return;
        }

        if (rank[startParent] < rank[endParent]) {
            parentArray[startParent] = endParent;
            return;
        }

        //如果相等
        parentArray[startParent] = endParent;
        rank[endParent] += 1;
    }
}
