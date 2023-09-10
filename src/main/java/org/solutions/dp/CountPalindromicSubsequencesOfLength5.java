package org.solutions.dp;

import java.util.Arrays;

public class CountPalindromicSubsequencesOfLength5 {
    int mod = (int)Math.pow(10,9)+7;
    String[] subSequences = new String[100];
    String str;
    Integer[][][] prevDp;
    Integer[][][] nextDp;

    public int countPalindromes(String s) {
        init();
        int ans = 0;
        str = s;
        for(int mid=2; mid<s.length()-2; mid++) {
            for(int i=0; i<subSequences.length; i++) {
                long leftCount = prevCheck(i, mid-1, 0);
                long rightCount = nextCheck(i, mid+1, 0);
                long temp = (leftCount*rightCount)%mod;
                ans = (ans + (int)temp)%mod;
            }
        }
        return ans;
    }

    public int prevCheck(int subSeqInd, int sInd, int subInd) {
        int sub_length = subSequences[subSeqInd].length();
        int s_length = str.length();

        if(subInd == sub_length)
            return 1;
        if(sInd == -1)
            return 0;

        if(prevDp[subSeqInd][sInd][subInd]!=null)
            return prevDp[subSeqInd][sInd][subInd];

        int count = prevCheck(subSeqInd, sInd-1, subInd)%mod;

        if(subSequences[subSeqInd].charAt(subInd) == str.charAt(sInd))
            count = (count + prevCheck(subSeqInd, sInd-1, subInd+1))%mod;

        return prevDp[subSeqInd][sInd][subInd] = count;
    }

    public int nextCheck(int subSeqInd, int sInd, int subInd) {
        int sub_length = subSequences[subSeqInd].length();
        int s_length = str.length();

        if(subInd == sub_length)
            return 1;
        if(sInd == s_length)
            return 0;

        if(nextDp[subSeqInd][sInd][subInd]!=null)
            return nextDp[subSeqInd][sInd][subInd];

        int count = nextCheck(subSeqInd, sInd+1, subInd)%mod;

        if(subSequences[subSeqInd].charAt(subInd) == str.charAt(sInd))
            count = (count + nextCheck(subSeqInd, sInd+1, subInd+1))%mod;

        return nextDp[subSeqInd][sInd][subInd] = count;
    }

    public void init() {
        prevDp = new Integer[101][10001][2];
        nextDp = new Integer[101][10001][2];
        int k=0;
        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                subSequences[k] = i+""+j;
                k++;
            }
        }
    }
}
