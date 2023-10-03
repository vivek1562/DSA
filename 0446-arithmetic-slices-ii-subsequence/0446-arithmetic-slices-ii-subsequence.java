class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length, ans = 0, cnt;
        long d;
        Map<Long, Integer>[] dp = new Map[n]; //dp[i][j] contains number of subsequences with common diff j ending at i 
        dp[0] = new HashMap<>();

        for(int i=1; i<n; i++) {
            dp[i] = new HashMap<>();
            for(int j=0; j<i; j++) {
                d = (long)nums[i]-nums[j];
                cnt = dp[j].getOrDefault(d, 0);
                dp[i].put(d, dp[i].getOrDefault(d, 0) + cnt + 1);
                ans += cnt;
            }
        }

        return ans;
    }
}