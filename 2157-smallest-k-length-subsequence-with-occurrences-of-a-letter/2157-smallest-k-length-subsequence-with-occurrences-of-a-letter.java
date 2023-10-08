class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        int cnt = (int)s.chars().filter(ch -> ch==letter).count(), n = s.length(), remove = n-k, currCnt=0;
        StringBuilder st = new StringBuilder();

        for(int i=0; i<n; i++) {
            while(st.length()>0 && st.charAt(st.length()-1)>s.charAt(i) && (n-i+st.length())>k && (currCnt+cnt>repetition || st.charAt(st.length()-1)!=letter)) {
                char ch = st.charAt(st.length()-1);
                if(ch == letter) {
                    currCnt--;
                }
                st.deleteCharAt(st.length()-1);
            }
            if(st.length()<k && (s.charAt(i)==letter || k-st.length()>repetition-currCnt)) {
                st.append(s.charAt(i));
                if(s.charAt(i)==letter)
                    currCnt++;
            }
            if(s.charAt(i)==letter)
                cnt--;
        }

        return st.toString();
    }
}