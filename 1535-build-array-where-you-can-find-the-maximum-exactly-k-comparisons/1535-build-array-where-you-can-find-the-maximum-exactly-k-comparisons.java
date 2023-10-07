class Solution {
    Integer[][][] dp = new Integer[51][101][51];
    int N, M, K;
    int mod = (int)1e9+7;

    public int numOfArrays(int n, int m, int k) {
        N=n;
        M=m;
        K=k;
        return recur(0, 0, 0);
    }

    public int recur(int i, int maxSoFar, int cost) {
        if(i==N) {
            if(cost==K)
                return 1;
            return 0;
        }

        if(dp[i][maxSoFar][cost]!=null)
            return dp[i][maxSoFar][cost];
        
        // if(cost>K)
        //     return 0;

        int ans = 0;
        for(int j=1; j<=M; j++) {
            if(j>maxSoFar) {
                ans = (ans+recur(i+1, j, cost+1)%mod)%mod;
            } else {
                ans = (ans+recur(i+1, maxSoFar, cost)%mod)%mod;
            }
        }

        return dp[i][maxSoFar][cost] = ans;
    }
}