package org.solutions.backtracking;

public class FindMinimumTimeToFinishAllJobs {
    int answer = Integer.MAX_VALUE;

    public int minimumTimeRequired(int[] jobs, int k) {
        int[] work = new int[k];
        //Arrays.sort(jobs, Comparator.reverseOrder());
        helper(jobs, k, 0, work);
        return answer;
    }

    public void helper(int[] jobs, int k, int i, int[] work) {
        if(i>=jobs.length) {
            int currMax = 0;
            for(int w : work) {
                currMax = Math.max(w, currMax);
            }
            answer = Math.min(currMax, answer);
            return;
        }

        for(int j=0; j<k; j++) {
            work[j]+=jobs[i];
            helper(jobs, k, i+1, work);
            work[j]-=jobs[i];
            if(work[j]==0)
                break;
        }
    }
}
