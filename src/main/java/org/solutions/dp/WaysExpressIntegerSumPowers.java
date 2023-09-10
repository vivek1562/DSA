package org.solutions.dp;

import java.util.Arrays;

public class WaysExpressIntegerSumPowers {
    int mod = (int)1e9+7;
    int[][] dp;
    int tot;

    public int numberOfWays(int n, int x) {
        dp = new int[n+1][n+1];
        tot = n;
        Arrays.stream(dp).forEach(r -> Arrays.fill(r, -1));
        return recur(n, x, 1);
    }

    public int recur(int n, int x, int i) {
        if(n<0 || i>tot)
            return 0;
        if(n==0)
            return 1;
        if(dp[n][i]!=-1)
            return dp[n][i];

        int ans = 0;
        ans += recur(n-(int)Math.pow(i, x), x, i+1)%mod;
        ans += recur(n, x, i+1)%mod;

        return dp[n][i] = ans;
    }
}
