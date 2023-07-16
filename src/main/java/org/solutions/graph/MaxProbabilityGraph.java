package org.solutions.graph;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxProbabilityGraph {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair<Integer, Double>>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++)
            adjList.add(new ArrayList<>());
        int i=0;
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(new Pair<>(edge[1], succProb[i]));
            adjList.get(edge[1]).add(new Pair<>(edge[0], succProb[i]));
            i++;
        }

        double[] probability = new double[n];
        probability[start] = 1.0;
        Queue<Integer> pq = new LinkedList<>();
        pq.offer(start);

        while(!pq.isEmpty()) {
            int currEle = pq.poll();

            for(Pair<Integer, Double> neighbour : adjList.get(currEle)) {
                int node = neighbour.getKey();
                double prob = neighbour.getValue();
                double newProb = prob*probability[currEle];
                if(newProb > probability[node]) {
                    probability[node] = newProb;
                    pq.offer(node);
                }
            }
        }

        return probability[end];
    }
}
