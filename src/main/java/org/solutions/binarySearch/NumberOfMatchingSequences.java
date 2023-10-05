package org.solutions.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfMatchingSequences {
    public int numMatchingSubseq(String s, String[] words) {
        List<Integer>[] indexMap = new List[26];
        Arrays.fill(indexMap, new ArrayList<>());
        for(int i=0; i<s.length(); i++) {
            indexMap[s.charAt(i)-'a'].add(i);
        }
        int ans = 0;

        for(String w : words) {
            int flag = 1, prev = -1;
            for(char c : w.toCharArray()) {
                int lo=0, hi=indexMap[c-'a'].size()-1, pos=s.length();
                while(lo<=hi) {             //find upper bound for character i in indexMap of that character such that it is greater than the previous pos
                    int mid = lo+(hi-lo)/2;
                    if(indexMap[c-'a'].get(mid)>prev) {
                        pos = indexMap[c-'a'].get(mid);
                        hi = mid-1;
                    }
                    else {
                        lo = mid+1;
                    }
                }
                if(pos==s.length()) {
                    flag=0;
                    break;
                }
                prev = pos;
            }
            if(flag==1){
                ans++;
            }
        }

        return ans;
    }
}
