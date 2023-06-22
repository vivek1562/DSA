package org.example;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class MakeArrayIncreasingSolution {

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        Map<Pair<Integer, Integer>, Integer> cache = new HashMap<>();
        int minOperations = recursion(arr1, arr2, 0, Integer.MIN_VALUE, cache);
        return  minOperations == Integer.MAX_VALUE-1 ? -1 : minOperations;
    }

    public int recursion(int[] arr1, int[] arr2, int currIndex, int prev, Map<Pair<Integer, Integer>, Integer> cache) {
        if(currIndex>=arr1.length)
            return 0;
        if(cache.get(new Pair<>(currIndex, prev)) != null) {
            return cache.get(new Pair<>(currIndex, prev));
        }
        int justGreaterIndex, choice1 =  Integer.MAX_VALUE-1, choice2 = Integer.MAX_VALUE-1;

        if(arr1[currIndex]>prev) {
            choice1 = recursion(arr1, arr2, currIndex+1, arr1[currIndex], cache);
        }

        justGreaterIndex = upperBoundUtil(arr2, prev);

        if(justGreaterIndex != arr2.length) {
            choice2 = 1 + recursion(arr1, arr2, currIndex+1, arr2[justGreaterIndex], cache);
        }

        cache.put(new Pair<>(currIndex, prev), Math.min(choice1, choice2));

        return Math.min(choice1, choice2);
    }

    public int upperBoundUtil(int[] arr, int target) {
        int lo = 0, hi = arr.length-1, mid;

        while(lo<=hi) {
            mid = lo+(hi-lo)/2;
            if(arr[mid]>target) {
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }

        return lo;
    }

}