class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if(m>n)
            return findMedianSortedArrays(nums2, nums1);
            //binary serach is on number of elements picked so hi = m
        int l = 0, h = m;

        while(l<=h) {
            int countFrom1 = l+(h-l)/2;
            int countFrom2 = (m+n+1)/2-countFrom1; //total on left half - elements taken form nums1
            //left half
            int x1 = countFrom1==0 ? Integer.MIN_VALUE : nums1[countFrom1-1];
            int x2 = countFrom2==0 ? Integer.MIN_VALUE : nums2[countFrom2-1];

            //right half
            int y1 = countFrom1==m ? Integer.MAX_VALUE : nums1[countFrom1];
            int y2 = countFrom2==n ? Integer.MAX_VALUE : nums2[countFrom2];

            if(x1<=y2 && x2<=y1) {
                if((m+n)%2!=0)
                    return Math.max(x1, x2);
                else
                    return (Math.max(x1, x2) + Math.min(y1, y2))/2.0;
            } 
            else if(x1>y2)
                h = countFrom1-1;
            else
                l = countFrom1+1;
        }
        return -1.0;
    }
}