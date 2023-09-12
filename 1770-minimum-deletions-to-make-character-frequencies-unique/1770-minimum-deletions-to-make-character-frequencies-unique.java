class Solution {
    public int minDeletions(String s) {
        Map<Character, Integer> m = new HashMap<>();
        int ans = 0;
        for(char c : s.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0)+1);
        }
        Set<Integer> set = new HashSet<>();
        for(Map.Entry<Character, Integer> e : m.entrySet()) {
            int currCount = e.getValue();
            while(currCount>0 && set.contains(currCount)) {
                currCount--;
                ans++;
            }
            set.add(currCount);
        }
        return ans;
    }
}