class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] vis = new boolean[26];
        int[] lastIndexMap = new int[26];
        char[] c = s.toCharArray();
        for(int i=0; i<c.length; i++) {
            lastIndexMap[c[i]-'a'] = i;
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<c.length; i++) {
            if(vis[c[i]-'a'] == false) {
                while(!ans.isEmpty()) {
                    char lastChar = ans.charAt(ans.length()-1);
                    if(lastChar>c[i] && lastIndexMap[lastChar-'a']>i) {
                        vis[lastChar-'a'] = false;
                        ans.deleteCharAt(ans.length()-1);
                    } else {
                        break;
                    }
                }
                ans.append(c[i]);
                vis[c[i]-'a'] = true;
            }
        }
        return ans.toString();
    }
}