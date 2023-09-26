class Solution {
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        long currCount = 0;
        int ans = 0;
        Collections.sort(usageLimits);

        for(int i=0; i<usageLimits.size(); i++) {
            currCount += usageLimits.get(i);
            if(currCount>=((ans+1)*(ans+2))/2)
                ans++;
        }

        return ans;
    }
}