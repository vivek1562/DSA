package org.solutions.dp;

import java.util.Arrays;

public class MaximumNumberOfEventsThatCanBeAttended2 {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> (a[0]-b[0]));
        int[][] dp = new int[events.length+1][k+1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return recursion(events, k, 0, dp);
    }

    public int recursion(int[][] events, int k, int i, int[][] dp) {
        if(i>=events.length || k==0)
            return 0;

        if(dp[i][k]!=-1)
            return dp[i][k];

        int notTake = recursion(events, k, i+1, dp), j = i+1;
        for(; j<events.length; j++)
            if(events[j][0]>events[i][1])
                break;
        int take = events[i][2] + recursion(events, k-1, j, dp);

        return dp[i][k] = Math.max(notTake, take);
    }
}
