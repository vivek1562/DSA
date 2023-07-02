package org.solutions;

import java.util.ArrayList;
import java.util.List;

public class RedundantConnections {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        int n = edges.length;
        for(int i=0; i<=n; i++)
            adjList.add(new ArrayList<>());
        for(int[] edge : edges) {
            boolean[] vis = new boolean[n+1];
            if(dfs(edge[0], edge[1], adjList, vis))
                return edge;
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        return new int[]{};
    }

    public boolean dfs(int src, int target, List<List<Integer>> adjList, boolean[] vis) {
        if(vis[src] == true)
            return false;
        vis[src] = true;
        if(src == target)
            return true;
        for(int neighbour : adjList.get(src)) {
            if(dfs(neighbour, target, adjList, vis))
                return true;
        }
        return false;
    }
}
