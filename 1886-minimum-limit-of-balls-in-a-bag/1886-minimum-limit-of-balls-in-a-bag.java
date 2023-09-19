class Solution {
    public int minimumSize(int[] nums, int maxOps) {
        int hi = Arrays.stream(nums).max().getAsInt(), lo = 1, n = nums.length;

        while(lo<=hi) {
          int mid = lo+(hi-lo)/2;
          if(check(nums, mid, maxOps))
            hi = mid-1;
          else
            lo = mid+1;
        }

        return lo;
    }

    public boolean check(int[] nums, int largest, int maxOps) {

      for(int num : nums) {
        int q = num/largest;
        
        if(num%largest==0)
          q--;
        maxOps -= q;

        if(maxOps<0)
          return false;
      }

      return true;
    }
}