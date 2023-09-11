class Solution {
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        int[][] mem = new int[n][n];
        return count(0,n-1,s,mem);  
    }

    private int count(int i, int j, String s, int[][] mem) {
        if(i>j) return 0;

        if(i==j) return 1;

        if(mem[i][j]!=0) return mem[i][j];

        int num=0;

        if(s.charAt(i)==s.charAt(j)) {

            num=2*count(i+1,j-1,s,mem); //a....a add two ends to every inner palindorm, there are duplicates if ... has a...a
            //need to figure out how to count the two ends and avoid duplicates
            int left=i+1, right=j-1;
            while(left<=right&&s.charAt(left)!=s.charAt(i)) left++;
            while(left<=right&&s.charAt(right)!=s.charAt(i)) right--;
            //a...a...a...a
            if(left<right) num-=count(left+1,right-1,s,mem); //no need to add two ends to the palindomes between inner 2a
            else if(left==right) num+=1; //a...a...a, add aa
            else num+=2; //a...a, add a, aa
        } 
        else num=count(i+1,j,s,mem)+count(i,j-1,s,mem)-count(i+1,j-1,s,mem);

        return mem[i][j]=num<0?num+1000000007:num%1000000007;
    }
}