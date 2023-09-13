class Solution {
    int ans = 0;
    int[][] dp;

    public int maximalSquare(char[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        Arrays.stream(dp).forEach(r->Arrays.fill(r,-1));

        for(int i=matrix.length-1; i>=0; i--) {
            for(int j=matrix[0].length-1; j>=0; j--) {
                ans = Math.max(ans, recur(matrix, i, j));
            }
        }
            
        return ans*ans;
    }

    public int recur(char[][] m, int i, int j) {
        if(i<0 || j<0 || m[i][j]=='0')
            return 0;

        if(dp[i][j]!=-1)
            return dp[i][j];
        
        dp[i][j] = 1 + Math.min(recur(m, i-1, j), Math.min(recur(m, i, j-1), recur(m, i-1, j-1)));

        return dp[i][j];
    }
}