package org.solutions.dp;

import java.util.Arrays;

public class HouseRobber {
        public static int rob(int[] nums) {
            int n = nums.length;
            int[] cache = new int[n];
            Arrays.fill(cache, -1);
            return dp(nums, 0, cache);
        }

        public static int dp(int[] nums, int curr, int[] cache) {
            if(curr>=nums.length)
                return 0;

            if(cache[curr]!=-1)
                return cache[curr];

            int answer = 0;
            answer = Math.max(nums[curr]+dp(nums, curr+2, cache), dp(nums, curr+1, cache));

            return cache[curr]=answer;
        }

        public static int tabulation(int[] nums) {
            int n = nums.length;
            if(n==0)
                return 0;
            else if(n==1)
                return nums[0];
            int[] cache = new int[n];
            cache[n-1] = nums[n-1];
            cache[n-2] = Math.max(nums[n-1], nums[n-2]);
            for(int i=n-3; i>=0; i--) {
                cache[i] = Math.max(nums[i]+cache[i+2], cache[i+1]);
            }
            return cache[0];
        }
}
