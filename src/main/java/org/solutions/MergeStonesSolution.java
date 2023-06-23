package org.solutions;

import java.util.Arrays;

class MergeStonesSolution {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n-k)%(k-1) != 0)
            return -1;
        int[][] memoCache = new int[n][n];
        int[] preSum = new int[n+1];
        for(int i=1; i<=n; i++){
            preSum[i] = preSum[i-1] + stones[i-1];
        }
        Arrays.stream(memoCache).forEach(row -> Arrays.fill(row, -1));
        int answer = dp(stones, 0, n-1, k, memoCache, preSum);
        System.out.println(Arrays.deepToString(memoCache));
        return answer;
    }

    public int dp(int[] stones, int l, int r, int k, int[][] memoCache, int[] preSum) {
        if(l>=r)
            return 0;
        if(memoCache[l][r]!=-1)
            return memoCache[l][r];

        int minCost = Integer.MAX_VALUE, currCost;
        for(int i=l; i<r; i+=k-1) {
            currCost = dp(stones, l, i, k, memoCache, preSum) + dp(stones, i+1, r, k, memoCache, preSum);
            minCost = Math.min(minCost, currCost);
        }
        if((r-l+1-k)%(k-1) == 0)
            minCost += preSum[r+1] - preSum[l];
        return memoCache[l][r] = minCost;
    }
}
