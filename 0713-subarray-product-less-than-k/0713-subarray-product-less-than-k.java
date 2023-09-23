class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long curr = 1;
        int ans = 0, l = 0, r = 0;

        while(r<nums.length) {
            curr *= nums[r];
            while(curr>=k && l<=r) {
                curr /= nums[l];
                l++;
            }
            ans += r-l+1;
            r++;
        }

        return ans;
    }
}