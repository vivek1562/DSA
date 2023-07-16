package org.solutions.topologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap();
        int[] vis = new int[numCourses]; // vis[i] == 0 node is unvisited
        for(int i=0; i<numCourses; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for(int[] entry : prerequisites) {
            adjList.get(entry[1]).add(entry[0]);
        }
        for(int i=0; i<numCourses; i++) {
            if(dfs(adjList, i, vis))
                return false;
        }
        return true;
    }

    public boolean dfs(Map<Integer, List<Integer>> adjList, int curr, int[] vis) {
        if(vis[curr]==2)
            return true;
        if(vis[curr]==1)
            return false;
        vis[curr] = 2; //mark visited
        for(Integer neighbour : adjList.get(curr)) {
            if(dfs(adjList, neighbour, vis))
                return true;
        }
        vis[curr] = 1; //mark safe
        return false;
    }
}
