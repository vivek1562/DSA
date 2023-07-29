package org.solutions.dp;

import java.util.Arrays;

public class SoupServings {
    double[][] dp;
    public double soupServings(int n) {
        if(n>=5000)
            return 1;
        dp = new double[n+1][n+1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return recur(n, n);
    }

    public double recur(int a, int b) {
        if(a<=0 && b<=0)
            return 0.5;
        if(a<=0)
            return 1;
        if(b<=0)
            return 0;

        if(dp[a][b] != -1)
            return dp[a][b];

        return dp[a][b] = 0.25*(recur(a-100,b) + recur(a-75,b-25) + recur(a-50,b-50) + recur(a-25,b-75));
    }
}
