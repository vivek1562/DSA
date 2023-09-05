package org.solutions.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    Boolean[] dp;
    int n;
    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        dp = new Boolean[n];
        Set<String> wordSet = new HashSet<>(wordDict);
        return solve(0, s, wordSet);
    }

    public boolean solve(int i, String s, Set<String> wordSet) {
        if(i>=n)
            return true;
        if(dp[i]!=null)
            return dp[i];
        for(int endIdx = i+1; endIdx<=n; endIdx++) {
            String temp = s.substring(i, endIdx);
            if(wordSet.contains(temp) && solve(endIdx, s, wordSet))
                return dp[i] = true;
        }
        return dp[i] = false;
    }
}
