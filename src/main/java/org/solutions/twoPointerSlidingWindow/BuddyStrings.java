package org.solutions.twoPointerSlidingWindow;

public class BuddyStrings {
    public boolean buddyStrings(String s, String goal) {
        if(goal.length()!=s.length())
            return false;
        int[] charCount = new int[26];
        int diffInd1=-1, diffInd2=-1;
        boolean reptCharPresent = false;
        for(int i=0; i<goal.length(); i++) {
            if(goal.charAt(i)!=s.charAt(i)) {
                if(diffInd1==-1) {
                    diffInd1 = i;
                } else if(diffInd2==-1) {
                    diffInd2 = i;
                } else {
                    return false;
                }
            }
            charCount[s.charAt(i)-'a']++;
            if(charCount[s.charAt(i)-'a']==2)
                reptCharPresent = true;
        }

        if(s.equals(goal) && reptCharPresent == true)
            return true;

        if(diffInd1!=-1 && diffInd2!=-1)
            return s.charAt(diffInd1)==goal.charAt(diffInd2) && s.charAt(diffInd2)==goal.charAt(diffInd1);

        return false;
    }
}
