class Solution {
    int k = (int)1e9+7;

    public int numberOfWays(String corridor) {
        long ans=1;
        int n=corridor.length(), seatCount=0, cnt=0;
        char[] c = corridor.toCharArray();
        for(char ch : c) {
            if(ch=='S')
                seatCount++;
        }
        if(seatCount==0 || seatCount%2!=0)
            return 0;
        for(int i=0; i<n; i++) {
            if(c[i]=='S')
                cnt++;
            if(cnt==2) {
                int cp=1;
                i++;
                while(i<n && c[i]=='P') {
                    cp = (cp+1)%k;
                    i++;
                }
                if(i==n)
                    break;
                ans = (ans*cp)%k;
                i--;
                cnt=0;
            }
        }

        return (int)ans;
    }
}