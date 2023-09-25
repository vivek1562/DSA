class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> m = new HashMap<>();
        for(char c : s.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0)+1);
        }
        for(char c : t.toCharArray()) {
            if(m.containsKey(c)) {
                int curr = m.getOrDefault(c, 0);
                if(curr==0)
                    return c;
                m.put(c, curr-1);
            } else {
                return c;
            }
        }
        return '0';
    }
}