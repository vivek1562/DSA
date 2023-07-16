package org.solutions.graph;

import java.util.*;

public class CheapestFlightKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++)
            adjList.add(new ArrayList<>());
        for(int[] flight : flights) {
            List<int[]> currList = adjList.get(flight[0]);
            currList.add(new int[]{flight[1], flight[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        dist[src] = 0;
        q.offer(new int[]{src, 0});

        while(!q.isEmpty() && k-->=0) {
            int currSize = q.size();
            while(currSize-->0) {
                int[] currNode = q.poll();
                for(int[] neighbour : adjList.get(currNode[0])) {
                    if(currNode[1]+neighbour[1] < dist[neighbour[0]]) {
                        dist[neighbour[0]] = currNode[1]+neighbour[1];
                        q.offer(new int[] {neighbour[0], dist[neighbour[0]]});
                    }
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
