class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length, mod = (int)1e9+7;
        long ans=0;
        int[] leftSmallest = new int[n], rightSmallest = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<n; i++) {
            while(!s.isEmpty() && arr[s.peek()]>arr[i]) {   //not here
                s.pop();
            }
            if(s.isEmpty())
                leftSmallest[i] = -1;
            else
                leftSmallest[i] = s.peek();
            s.push(i);
        }

        s.clear();
        for(int i=n-1; i>=0; i--) {
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]) { //equality here if we use equality twice then repeated subarrays are considered
                s.pop();
            }
            if(s.isEmpty())
                rightSmallest[i] = n;
            else
                rightSmallest[i] = s.peek();
            s.push(i);

            ans = (ans+((((i-leftSmallest[i])*(rightSmallest[i]-i))%mod)*(long)arr[i])%mod)%mod;
        }

        return (int)ans;
    }
}