package org.solutions.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DistinctSubsequences2 {
    int mod = (int)Math.pow(10, 9) + 7;

    public int distinctSubseqII(String s) {
        int answer = 0, n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(s.charAt(i) != s.charAt(j)) {
                    dp[i] += dp[j];
                    dp[i]%=mod;
                }
            }
            answer += dp[i];
            answer = answer%mod;
        }

        return answer;
    }
}
