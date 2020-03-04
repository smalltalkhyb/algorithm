package com.hyb.algorithm.data.struct.structure.graph;


import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

//求无权图的联通分量
public class Components {

    private IGraph graph;   // 图的引用
    private boolean[] visited;  //节点访问
    private int connectedCount;  //联通节点数量
    private int[] connectedNodeIndex;// 联通节点


    public Components(IGraph graph) {
        this.graph = graph;
        visited = new boolean[graph.getNodeCount()];
        connectedNodeIndex = new int[graph.getNodeCount()];


        for (int i = 0; i < graph.getNodeCount(); i++) {
            visited[i] = false;
            connectedNodeIndex[i] = -1;
        }
        //求图的联通分量
        for (int i = 0; i < graph.getNodeCount(); i++) {
            if (!visited[i]) {
                dfs(i);
                connectedCount++;
            }
        }
    }


    public void dfs(int v) {
        visited[v] = true;
        connectedNodeIndex[v] = connectedCount;

        Iterable<Integer> iterable = graph.adj(v);

        for (Integer item : iterable) {
            if (!visited[item]) {
                dfs(item);
            }
        }
    }


    public int getConnectedCount(){
        return connectedCount;
    }
}
