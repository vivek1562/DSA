class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] ans = new int[people.length];

        Arrays.sort(flowers, (a, b) -> (a[0]-b[0]));
        for(int i=0; i<ans.length; i++) {
            ans[i] = Math.max(lowerBound(flowers, people[i]), 0);
        }

        Arrays.sort(flowers, (a, b) -> (a[1]-b[1]));
        for(int i=0; i<ans.length; i++) {
            ans[i] -= Math.max(upperBound(flowers, people[i])+1, 0);
        }

        return ans;
    }

    public int lowerBound(int[][] flowers, int target) {        //gives us the index of smallest element(flowers[0]) greater than the target. So index-0 == flowers bloomed
        int lo = 0, hi = flowers.length-1, mid = 0;

        while(lo<=hi) {                 
            mid = lo+(hi-lo)/2;
            if(flowers[mid][0]<=target) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        
        return lo;
    }

    public int upperBound(int[][] flowers, int target) {        //gives us the index of largest element(flowers[1]) smaller than the target
        int lo = 0, hi = flowers.length-1, mid = 0;

        while(lo<=hi) {
            mid = lo+(hi-lo)/2;
            if(flowers[mid][1]>=target) {
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }
        
        return hi;
    }
}