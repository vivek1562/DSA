class Solution {
    int mod = (int)1e9+7;

    public int waysToSplit(int[] nums) {
        int n = nums.length, ans = 0;
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for(int i=1; i<n; i++)
            preSum[i] = preSum[i-1]+nums[i];

        for(int i=0; i<n-2; i++) {
            int leftSum = preSum[i];
            int mid, cut1 = -1, cut2 = -1;
            
            //find min possible end of 2nd partition
            int lo = i+1, hi = n-2;
            while(lo<=hi) {
                mid = lo+(hi-lo)/2;
                if(preSum[mid]-preSum[i]>=preSum[i]) {
                    hi = mid-1;
                } else {
                    lo = mid+1;
                }
            }
            cut1 = lo; 

            //find max possible end of 2nd partition
            lo = i+1;
            hi = n-2;
            while(lo<=hi) {
                mid = lo+(hi-lo)/2;
                if(preSum[n-1]-preSum[mid]>=preSum[mid]- preSum[i]) {
                    lo = mid+1;
                } else {
                    hi = mid-1;
                }
            }
            cut2 = hi;

            if(cut1==-1 || cut2==-1 | cut1>cut2)
                continue;
            ans = (ans+(cut2-cut1+1)%mod)%mod;
        }

        return ans;
    }
}