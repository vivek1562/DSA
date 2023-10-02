class Solution {
    public int longestSubarray(int[] nums) {
        int m = Arrays.stream(nums).max().getAsInt(), ans = 0, curr = 0, i = 0, f = 0;
        while(i<nums.length) {
            curr=0;
            f=0;
            while(i<nums.length && nums[i]==m) {
                curr++;
                i++;
                f=1;
            }
            ans = Math.max(ans, curr);
            if(f!=1)
                i++;
        }
        return ans;
    }
}