class Solution {
    double[][] dp;

    public double champagneTower(int poured, int query_row, int query_glass) {
        dp = new double[query_row+1][query_glass+1];
        Arrays.stream(dp).forEach(r -> Arrays.fill(r, -1.0));
        return Math.min(1.0, recur(poured, query_row, query_glass));
    }

    public double recur(int n, int r, int c) {
        if(r<0 || c<0 || r<c)
            return 0.0;
        if(r==0 && c==0)
            return n;

        if(dp[r][c]!=-1)
            return dp[r][c];

        double left = (recur(n, r-1, c-1)-1)/2.0;
        double right = (recur(n, r-1, c)-1)/2.0;

        if(left<0)
            left = 0;
        if(right<0)
            right = 0;

        return dp[r][c] = left+right;
    }
}