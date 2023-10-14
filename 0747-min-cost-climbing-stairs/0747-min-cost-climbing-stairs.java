class Solution {
    int[] dp;
    
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        Arrays.fill(dp, -1);
        int cost0 = recur(0, cost);
        int cost1 = recur(1, cost);
        return Math.min(cost0, cost1);
    }

    public int recur(int i, int[] cost) {
        if(i>=cost.length)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        return dp[i] = cost[i]+Math.min(recur(i+1, cost), recur(i+2, cost));
    }
}