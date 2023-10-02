class Solution {
    public boolean winnerOfGame(String colors) {
        int n=colors.length(), i=1, a=0, b=0;
        while(i<n-1) {
            if(colors.charAt(i)==colors.charAt(i-1) && colors.charAt(i)==colors.charAt(i+1)) {
                if(colors.charAt(i)=='A')
                    a++;
                else
                    b++;
            }
            i++;
        }
        return a>b;
    }
}