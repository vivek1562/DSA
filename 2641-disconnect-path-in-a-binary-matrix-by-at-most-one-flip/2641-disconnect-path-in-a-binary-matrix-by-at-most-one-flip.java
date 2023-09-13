class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        if(!dfs(grid, 0, 0))
            return true;
        grid[0][0] = 1;
        return !dfs(grid, 0, 0);
    }

    public boolean dfs(int[][] g, int i, int j) {
        if(i>g.length-1 || j>g[0].length-1 || g[i][j]==0)
            return false;
        if(i==g.length-1 && j==g[0].length-1)
            return true;
        g[i][j]=0;
        return dfs(g, i+1, j) || dfs(g, i, j+1);
    }
}