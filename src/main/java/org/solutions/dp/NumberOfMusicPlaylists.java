package org.solutions.dp;

import java.util.Arrays;

public class NumberOfMusicPlaylists {
    int mod = (int)Math.pow(10, 9)+7;
    int[][] dp;

    public int numMusicPlaylists(int n, int goal, int k) {
        dp = new int[goal+1][n+1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return (int)solve(0, 0, n, k, goal);
    }

    public long solve(int countSong, int countUniqueSong, int n, int k, int goal) {
        if(countSong == goal) {
            if(countUniqueSong == n)
                return 1;
            return 0;
        }

        if(dp[countSong][countUniqueSong] != -1)
            return dp[countSong][countUniqueSong];

        long result = 0;
        if(n-countUniqueSong>0)
            result += ((n-countUniqueSong)*solve(countSong+1, countUniqueSong+1, n ,k, goal))%mod; //play unique song

        if(countUniqueSong-k > 0)
            result += ((countUniqueSong-k)*solve(countSong+1, countUniqueSong, n ,k, goal))%mod; //replay song

        return dp[countSong][countUniqueSong] = (int)result%mod;
    }
}
