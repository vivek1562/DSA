class Solution {
    int n;
    int[][] t;

    public int solve(int idx, int remaining, int[] cost, int[] time) {

        if (remaining <= 0)
            return 0;

        if (idx == n) {
            return 1000000000;
        }

        if (t[idx][remaining] != -1) {
            return t[idx][remaining];
        }

        int paint_i = cost[idx] + solve(idx + 1, remaining - 1 - time[idx], cost, time);
        int not_paint_i = solve(idx + 1, remaining, cost, time);

        return t[idx][remaining] = Math.min(paint_i, not_paint_i);
    }

    public int paintWalls(int[] cost, int[] time) {
        n = cost.length;
        t = new int[501][501];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        return solve(0, n, cost, time);
    }
}