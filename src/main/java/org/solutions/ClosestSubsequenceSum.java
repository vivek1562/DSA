package org.solutions;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ClosestSubsequenceSum {
    public int minAbsDifference(int[] nums, int goal) {
        Set<Integer> leftSet = new HashSet<>();
        TreeSet<Integer> rightSet = new TreeSet<>();
        generate(0, nums.length / 2, nums, 0, leftSet);
        generate(nums.length / 2, nums.length, nums, 0, rightSet);
        int ans = Math.abs(goal);
        for (int left : leftSet) {
            int right = goal - left;
            if (rightSet.contains(right)) {
                return 0;
            }
            Integer right1 = rightSet.lower(right);
            Integer right2 = rightSet.higher(right);
            if (right1 != null) {
                ans = Math.min(ans, Math.abs(left + right1 - goal));
            }
            if (right2 != null) {
                ans = Math.min(ans, Math.abs(left + right2 - goal));
            }
        }
        return ans;
    }

    public void generate(int pos, int stop, int[] nums, int sum, Set<Integer> set) {
        if (pos == stop) {
            set.add(sum);
            return;
        }
        generate(pos + 1, stop, nums, sum, set);
        generate(pos + 1, stop, nums, sum + nums[pos], set);
    }
}
