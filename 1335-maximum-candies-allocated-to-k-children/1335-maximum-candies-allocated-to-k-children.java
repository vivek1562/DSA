class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        int hi = (int)(Arrays.stream(candies).asLongStream().sum()/k), lo = 1;

        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            if(check(candies, k, mid))
                lo = mid+1;
            else
                hi = mid-1;
        }

        return hi;
    }

    public boolean check(int[] candies, long k, int target) {
        for(int i=0; i<candies.length; i++) {
            k -= (candies[i]/target);
            if(k<=0)
                return true;
        }
        return false;
    }
}