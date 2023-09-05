package org.solutions.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExtraCharactersInString {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return recur(0, s, new HashSet<>(Arrays.asList(dictionary)), n, dp);
    }

    public int recur(int i, String s, Set<String> d, int n, int[] dp) {
        if(i>=n)
            return 0;
        if(dp[i]!=Integer.MAX_VALUE)
            return dp[i];
        int currExtra = 0;
        int remExtra = 0;
        int totalExtra = Integer.MAX_VALUE;
        StringBuilder temp = new StringBuilder();
        for(int j = i; j<n; j++) {
            currExtra = 0;
            remExtra = 0;
            temp.append(s.charAt(j));
            if(!d.contains(temp.toString())) {
                currExtra = temp.length();
            }
            remExtra = recur(j+1, s, d, n, dp);
            totalExtra = Math.min(totalExtra, currExtra+remExtra);
        }
        return dp[i] = Math.min(dp[i], totalExtra);
    }

}
