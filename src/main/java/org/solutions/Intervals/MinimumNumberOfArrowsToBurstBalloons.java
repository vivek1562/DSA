package org.solutions.Intervals;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int n = points.length;
        int count = 1, currArrow = points[0][1];
        for(int i=1; i<n; i++) {
            if(points[i][0] > currArrow) {
                count++;
                currArrow = points[i][1];
            }
        }
        return count;
    }
}
