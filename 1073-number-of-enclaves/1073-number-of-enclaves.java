class Solution {
    int m, n;

    public int numEnclaves(int[][] grid) {
        int ans = 0;
        m = grid.length;
        n = grid[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if((i*j==0 || i==m-1 || j==n-1) && grid[i][j]!=0) {
                    dfs(grid, i, j);
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                ans+=grid[i][j];
            }
        }
        return ans;
    }

    public void dfs(int[][] g, int i, int j) {
        if(i<0 || i>=m || j<0 || j>=n || g[i][j]==0)
            return;
 
        g[i][j]=0;
        dfs(g, i+1, j);
        dfs(g, i-1, j);
        dfs(g, i, j+1);
        dfs(g, i, j-1);
    }
}