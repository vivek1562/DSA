class Solution {
    public int minOperations(int[] nums, int x) {
        int n=nums.length, l=0, r=0, maxLength = -1;
        int s = Arrays.stream(nums).sum(), target = s-x, currSum = 0;
        while(r<n) {
            currSum += nums[r];
            while(currSum>target && l<=r) {       
                currSum -= nums[l];
                l++;
            }

            if(currSum==target)
                maxLength = Math.max(maxLength, r-l+1);
            r++;
        }
        return maxLength == -1 ? -1 : n-maxLength;
    }
}