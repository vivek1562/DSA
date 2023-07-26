package org.solutions.binarySearch;

import java.util.Arrays;

public class MinimumSpeedToArriveOnTime {
    public int minSpeedOnTime(int[] dist, double hour) {
        int hi = (int)Math.pow(10,7);
        int lo = 1, mid, answer = -1;
        while(lo<=hi) {
            mid = lo+(hi-lo)/2;
            if(check(mid, dist, hour)) {
                answer = mid;
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }
        return answer;
    }

    public boolean check(int speed, int[] dist, double hour) {
        double totalTime = 0;
        for(int d : dist) {
            totalTime += (double)d/speed;
            if(totalTime>hour)
                return false;
            totalTime = Math.ceil(totalTime);
        }
        return true;
    }
}
