class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] memoCache = new int[arr.length];
        Arrays.fill(memoCache, -1);
        return dp(arr, k, 0, memoCache);
    }

    public int dp(int[] arr, int k, int i, int[] memoCache) {
        if(i>arr.length-1)
            return 0;

        if(memoCache[i]!=-1)
            return memoCache[i];

        int maxSum = Integer.MIN_VALUE, currSum = 0, currMax = Integer.MIN_VALUE;
        for(int j=i; j<Math.min(i+k, arr.length); j++) {
            currMax = Math.max(currMax, arr[j]);
            currSum = (j-i+1)*currMax + dp(arr, k, j+1, memoCache);
            maxSum = Math.max(currSum, maxSum);
        }

        return memoCache[i]=maxSum;
    }
}