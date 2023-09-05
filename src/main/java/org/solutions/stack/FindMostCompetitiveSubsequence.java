package org.solutions.stack;

import java.util.Stack;

public class FindMostCompetitiveSubsequence {
   public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> s = new Stack<>();
        int rem =  nums.length-k;
        for(int i=0; i<nums.length; i++) {
            while(!s.isEmpty() && rem!=0 && s.peek()>nums[i]) {
                s.pop();
                rem--;
            }
            s.push(nums[i]);
        }
        while(rem>0) {
            s.pop();
            rem--;
        }
        int[] ans = new int[k];
        for(int i=k-1; i>=0; i--) {
            ans[i] = s.pop();
        }
        return ans;
    }
}
