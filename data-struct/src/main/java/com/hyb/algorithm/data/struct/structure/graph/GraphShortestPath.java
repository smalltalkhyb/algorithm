package com.hyb.algorithm.data.struct.structure.graph;

import java.util.Stack;

public class GraphShortestPath {

    private IGraph graph;
    private boolean[] visited;
    private int[] from;
    private int[] pathLength;
    private int start;

    public GraphShortestPath(IGraph graph, int start) {

        this.graph = graph;
        this.visited = new boolean[graph.getNodeCount()];
        this.from = new int[graph.getNodeCount()];
        this.pathLength = new int[graph.getNodeCount()];
        this.start = start;

        for (int i = 0; i < graph.getNodeCount(); i++) {
            this.visited[i] = false;
            this.from[i] = -1;
            this.pathLength[i] = 0;
        }

        bfs(start);
    }


    private void bfs(int v) {
        this.visited[v] = true;

        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        this.pathLength[v] = 0;
        while (!stack.isEmpty()) {
            Integer node = stack.pop();
            Iterable<Integer> iterable = graph.adj(node);
            for (Integer item : iterable) {
                if (!visited[item]) {
                    visited[item] = true;
                    stack.push(item);
                    pathLength[item] = pathLength[node] + 1;
                    from[item] = node;
                }
            }

        }
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


    public boolean hasPath(int w) {
        return visited[w];
    }

    public int pathLength(int w) {
        return pathLength[w];
    }
}
