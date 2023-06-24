package org.solutions;

import java.util.Arrays;

public class TallestBillboard {
    public int tallestBillboard(int[] rods) {
        int n = rods.length;
        int[][] cache = new int[n][10001];
        Arrays.stream(cache).forEach(row -> Arrays.fill(row, -1));
        int answer = dp(rods, 0, 0, cache);
        return Math.max(answer, 0);
    }

    public int dp(int[] rods, int i, int diff, int[][] cache) {
        if(i>=rods.length) {
            if(diff==0) {
                return 0;
            }
            return Integer.MIN_VALUE;
        }

        if(cache[i][diff+5000]!=-1)
            return cache[i][diff+5000];

        int addToLeft = rods[i] + dp(rods, i+1, diff+rods[i], cache);
        int addToRight = dp(rods, i+1, diff-rods[i], cache);
        int skip = dp(rods, i+1, diff, cache);

        return cache[i][diff+5000] = Math.max(addToLeft, Math.max(addToRight, skip));
    }
}
