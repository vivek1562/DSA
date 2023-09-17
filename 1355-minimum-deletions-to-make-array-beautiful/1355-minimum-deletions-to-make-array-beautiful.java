class Solution {
    public int minDeletion(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int n = nums.length, i=0;
        while(i<n) {
            while(i<n && !s.isEmpty() && s.size()%2!=0) {
                if(nums[i]!=s.peek()) {
                    s.push(nums[i]);
                }
                i++;
            }
            if(i<n) {
                s.push(nums[i]);
                i++;
            }
        }
        
        if(s.size()%2!=0)
            s.pop();

        return nums.length-s.size();
    }
}