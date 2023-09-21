class Solution {
    Map<Integer, Integer> dp;

    public int minDays(int n) {
        dp = new HashMap<>();
        return ans(n)-1;
    }

    public int ans(int n) {
        if(n==0)
            return 0;
        if(dp.containsKey(n))
            return dp.get(n);
        dp.put(n, 1+Math.min((n%2)+ans(n/2), (n%3)+ans(n/3)));
        return dp.get(n);
    }
}