package org.solutions.queue;

import javafx.util.Pair;

import java.util.*;

public class KSmallestPairs {
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        Queue<Pair<Integer, Pair<Integer, Integer>>> pq = new PriorityQueue<>((a, b) -> a.getKey()-b.getKey());
        for(int i=0; i<k && i<nums1.length; i++) {
            pq.offer(new Pair<>(nums1[i]+nums2[0], new Pair<>(i, 0)));
        }

        Pair<Integer, Pair<Integer, Integer>> currMinPair;
        while(k-->0 && !pq.isEmpty()) {
            currMinPair = pq.poll();
            int i = currMinPair.getValue().getKey();
            int j = currMinPair.getValue().getValue();
            answer.add(Arrays.asList(nums1[i], nums2[j]));

            if(j+1<nums2.length) {
                pq.offer(new Pair<>(nums1[i]+nums2[j+1], new Pair<>(i, j+1)));
            }
        }

        return answer;
    }
}
