class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length, ans = n, i=1;
        while(i<n) {
          if(ratings[i]==ratings[i-1]) {
            i++;
            continue;
          }

          int peak = 0;
          while(ratings[i]>ratings[i-1]) {
            peak++;
            ans += peak;
            i++;
            if(i==n)
              return ans;
          }

          int valley=0;
          while(i<n && ratings[i]<ratings[i-1]) {
            valley++;
            ans += valley;
            i++;
          }

          ans -= Math.min(peak, valley);
        }
        return ans;
    }
}