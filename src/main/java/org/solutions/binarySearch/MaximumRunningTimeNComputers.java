package org.solutions.binarySearch;

import java.util.Arrays;

public class MaximumRunningTimeNComputers {
    public long maxRunTime(int n, int[] batteries) {
        long totalCapacity = Arrays.stream(batteries).mapToLong(i->i).sum();
        long lo = 1, hi = totalCapacity/n, mid;
        while(lo<=hi) {
            mid = lo+(hi-lo)/2;
            if(check(batteries, mid, n)) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        return hi;
    }

    public boolean check(int[] batteries, long currTime, int n) {
        long targetMinutes = n*currTime;
        long maxAvailableCapacity = 0;
        for(int b : batteries) {
            maxAvailableCapacity += Math.min(b, currTime);
            if(maxAvailableCapacity>=targetMinutes)
                return true;
        }
        return false;
    }
}
