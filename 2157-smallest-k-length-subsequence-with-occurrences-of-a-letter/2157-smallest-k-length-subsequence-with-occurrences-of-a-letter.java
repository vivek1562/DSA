class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        int extraLetter = (int)s.chars().filter(ch -> ch==letter).count() - repetition, n = s.length(), remove = n-k;
        StringBuilder st = new StringBuilder();

        for(int i=0; i<n; i++) {
            while(st.length()>0 && st.charAt(st.length()-1)>s.charAt(i) && remove>0) {
                if(st.charAt(st.length()-1)==letter) {
                    if(extraLetter==0)
                        break;
                    else
                        extraLetter--;
                }
                st.deleteCharAt(st.length()-1);
                remove--;
            }
            st.append(s.charAt(i));
        }

        int i=0;
        StringBuilder ans = new StringBuilder();
        while(ans.length()<k) {
            if(st.charAt(i) != letter && (ans.length()+Math.max(0, repetition) >= k)) {
                i++;
                continue;
            }
            if(st.charAt(i) == letter)
                repetition--;
            ans.append(st.charAt(i));
            i++;     
        }

        return ans.toString();
    }
}