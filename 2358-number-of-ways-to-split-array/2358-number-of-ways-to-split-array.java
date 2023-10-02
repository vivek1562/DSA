class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length, ans = 0;
        long rsum = 0, lsum = 0;

        for(int i=0; i<n; i++)
            rsum += nums[i];

        for(int i=0; i<n-1; i++) {
            rsum -= nums[i];
            lsum += nums[i];
            if(lsum>=rsum)
                ans++;
        }

        return ans;
    }
}