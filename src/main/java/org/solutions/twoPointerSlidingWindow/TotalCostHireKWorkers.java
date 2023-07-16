package org.solutions.twoPointerSlidingWindow;

import javafx.util.Pair;

import java.util.*;

public class TotalCostHireKWorkers {
    public static long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long hiringCost = 0;
        int l=0, r=n-1;
        Queue<Pair<Integer, Integer>> pq = new PriorityQueue<>(2*candidates,
                (pair1, pair2) -> pair1.getKey() == pair2.getKey()
                        ? pair1.getValue()-pair2.getValue()
                        : pair1.getKey()-pair2.getKey());

        while(l<n && l<candidates) {
            pq.offer(new Pair<>(costs[l], l));
            l++;
        }
        while(r>=0 && r>n-1-candidates && l<=r) {
            pq.offer(new Pair<>(costs[r], r));
            r--;
        }

        Pair<Integer, Integer> currWorker;
        int removedIndex;
        while(k-->0) {
            currWorker = pq.poll();
            hiringCost += currWorker.getKey();
            removedIndex = currWorker.getValue();
            if(l<=r) {
                System.out.println(l+" "+r+" "+removedIndex);
                if(removedIndex<l) {
                    pq.offer(new Pair<>(costs[l], l));
                    l++;
                } else {
                    pq.offer(new Pair<>(costs[r], r));
                    r--;
                }
            }
        }

        return hiringCost;
    }
}
