package org.solutions.binarySearch;

public class FindIndexInMouthmainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int lo = 0, hi = n-1, mid;
        while(lo<=hi) {
            mid = lo+(hi-lo)/2;
            if(arr[mid+1]>arr[mid]) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        return lo;
    }
}
