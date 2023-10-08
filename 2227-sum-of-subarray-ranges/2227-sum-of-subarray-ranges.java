class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length, mod = (int)1e9+7;
        long ans=0;
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<=n; i++) {   //getting prev smaller and next smaller of popped element from stack and adding its contribution to answer
            while(!s.isEmpty() && (i==n || nums[s.peek()]>nums[i])) {
                int j = s.pop();
                int leftSmallestJ = s.isEmpty() ? -1 : s.peek();
                ans = ans+(((j-leftSmallestJ)*(i-j))*(long)nums[j]);
            }
            s.push(i);
        }
        s.clear();
        ans *= -1;

        for(int i=0; i<=n; i++) {   //getting prev greater and next greater of popped element from stack and adding its contribution to answer
            while(!s.isEmpty() && (i==n || nums[s.peek()]<nums[i])) {
                int j = s.pop();
                int leftGreatestJ = s.isEmpty() ? -1 : s.peek();
                ans = ans+((j-leftGreatestJ)*(i-j))*(long)nums[j];
            }
            s.push(i);
        }

        return ans;
    }
}