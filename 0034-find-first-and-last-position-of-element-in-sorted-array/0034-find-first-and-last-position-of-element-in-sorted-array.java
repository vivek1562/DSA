class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int lo = 0, hi = n-1, first=-1, last=-1, mid;
        while(lo<=hi) {
            mid = lo+(hi-lo)/2;
            if(nums[mid]>=target)
                hi = mid-1;
            else
                lo = mid+1;
        }
        if(lo<n && nums[lo]==target) {
            first = lo;
        }
        
        lo = 0;
        hi = n-1;
        while(lo<=hi) {
            mid = lo+(hi-lo)/2;
            if(nums[mid]<=target)
                lo = mid+1;
            else
                hi = mid-1;
        }
        if(hi>-1 && nums[hi]==target) {
            last = hi;
        }

        return new int[]{first, last};
    }
}