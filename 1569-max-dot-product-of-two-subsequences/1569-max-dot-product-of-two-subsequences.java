class Solution {
    int[][] dp;

    public int maxDotProduct(int[] nums1, int[] nums2) {
        dp = new int[nums1.length][nums2.length];
        Arrays.stream(dp).forEach(r -> Arrays.fill(r, Integer.MIN_VALUE));
        return recur(0, 0, nums1, nums2);
    }

    public int recur(int i, int j, int[] nums1, int[] nums2) {
        if(i==nums1.length || j==nums2.length) {
            return Integer.MIN_VALUE;
        }
        
        if(dp[i][j]!=Integer.MIN_VALUE)
            return dp[i][j];
        
        int ans = nums1[i]*nums2[j] + Math.max(recur(i+1, j+1, nums1, nums2), 0);
        ans = Math.max(ans, recur(i+1, j, nums1, nums2));
        ans = Math.max(ans, recur(i, j+1, nums1, nums2));

        return dp[i][j] = ans;
    }
}