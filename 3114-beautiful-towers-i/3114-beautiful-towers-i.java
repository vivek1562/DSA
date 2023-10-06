class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        Stack<Integer> s = new Stack<>();
        int n = maxHeights.size();
        long[] l2r = new  long[n], r2l = new long[n];
        Arrays.fill(l2r, -1);
        Arrays.fill(r2l, n);
        long ans = 0, currSum = 0;

        for(int i=0; i<n; i++) {    //build next smaller element sum to left array
            while(!s.isEmpty() && maxHeights.get(s.peek())>maxHeights.get(i)) {
                int j = s.pop();
                currSum -= (long)maxHeights.get(j)*(j-(s.isEmpty()?-1:s.peek()));    //delete elements in between
            }
            
            currSum += (long)maxHeights.get(i)*(i-(s.isEmpty()?-1:s.peek()));
            l2r[i] = currSum;
            s.push(i);
        }

        s.clear();
        currSum=0;
        for(int i=n-1; i>=0; i--) {    //build next smaller element to right array
            while(!s.isEmpty() && maxHeights.get(s.peek())>maxHeights.get(i)) {
                int j = s.pop();
                currSum -= (long)maxHeights.get(j)*((s.isEmpty()?n:s.peek())-j);
            }

            currSum += (long)maxHeights.get(i)*((s.isEmpty()?n:s.peek())-i);
            r2l[i] = currSum;           //since doingin same loop storing not reqd
            s.push(i);  

            ans = Math.max(ans, currSum+l2r[i]-maxHeights.get(i));
        }

        return ans;
    }
}