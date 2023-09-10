package org.solutions.hashing;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubmatricesThatSumTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int r = matrix.length, c = matrix[0].length;

        //calculate prefix sum for each row
        for(int i=0; i<r; i++) {
            for(int j=1; j<c; j++) {
                matrix[i][j] += matrix[i][j-1];
            }
        }

        Map<Integer, Integer> m;
        int ans = 0;

        //fix 2 cols and iterate over rows. cache the result for all sum till ros to find submatrix with sum target in O(1)
        for(int c1=0; c1<c; c1++) {
            for(int c2 = c1; c2<c; c2++) {
                m = new HashMap<>();    //reset map for every different c1, c2 combination
                m.put(0, 1);
                int sum = 0;
                for(int k=0; k<r; k++) {
                    sum += matrix[k][c2] - (c1>0 ? matrix[k][c1-1] : 0);
                    ans += m.getOrDefault(sum-target, 0);
                    m.put(sum ,m.getOrDefault(sum, 0)+1);
                }
            }
        }

        return ans;
    }
}
