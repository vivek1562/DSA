package org.solutions.dp;

import java.util.Arrays;

public class LongestArithmeticSequenceSolution {
    public static int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int answer = Integer.MIN_VALUE;
        int[][] cache = new int[n][1002];
        Arrays.stream(cache).forEach(row->Arrays.fill(row, -1));
        for(int i=0; i<n; i++) {
            answer = Math.max(answer, dp(nums, i, -501, cache));
        }
        return answer;
    }

    public static int dp(int[] nums, int i, int d, int[][] cache) {
        if(i>=nums.length)
            return 0;

        if(cache[i][d+501]!=-1)
            return cache[i][d+501];

        int maxLen = 1, take;
        if(d==-501) {
            for(int next = i+1; next<nums.length; next++) {
                take = 1+dp(nums, next, nums[next]-nums[i], cache);
                maxLen = Math.max(take, maxLen);
            }
        } else {
            for(int next=i+1; next<nums.length; next++) {
                if(nums[next]-nums[i]==d) {
                    take = 1+dp(nums, next, d, cache);
                    maxLen = Math.max(take, maxLen);
                    break;
                }
            }
        }

        return cache[i][d+501]=maxLen;
    }
}
