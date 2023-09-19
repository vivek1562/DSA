class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = Arrays.stream(weights).max().getAsInt(), hi = Arrays.stream(weights).sum();
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            if(check(weights, days, mid))
                hi = mid-1;
            else
                lo = mid+1;
        }
        return lo;
    }

    public boolean check(int[] arr, int days, int cap) {
        int d = 1, currWeight = 0;
        for(int i=0; i<arr.length; i++) {
            currWeight += arr[i];
            if(currWeight>cap) {
                d++;
                currWeight = arr[i];
            }
            if(d>days)
                return false;
        }
        return true;
    }
}