class Solution {
    public int appendCharacters(String s, String t) {
        int m = s.length(), n = t.length(), i = 0, j = 0;
        while(i<m && j<n) {
            if(s.charAt(i)==t.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return n-j;
    }
}