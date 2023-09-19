class Solution {

    public int splitArray(int[] nums, int k) {
        int hi = Arrays.stream(nums).sum(), lo = Arrays.stream(nums).max().getAsInt();
        while(lo<=hi) {
          int mid = lo+(hi-lo)/2;
          if(valid(nums, mid, k))
            hi = mid-1;
          else
            lo = mid+1;
        }
        return lo;
    }

    public boolean valid(int[] nums, int target, int k) {
      int currParts = 1, currSum = 0;

      for(int i=0; i<nums.length; i++) {
        currSum += nums[i];
        if(currSum>target) {
          currParts++;
          currSum = nums[i];
        }
        if(currParts>k)
          return false;
      }

      return true;
    }

}