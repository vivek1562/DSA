class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length, ans = Integer.MAX_VALUE;
        Set<Integer> set = new TreeSet<>();
        for(int num : nums) {
            set.add(num);
        }
        Integer[] uniqueArr = set.toArray(new Integer[0]);

        for(int i=0; i<uniqueArr.length; i++) {
            int rangeMax = uniqueArr[i]+n-1;
            int upperBound = getUpperBound(uniqueArr, rangeMax);
            int operations = n-(upperBound-i);    //totalElements-inRange = outOfRange
            ans = Math.min(ans, operations);
        }

        return ans;
    }

    public int getUpperBound(Integer[] nums, int target) {
        int lo=0, hi = nums.length-1, mid;

        while(lo<=hi) {
            mid = lo+(hi-lo)/2;
            if(nums[mid]<=target) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }

        return lo;
    }
}