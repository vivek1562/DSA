package org.solutions.dp;

import java.util.Arrays;

public class PredictTheWinner {
    int[][][] dp;
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new int[n][n][2];
        Arrays.stream(dp).forEach(r -> Arrays.stream(r).forEach(c -> Arrays.fill(c, -1)));
        return  recur(nums, 0, 0, n-1) >=0 ? true : false;
    }

    public int recur(int[] nums, int p, int l, int r) {
        if(l>r) {
            return 0;
        }
        if(dp[l][r][p]!=-1)
            return dp[l][r][p];

        int score = 0;
        if(p==0) {
            score = Math.max(nums[r]+recur(nums, 1, l, r-1), nums[l]+recur(nums, 1, l+1, r));
        } else {
            score = Math.min(-nums[r]+recur(nums, 0, l, r-1), -nums[l]+recur(nums, 0, l+1, r));
        }

        return dp[l][r][p] = score;
    }
}
