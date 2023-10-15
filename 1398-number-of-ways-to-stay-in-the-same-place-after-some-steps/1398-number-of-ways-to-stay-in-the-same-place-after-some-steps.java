class Solution {
    private int n;
    private int[][] t;
    private final int MOD = 1000000007; // Equivalent to 1e9+7 in C++

    public int numWays(int steps, int arrLen) {
       /*
        Note that furthest we can go is by only making moves to the right, 
        but we can go to right by "steps" moves. 
        Thus, we can do, arrLen = min(arrLen, steps)
        */
        arrLen = Math.min(arrLen, steps);

        /*
            Also if you notice, you can only move away from 0 in the array by at max steps/2 to come back to 0
            So, we can also do
            arrLen = Math.min(arrLen, (steps+1)/2); //(steps+1)/2 takes care of Odd case as well.
        */
            
        n = arrLen;
        t = new int[501][501];
        for (int i = 0; i < 501; i++) {
            Arrays.fill(t[i], -1);
        }
        return solve(0, steps);
    }

    private int solve(int idx, int steps) {
        if (idx < 0 || idx >= n) {
            return 0;
        }

        if (steps == 0) {
            return idx == 0 ? 1 : 0;
        }

        if (t[idx][steps] != -1) {
            return t[idx][steps];
        }

        int result = solve(idx + 1, steps - 1) % MOD; // RIGHT
        result = (result + solve(idx - 1, steps - 1)) % MOD; // LEFT
        result = (result + solve(idx, steps - 1)) % MOD; // STAY

        t[idx][steps] = result;
        return result;
    }
}