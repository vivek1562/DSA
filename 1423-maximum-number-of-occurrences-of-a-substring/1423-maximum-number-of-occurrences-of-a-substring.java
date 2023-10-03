class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> count = new HashMap<>();
        int ans=0, unique=0, j=0;
        int[] set = new int[26];
        while(j<minSize) {
            char c = s.charAt(j);
            if(set[c-'a']==0) {
                unique++;
            }
            set[c-'a']++;
            j++;
        }

        for(int i=0; i<s.length()-minSize+1; i++) {
            
            if(unique<=maxLetters) {
                String curr = s.substring(i, i+minSize);
                count.put(curr, count.getOrDefault(curr, 0)+1);
                ans = Math.max(ans, count.get(curr));
            }

            char l = s.charAt(i);
            set[l-'a']--;
            if(set[l-'a']==0)
                    unique--;

            if(i+minSize<s.length()) {
                char r = s.charAt(i+minSize);
                set[r-'a']++;
                if(set[r-'a']==1)
                    unique++;
            }
        }

        return ans;
    }
}