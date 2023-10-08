class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length, mod = (int)1e9+7;
        long ans=0;
        int[] leftSmallest = new int[n], rightSmallest = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<=n; i++) {   //getting prev smaller and next smaller of popped element from stack and adding its contribution to answer
            while(!s.isEmpty() && (i==n || arr[s.peek()]>arr[i])) {   //not here
                int j = s.pop();
                leftSmallest[j] = s.isEmpty() ? -1 : s.peek();
                ans = (ans+((((j-leftSmallest[j])*(i-j))%mod)*(long)arr[j])%mod)%mod;
            }
            s.push(i);
        }

        return (int)ans;
    }
}