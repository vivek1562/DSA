class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length, ans=0;
        int[] leftLis = new int[n], rightLis = new int[n];
        for(int i=1; i<n; i++) {
            for(int j=i-1; j>=0; j--) {
                if(nums[i]>nums[j])
                    leftLis[i] = Math.max(leftLis[i], 1+leftLis[j]);
            }
        }
        for(int i=n-2; i>=0; i--) {
            for(int j=i+1; j<n; j++) {
                if(nums[i]>nums[j])
                    rightLis[i] = Math.max(rightLis[i], 1+rightLis[j]);
            }
        }
        for(int i=1; i<n-1; i++) {
            if(leftLis[i]>0 && rightLis[i]>0)
                ans = Math.max(ans, leftLis[i]+rightLis[i]+1);
        }
        return n-ans;
    }
}