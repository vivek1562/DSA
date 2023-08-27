package org.solutions.twoPointerSlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChar {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> m = new HashMap<>();
        int ans = 0, l=0, r=0, n = s.length();
        while(r<n) {
            if(m.getOrDefault(s.charAt(r), 0)<1) {
                ans  = Math.max(ans, r-l+1);
                m.put(s.charAt(r), m.getOrDefault(s.charAt(r), 0)+1);
                r++;
            } else {
                m.put(s.charAt(l), m.get(s.charAt(l))-1);
                l++;
            }
        }
        return ans;
    }
}
