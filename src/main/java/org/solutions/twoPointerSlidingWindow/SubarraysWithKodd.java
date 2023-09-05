package org.solutions.twoPointerSlidingWindow;

public class SubarraysWithKodd {
    public int numberOfSubarrays(int[] nums, int k) {
        int oddcount=0;
        int res=0;
        int i=0;
        int count=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]%2==1){
                oddcount++;
                count=0;
            }
            while(oddcount==k){
                if(nums[i++]%2==1) oddcount--;
                count++;
            }
            res+=count;
        }
        return res;
    }
}
