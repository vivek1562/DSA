class Solution {
    public String decodeAtIndex(String s, int k) {
        int n = s.length(), i=0;
        long len=0;
        while(i<n) {
            char curr = s.charAt(i);
            if(!Character.isDigit(curr)) {
                len++;
            } else {
                len*=(curr-'0');
            }
            i++;
        }
        for(i=n-1; i>=0; i--) {
            char curr = s.charAt(i);
            k%=len;
            if(Character.isDigit(curr)) {
                len/=(curr-'0');
            } else {
                if(k==0)
                    return ""+curr;
                len--;
            }
        }
        return "";
    }
}