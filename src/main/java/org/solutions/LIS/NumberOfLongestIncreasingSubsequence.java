package org.solutions.LIS;

public class NumberOfLongestIncreasingSubsequence {
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length, lisL = 1, lisC = 0;
        int[] dp = new int[n], count = new int[n];
        for(int i=0; i<n; i++) {
            count[i] = 1;
            dp[i] = 1;
            for(int j=0; j<i; j++) {
                if(nums[i]>nums[j] && dp[j]+1>dp[i]) {
                    dp[i] = dp[j]+1;
                    count[i] = count[j];
                } else if(nums[i]>nums[j] && dp[j]+1 == dp[i]) {
                    count[i]+=count[j];
                }
            }
            lisL = Math.max(lisL, dp[i]);
        }
        for(int i=0; i<n; i++) {
            if(dp[i]==lisL)
                lisC+=count[i];
        }
        return lisC;
    }
}
