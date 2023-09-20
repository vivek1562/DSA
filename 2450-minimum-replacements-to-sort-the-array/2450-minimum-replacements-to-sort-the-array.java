class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length, last = nums[n-1];
        long ans = 0;

        for(int i=n-2; i>=0; i--) {
            if(nums[i]>last) {

                int pieces = nums[i]/last;
                if(nums[i]%last!=0)
                    pieces++;

                int pieceSize = nums[i]/pieces;
                last = pieceSize;

                ans += pieces-1;
            } else {
                last = nums[i];
            }
        }

        return ans;
    }
}