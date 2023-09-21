class Solution {
    Map<Integer, Integer> dp;

    public int minDays(int n) {
        dp = new HashMap<>();
        return ans(n);
    }

    public int ans(int n) {
        if(n<=1) //if we take n==0 as base case then need to subtract 1 from final answer because the compute step would do ans(1) = 1+(1%2+0) = 2 instead of 1;
            return n;
        if(dp.containsKey(n))
            return dp.get(n);
        dp.put(n, 1+Math.min((n%2)+ans(n/2), (n%3)+ans(n/3)));
        return dp.get(n);
    }
}