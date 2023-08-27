package org.solutions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if(i>0 && nums[i] == nums[i-1])
                continue;
            for(int j = i+1; j<n; j++) {
                if(j>i+1 && nums[j] == nums[j-1])
                    continue;
                long sum2 = nums[i]+nums[j];
                long remSum = target - sum2;
                int l=j+1, r=n-1;
                while(l<r) {
                    if(nums[l]+nums[r]>remSum)
                        r--;
                    else if(nums[l]+nums[r]<remSum)
                        l++;
                    else {
                        answer.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                        while(l<r && nums[l]==nums[l-1])
                            l++;
                        while(l<r && nums[r]==nums[r+1])
                            r--;
                    }
                }
            }
        }
        return answer;
    }
}
