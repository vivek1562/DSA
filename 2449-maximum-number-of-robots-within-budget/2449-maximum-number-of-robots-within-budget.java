class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length, ans=0, r=0, l=0;
        long currSum = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        while(r<n) {
            //window expansion phase
            while(!dq.isEmpty() && chargeTimes[dq.peekLast()]<chargeTimes[r]) { //maintain monotonically decreasing deque. ensure that leftmost element is maximum
                dq.pollLast();
            }
            dq.offerLast(r);
            currSum += runningCosts[r];

            long temp = (r-l+1)*currSum + chargeTimes[dq.peekFirst()];
            while(temp>budget && r>l) { //shrinking the window from left
                currSum -= runningCosts[l];
                l++;
                if(!dq.isEmpty() && dq.peekFirst()<l)
                    dq.pollFirst();
                temp = (r-l+1)*currSum + chargeTimes[dq.peekFirst()];
            }

            if(temp<=budget)    //contribution to answer if valid
                ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}