package org.solutions.dp;

public class FlipStringToMonotonicIncreasing {
    public int minFlipsMonoIncr(String s) {
        int onesTillNow = 0, zerosFlippedTillNow = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '1')
                onesTillNow++;
            else
                zerosFlippedTillNow++;
            zerosFlippedTillNow = Math.min(zerosFlippedTillNow, onesTillNow);
        }

        return zerosFlippedTillNow;
    }
}
