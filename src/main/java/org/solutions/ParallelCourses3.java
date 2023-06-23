package org.solutions;

import java.util.*;

public class ParallelCourses3 {
    public static int minimumTime(int n, int[][] relations, int[] time) {
        int[] indegree = new int[n+1];
        int[] timeTaken = new int[n+1];
        for(int i=0; i<n; i++) {
            timeTaken[i+1] = time[i];
        }

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int answer = 0;

        for(int[] relation : relations) {
            indegree[relation[1]]++;
            List<Integer> list = adjList.getOrDefault(relation[0], new ArrayList<>());
            list.add(relation[1]);
            adjList.put(relation[0], list);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++)
            if(indegree[i]==0)
                q.offer(i);

        while(!q.isEmpty()) {
            int curr = q.poll();
            if(adjList.containsKey(curr)) {
                for(int neighbour : adjList.get(curr)) {
                    timeTaken[neighbour] = Math.max(timeTaken[neighbour], time[neighbour-1]+timeTaken[curr]);
                    if(--indegree[neighbour]==0)
                        q.offer(neighbour);
                }
            }
        }

        for(int val : timeTaken)
            answer = Math.max(answer, val);
        return answer;
    }
}
