class Solution {
    int[][] dp;

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> (a.length()-b.length()));
        dp = new int[words.length][words.length+1];
        Arrays.stream(dp).forEach(r -> Arrays.fill(r, -1));
        return recur(0, -1, words);
    }

    public int recur(int i, int prev, String[] words) {
        if(i==words.length)
            return 0;
        if(dp[i][prev+1]!=-1)
            return dp[i][prev+1];
        int ans=0;
        if(prev==-1 || comp(words[prev], words[i])) {
            ans = 1+recur(i+1, i, words);                  //take
        }
        ans = Math.max(ans, recur(i+1, prev, words));      //not take
        return dp[i][prev+1] = ans;
    }

    public boolean comp(String a, String b) {
        int m = a.length(), n = b.length(), i = 0, j = 0, c=1;
        if((n-m)==1) {
            while(i<m && j<n) {
                if(a.charAt(i)==b.charAt(j)) {
                    i++;
                    j++;
                } else if(c==1) {
                    j++;
                    c=0;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}