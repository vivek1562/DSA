package org.solutions.dp;

import java.util.Arrays;

public class CombSum4 {
    int[] dp;

    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        dp = new int[target+1];
        Arrays.fill(dp, -1);
        return recur(nums, target);
    }

    public int recur(int[] nums, int target) {
        if(target==0)
            return 1;
        if(target<0)
            return 0;
        if(dp[target]!=-1)
            return dp[target];

        int ans = 0;
        for(int j=0; j<nums.length; j++) {
            ans += recur(nums, target-nums[j]);
        }

        return ans;
    }
}
