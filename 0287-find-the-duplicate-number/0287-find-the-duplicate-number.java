class Solution {
    public int findDuplicate(int[] nums) {
        int fast = nums[0], slow = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow!=fast);

        fast = nums[0];
        
        while(fast != slow)
        {
            fast = nums[fast];
            slow = nums[slow];
        }
        
        return slow;
    }
}