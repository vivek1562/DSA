class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length-1, mid, ans=Integer.MAX_VALUE;

        while(lo<=hi) {
            mid = lo+(hi-lo)/2;
            
            if(nums[mid]>=nums[lo]) {
                ans = Math.min(ans, nums[lo]);
                lo = mid+1;
            } else {
                ans = Math.min(ans, nums[mid]);
                hi = mid-1;
            }        
        }

        return ans;
    }
}