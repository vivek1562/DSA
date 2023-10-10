class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length-1, mid, ans=Integer.MAX_VALUE;
        if(hi>=0 && nums[lo]<=nums[hi])
            return nums[lo];

        while(lo<=hi) {
            mid = lo+(hi-lo)/2;
            if(mid-1>=0 && nums[mid]<nums[mid-1])
                return nums[mid];
            if(nums[mid]>=nums[hi]) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }        
        }

        return -1;
    }
}