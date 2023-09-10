package org.solutions.binarySearch;

import java.util.TreeSet;

public class MaxSumOfRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int target) {
        int r = matrix.length, c = matrix[0].length;

        //calculate prefix sum for each row
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(j!=0)
                    matrix[i][j] += matrix[i][j-1];
            }
        }

        TreeSet<Integer> s;
        int ans = Integer.MIN_VALUE;

        for(int c1=0; c1<c; c1++) {
            for(int c2 = c1; c2<c; c2++) {
                s = new TreeSet<>();    // used so that we can binary search for target in given set in logN
                int sum = 0;
                //s.add(0);
                for(int k=0; k<r; k++) {
                    sum += matrix[k][c2] - (c1>0 ? matrix[k][c1-1] : 0);
                    Integer smallestLargest = s.ceiling(sum-target);
                    if(smallestLargest != null)
                        ans = Math.max(ans, sum-smallestLargest);
                    s.add(sum);
                }
            }
        }

        return ans;
    }
}
