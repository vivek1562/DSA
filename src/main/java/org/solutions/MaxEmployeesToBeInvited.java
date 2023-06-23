package org.solutions;

import java.util.LinkedList;
import java.util.Queue;

public class MaxEmployeesToBeInvited {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length, maxCycle = 0, cycleOfTwo = 0;
        int[] indegree = new int[n];
        int[] dp = new int[n];

        for (int j : favorite) indegree[j]++;

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(indegree[i]==0)
                q.offer(i);
        }
        while(!q.isEmpty()) {
            int curr = q.poll();
            dp[favorite[curr]] = Math.max(1+dp[curr], dp[favorite[curr]]);
            if(--indegree[favorite[curr]]==0)
                q.offer(favorite[curr]);
        }

        boolean[] visited = new boolean[n];
        for(int i=0; i<n ;i++) {
            if(indegree[i]!=0) {
                int length = 0;
                while(!visited[i]) {
                    length++;
                    visited[i] = true;
                    i = favorite[i];
                }
                if(length == 2) {
                    cycleOfTwo += 2 + dp[i] + dp[favorite[i]];
                } else {
                    maxCycle = Math.max(maxCycle, length);
                }
            }
        }

        return Math.max(maxCycle, cycleOfTwo);
    }
}
