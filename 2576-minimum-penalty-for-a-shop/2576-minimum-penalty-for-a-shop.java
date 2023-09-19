class Solution {
    public int bestClosingTime(String customers) {
        int[] ans = new int[]{Integer.MAX_VALUE, -1};
        int n = customers.length();
        int yLeft = 0, nTillNow = 0;
        for(int i=0; i<n; i++) {
            yLeft += (customers.charAt(i)=='Y') ? 1 : 0;
        }
        for(int i=0; i<n+1; i++) {
            int currLoss = yLeft + nTillNow;
            if(currLoss<ans[0]) {
                ans[0] = currLoss;
                ans[1] = i;
            } else if(currLoss==ans[0] && i<ans[1]) {
                ans[0] = currLoss;
                ans[1] = i;
            }
            if(i<n && customers.charAt(i)=='Y')
                yLeft--;
            else
                nTillNow++;
        }
        return ans[1];
    }
}