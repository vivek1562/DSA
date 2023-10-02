class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length, ans=0, i=1, up=0, down=0;

        while(i<n) {
            up=0;
            down=0;
            while(i<n && arr[i]>arr[i-1]){
                i++;
                up++;
            }

            while(i<n && arr[i]<arr[i-1]) {
                i++;
                down++;
            }

            if(up>0 && down>0) {
                ans = Math.max(ans, up+down+1);
            }
            if(up==0 && down==0) {
                i++;
            }
        }

        return ans;
    }
}