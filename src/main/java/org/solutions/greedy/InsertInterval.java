package org.solutions.greedy;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> answer = new ArrayList<>();
        int i=0;

        while(i<intervals.length) {
            if(newInterval[0] > intervals[i][1]) {
                answer.add(intervals[i]);
            } else if(newInterval[1] < intervals[i][0]) {
                break;
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
            i++;
        }
        answer.add(newInterval);
        while(i<intervals.length) {
            answer.add(intervals[i]);
            i++;
        }

        return answer.toArray(new int[answer.size()][]);
    }
}
