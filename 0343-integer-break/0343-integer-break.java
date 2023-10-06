class Solution {
    int[][] dp;
    public int integerBreak(int n) {
        dp = new int[n+1][n+1];
        Arrays.stream(dp).forEach(r->Arrays.fill(r, -1));
        return recur(n, 0);
    }

    int recur(int n, int k) {
        if(n==0) {
            if(k>=2)
                return 1;
            return 0;
        }
        if(dp[n][k]!=-1)
            return dp[n][k];
            
        int currPro = 1;
        for(int i=1; i<=n; i++)
            currPro = Math.max(currPro, i*recur(n-i, k+1));

        return dp[n][k]=currPro;
    }
}