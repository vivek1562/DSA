package org.solutions.hashing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeastBricks {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> boundariesAtX = new HashMap<>();
        int rowSum = 0;
        for(List<Integer> row : wall) {
            int x = 0;
            for(int brick : row) {
                x += brick;
                boundariesAtX.put(x, boundariesAtX.getOrDefault(x, 0)+1);
            }
            rowSum = x;
        }
        int ans = 0;
        boundariesAtX.remove(rowSum);
        for(int val : boundariesAtX.values()) {
            ans = Math.max(ans, val);
        }

        return wall.size()-ans;
    }
}

