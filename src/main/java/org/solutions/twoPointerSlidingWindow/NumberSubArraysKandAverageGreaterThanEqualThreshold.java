package org.solutions.twoPointerSlidingWindow;

public class NumberSubArraysKandAverageGreaterThanEqualThreshold {
    public int numOfSubArrays(int[] arr, int k, int threshold) {
        int l=0, r=k, n=arr.length, runningSum=0, answer=0;
        for(int i=0; i<k; i++) {
            runningSum += arr[i];
        }
        if(runningSum/k>=threshold)
            answer++;
        while(r<n) {
            runningSum += arr[r];
            runningSum -= arr[l];
            r++;
            l++;
            if(runningSum/k>=threshold)
                answer++;
        }
        return answer;
    }
}
