package org.solutions.greedy;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);
        int answer = 0;
        int[] lastInterval = intervals[0];
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0]>=lastInterval[1]) {
                lastInterval = intervals[i];
            } else if(intervals[i][1]>lastInterval[1]) {
                answer++;
            } else {
                answer++;
                lastInterval = intervals[i];
            }
        }
        return answer;
    }
}
