class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        int ans = 0;
        for(int num : nums) {
            int cnt = m.getOrDefault(num, 0);
            ans += cnt;
            m.put(num, cnt+1);
        }
        return ans;
    }
}