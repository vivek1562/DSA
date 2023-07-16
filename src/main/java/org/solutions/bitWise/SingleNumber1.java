package org.solutions.bitWise;

public class SingleNumber1 {
    public int singleNumber(int[] nums) {
        int answer = 0;
        for(int num : nums) {
            answer = answer^num;
        }
        return answer;
    }
}
