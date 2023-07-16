package org.solutions.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PutMarblesInBags {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        List<Integer> partitionSumArray = new ArrayList<>();
        long minScore = 0, maxScore = 0;
        for(int i=0; i<n-1; i++) {
            partitionSumArray.add(weights[i]+weights[i+1]);
        }
        Collections.sort(partitionSumArray);
        for(int i=0; i<k-1; i++) {
            minScore += partitionSumArray.get(i);
            maxScore += partitionSumArray.get(n-2-i);
        }
        return maxScore - minScore;
    }
}
