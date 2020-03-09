package com.hyb.algorithm.data.struct.structure.graph.weight;

//边
public class Edge<Weight extends Number & Comparable> implements Comparable<Edge<Weight>> {

    private int start;  //边的起点
    private int end;  //边的结束点

    private Weight weight;// 边的权值

    public Edge(int start, int end, Weight weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public Edge(Edge<Weight> edge) {
        this.start = edge.start;
        this.end = edge.end;
        this.weight = edge.weight;
    }


    //返回第一个顶点
    public int getStart() {
        return start;
    }

    //返回第二个顶点
    public int getEnd() {
        return end;
    }

    //返回权值
    public Weight getWeight() {
        return weight;
    }

    //给定一个顶点，返回另外一个顶点
    public int other(int other) {
        if (other != start && other != end) {
            throw new IllegalArgumentException(" params  is illegal!");
        }

        return start == other ? end : start;
    }

    //输出边的信息
    public String toString() {
        return "" + start + "-" + end + ":" + weight;
    }


    //边之间的比较
    @Override
    public int compareTo(Edge that) {

        if (weight.compareTo(that.getWeight()) < 0) {
            return -1;
        }

        if (weight.compareTo(that.getWeight()) > 0) {
            return 1;
        }

        return 0;

    }
}



