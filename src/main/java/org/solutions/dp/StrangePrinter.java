package org.solutions.dp;


import java.util.Arrays;

public class StrangePrinter {
    int dp[][];

    private int solve(String s, int left, int right) {
        if(left == right)
            return 1;
        if(left>right)
            return 0;

        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        int i;
        for(i=left+1; i<=right; i++)
            if(s.charAt(i)!=s.charAt(left))
                break;
        if(i>right)
            return 1;
        int simple = 1 + solve(s, i, right);

        int greedy = Integer.MAX_VALUE;
        for (int j = i+1; j <=right; j++) {
            if (s.charAt(j) == s.charAt(left)) {
                int currAns = solve(s, i, j-1) + solve(s, j, right);
                greedy = Math.min(greedy, currAns);
            }
        }

        return dp[left][right] = Math.min(simple, greedy);
    }

    public int strangePrinter(String s) {
        int n = s.length();
        dp = new int[n][n];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));

        return solve(s, 0, n - 1);
    }
}
