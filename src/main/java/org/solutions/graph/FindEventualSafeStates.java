package org.solutions.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] nodeStatus = new int[n];
        List<Integer> safeNodes = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(checkUtility(graph, nodeStatus, i)) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    public boolean checkUtility(int[][] graph, int[] nodeStatus, int i) {
        if(nodeStatus[i] == 2)
            return false;
        if(nodeStatus[i] == 1)
            return true;
        nodeStatus[i] = 2;
        for(int edge : graph[i]) {
            if(!checkUtility(graph, nodeStatus, edge))
                return false;
        }
        nodeStatus[i] = 1;
        return true;
    }
}
