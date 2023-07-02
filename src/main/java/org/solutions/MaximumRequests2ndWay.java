package org.solutions;

public class MaximumRequests2ndWay {
    public int maximumRequests(int n, int[][] requests) {
        int[] indegree = new int[n];
        return backtrack(requests, indegree, 0);
    }

    public int backtrack(int[][] requests, int[] indegree, int i) {
        if(i >= requests.length) {
            for(int nodeValue : indegree) {
                if(nodeValue != 0)
                    return Integer.MIN_VALUE;
            }
            return 0;
        }

        //pick
        int oldOut = indegree[requests[i][0]];
        int oldIn = indegree[requests[i][1]];
        indegree[requests[i][0]]--;
        indegree[requests[i][1]]++;
        int take = 1 + backtrack(requests, indegree, i+1);
        indegree[requests[i][0]] = oldOut;
        indegree[requests[i][1]] = oldIn;

        //not pick
        int notTake = backtrack(requests, indegree, i+1);

        return Math.max(take, notTake);
    }
}
