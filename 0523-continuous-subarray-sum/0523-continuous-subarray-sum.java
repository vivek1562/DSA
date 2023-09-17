class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int runningSum = 0;

        map.put(0, -1); //-1 beacuse the size of subarray should be greater than 2
        for(int i=0; i<nums.length; i++) {
            runningSum += nums[i];
            if(k!=0)
                runningSum %= k;
            if(map.containsKey(runningSum)) {
                if(i-map.get(runningSum)>1)
                    return true;
            } else {
                map.put(runningSum, i);
            }
        }

        return false;
    }
}