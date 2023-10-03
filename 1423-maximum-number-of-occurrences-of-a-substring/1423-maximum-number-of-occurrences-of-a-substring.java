class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> count = new HashMap<>();
        int ans=0, unique=0, j=0;
        Map<Character, Integer> set = new HashMap<>();
        while(j<minSize) {
            char c = s.charAt(j);
            if(set.getOrDefault(c, 0)==0) {
                unique++;
            }
            set.put(c, set.getOrDefault(c, 0)+1);
            j++;
        }

        for(int i=0; i<s.length()-minSize+1; i++) {
            
            if(unique<=maxLetters) {
                String curr = s.substring(i, i+minSize);
                count.put(curr, count.getOrDefault(curr, 0)+1);
                ans = Math.max(ans, count.get(curr));
            }

            char l = s.charAt(i);
            set.put(l, set.getOrDefault(l, 0)-1);
            if(set.getOrDefault(l, 0)==0)
                    unique--;

            if(i+minSize<s.length()) {
                char r = s.charAt(i+minSize);
                set.put(r, set.getOrDefault(r, 0)+1);
                if(set.getOrDefault(r, 0)==1)
                    unique++;
            }
        }

        return ans;
    }
}