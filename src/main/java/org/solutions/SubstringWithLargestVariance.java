package org.solutions;

import java.util.Set;
import java.util.stream.Collectors;

public class SubstringWithLargestVariance {
    public int largestVariance(String s) {
        int maxVariance = 0;
        Set<Character> uniqueSet = s.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.toSet());

        for(char a : uniqueSet) {
            for(char b : uniqueSet) {
                if(a == b)
                    continue;
                int currVar = 0;
                boolean hasB = false, startsWithB = false;
                for(char currChar : s.toCharArray()) {
                    if(currChar == a)
                        currVar++;
                    else if(currChar == b) {
                        hasB = true;
                        if(startsWithB && currVar>=0) {
                            startsWithB = false;
                        } else if(hasB && currVar-1<0) {
                            startsWithB = true;
                            currVar = -1;
                        } else {
                            currVar--;
                        }
                    }
                    if(hasB) {
                        maxVariance = Math.max(currVar, maxVariance);
                    }
                }
            }
        }

        return maxVariance;
    }
}
