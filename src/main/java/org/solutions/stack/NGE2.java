package org.solutions.stack;

import java.util.Arrays;
import java.util.Stack;

public class NGE2 {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        Stack<Integer> s = new Stack<>();
        for(int i=2*n-1; i>=0; i--) {
            while(!s.isEmpty() && s.peek()<=nums[i%n]) {
                s.pop();
            }
            if(!s.isEmpty())
                answer[i%n] = s.peek();
            s.push(nums[i%n]);
        }
        return answer;
    }
}
