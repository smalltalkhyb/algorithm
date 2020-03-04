package com.hyb.algorithm.data.struct.structure.graph;

import java.util.Stack;

public class GraphPath {

    private IGraph graph;   //图的引用
    private boolean[] visited;   //记录dfs的过程中节点是否被访问
    private int[] from;  //记录路径, from[i]表示查找的路径上i的上一个节点
    private int start;  //起始节点

    public GraphPath(IGraph graph, int start) {
        this.graph = graph;
        this.visited = new boolean[graph.getNodeCount()];
        this.start = 0;
        this.from = new int[graph.getNodeCount()];

        for (int i = 0; i < graph.getNodeCount(); i++) {
            this.visited[i] = false;
            this.from[i] = -1;
        }

        this.start = start;

        dfs(start);
    }


    public void dfs(int v) {
        visited[v] = true;

        Iterable<Integer> iterable = graph.adj(v);
        for (Integer item : iterable) {
            if (!visited[item]) {
                from[item] = v;
                dfs(item);
            }
        }
    }

    public boolean hasPath(int v) {
        return visited[v];
    }

    // 打印出从s点到w点的路径
    public void showPath(int w) {
        Stack<Integer> stack = new Stack<>();

        int p = w;
        stack.push(w);
        while (p != -1 && p != start) {
            p = from[p];
            if (p == -1) {
                break;
            }
            stack.push(p);
        }

        while (!stack.empty()) {
            System.out.print(stack.pop() + "->");
        }
    }
}
