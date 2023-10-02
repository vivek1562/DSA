class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length, ans = 0;
        long sum = 0;
        long[] pre = new long[n];

        pre[0] = nums[0];
        for(int i=1; i<n; i++)
            pre[i] = pre[i-1]+nums[i];
        sum = pre[n-1];

        for(int i=0; i<n-1; i++) {
            if(pre[i]>=sum-pre[i])
                ans++;
        }

        return ans;
    }
}