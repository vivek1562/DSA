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
}
