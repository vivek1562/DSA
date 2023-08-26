package org.solutions.arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        int l=0, r=nums.length-1, i=0;
        while(i<=r) {
            if(nums[i]==0) {
                swap(i, l, nums);
                l++;
                i++;
            } else if(nums[i]==2) {
                swap(i, r, nums);
                r--;
            } else {
                i++;
            }
        }
    }

    public void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
