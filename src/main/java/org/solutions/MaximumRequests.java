package org.solutions;

public class MaximumRequests {
    int answer = 0;

    public int maximumRequests(int n, int[][] requests) {
        int[] indegree = new int[n];
        backtrack(requests, indegree, 0, 0);
        return answer;
    }

    public void backtrack(int[][] requests, int[] indegree, int i, int count) {
        if(i >= requests.length) {
            for(int nodeValue : indegree) {
                if(nodeValue != 0)
                    return;
            }
            answer = Math.max(answer, count);
            return;
        }

        //pick
        int oldOut = indegree[requests[i][0]];
        int oldIn = indegree[requests[i][1]];
        indegree[requests[i][0]]--;
        indegree[requests[i][1]]++;
        backtrack(requests, indegree, i+1, count+1);
        indegree[requests[i][0]] = oldOut;
        indegree[requests[i][1]] = oldIn;

        //not pick
        backtrack(requests, indegree, i+1, count);
    }
}
