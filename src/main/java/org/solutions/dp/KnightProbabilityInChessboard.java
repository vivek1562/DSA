package org.solutions.dp;

import java.util.Arrays;

public class KnightProbabilityInChessboard {
    double[][][] dp;
    public double knightProbability(int n, int k, int row, int column) {
        dp = new double[n][n][k+1];
        Arrays.stream(dp).forEach(r -> Arrays.stream(r).forEach(c -> Arrays.fill(c, -1)));
        return recursion(row, column, n, k);
    }

    public double recursion(int r, int c, int n, int k) {
        if(r<0 || r>=n || c<0 || c>=n)
            return 0;
        if(k==0)
            return 1;
        if(dp[r][c][k]!=-1)
            return dp[r][c][k];
        return dp[r][c][k] = (recursion(r-2, c+1, n, k-1)
                +recursion(r-1, c+2, n, k-1)
                +recursion(r+1, c+2, n, k-1)
                +recursion(r+2, c+1, n, k-1)
                +recursion(r+2, c-1, n, k-1)
                +recursion(r+1, c-2, n, k-1)
                +recursion(r-1, c-2, n, k-1)
                +recursion(r-2, c-1, n, k-1))/8.0;
    }
}
