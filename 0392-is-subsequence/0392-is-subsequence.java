class Solution {
    public boolean isSubsequence(String s, String t) {
        int m=s.length(),n=t.length();
        return recur(m,n,s,t);
    }

    boolean recur(int m,int n, String s, String t)
    {
        if(m==0)
            return true;
        if(n==0)
            return false;
        if(s.charAt(m-1)==t.charAt(n-1))
            return recur(m-1,n-1,s,t);
        return recur(m,n-1,s,t);
    }
    
}