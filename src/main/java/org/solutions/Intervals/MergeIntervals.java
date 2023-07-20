package org.solutions.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0]-b[0]));
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for(int i=1; i<intervals.length; i++) {
            int[] toInsert = new int[1];
            int[] currLast = ans.get(ans.size()-1);
            if(intervals[i][0]<=currLast[1]) {
                currLast[1] = Math.max(currLast[1], intervals[i][1]);
            } else {
                ans.add(intervals[i]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
