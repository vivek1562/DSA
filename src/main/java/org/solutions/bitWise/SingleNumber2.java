package org.solutions.bitWise;

public class SingleNumber2 {
    public int singleNumber2method1(int[] nums) {
        int ans = 0, shift = 1;
        for(int i=0; i<32; i++) {
            int countSetBits = 0;
            for(int j=0; j<nums.length; j++) {
                if(((nums[j]>>i) & 1) ==1) {
                    countSetBits++;
                }
            }
            if(countSetBits%3 != 0)
                ans = ans + shift;
            shift *= 2;
        }
        return ans;
    }

    public int singleNumber2method2(int[] nums) {
        int ans = 0;
        for(int i=0; i<32; i++) {
            int countSetBits = 0;
            //generate mask once for each bit position rather than shifting all nums[j] by i
            int mask = 1 << i;
            for(int j=0; j<nums.length; j++) {
                if((nums[j] & mask) != 0) {
                    countSetBits++;
                }
            }
            if(countSetBits%3 != 0)
                ans = ans | mask;
        }
        return ans;
    }
}
