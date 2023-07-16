package org.solutions.hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequenceOfGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> cache = new HashMap<>();
        int answer = 0, curr;

        for(int i=0; i<arr.length; i++) {
            curr = 1 + cache.getOrDefault(arr[i]-difference, 0);
            cache.put(arr[i], curr);
            answer = Math.max(answer, curr);
        }

        return answer;
    }
}
