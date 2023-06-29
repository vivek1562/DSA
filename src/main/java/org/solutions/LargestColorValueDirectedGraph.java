package org.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestColorValueDirectedGraph {
    public int largestPathValue(String colors, int[][] edges) {
        char[] colorArray = colors.toCharArray();
        List<List<Integer>> adjList = new ArrayList<>();
        int answer = 1, n = colors.length(), nodesSeen = 0;
        int[][] colorCount = new int[n][26];
        int[] indegree = new int[n];
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            List<Integer> currList = adjList.get(edge[0]);
            currList.add(edge[1]);
            indegree[edge[1]]++;
        }
        for(int i=0; i<n; i++) {
            if(indegree[i]==0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int currNode = q.poll();
            nodesSeen++;
            answer = Math.max(answer, ++colorCount[currNode][colorArray[currNode]-97]);
            for(int neighbour : adjList.get(currNode)) {
                for(int i=0; i<26; i++) {
                    colorCount[neighbour][i] = Math.max(colorCount[currNode][i], colorCount[neighbour][i]);
                }
                if(--indegree[neighbour]==0) {
                    q.offer(neighbour);
                }
            }
        }

        return nodesSeen==n ? answer : -1;
    }
}
