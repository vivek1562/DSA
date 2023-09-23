class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int m = str1.length(), n = str2.length(), i = 0, j = 0;
        while(i<m && j<n) {
            if(str1.charAt(i)==str2.charAt(j) || (str1.charAt(i)+1)%26==str2.charAt(j)%26) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        if(j==n)
            return true;
        return false;
    }
}