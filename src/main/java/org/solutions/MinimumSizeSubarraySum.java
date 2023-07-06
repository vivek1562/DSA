package org.solutions;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0, r=0, n=nums.length, windowSum=0, windowSize=0, minWindowSize=Integer.MAX_VALUE;

        while(r<n) {
            windowSum += nums[r];
            windowSize++;
            r++;
            while(windowSum-nums[l]>=target) {
                windowSum -= nums[l];
                windowSize--;
                l++;
            }
            if(windowSum>=target) {
                minWindowSize = Math.min(minWindowSize, windowSize);
            }
        }

        return minWindowSize == Integer.MAX_VALUE ? 0 : minWindowSize;
    }
}
