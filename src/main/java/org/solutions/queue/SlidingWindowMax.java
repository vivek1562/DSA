package org.solutions.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        int i, n=nums.length;

        for(i=0; i<k; i++) {
            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }
        ans.add(nums[dq.peekFirst()]);

        for(; i<n; i++) {
            while(!dq.isEmpty() && dq.peekFirst()<=i-k)
                dq.pollFirst();
            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
            ans.add(nums[dq.peekFirst()]);
        }

        return ans.stream().mapToInt(p -> p).toArray();
    }
}
