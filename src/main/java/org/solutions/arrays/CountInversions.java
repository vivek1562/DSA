package org.solutions.arrays;

import java.util.ArrayList;
import java.util.List;

public class CountInversions {
    public static long getInversions(long arr[], int n) {
        return mergeSort(arr, 0, n-1);
    }

    public static long mergeSort(long arr[], int s, int e) {
        long cnt = 0;
        if(s>=e)
            return cnt;
        int mid = s+(e-s)/2;
        cnt += mergeSort(arr, s, mid);
        cnt += mergeSort(arr, mid+1, e);
        cnt += merge(arr, s, e, mid);
        return cnt;
    }

    public static long merge(long[] arr, int l, int h, int mid) {
        List<Long> temp = new ArrayList<>();
        long cnt = 0;
        int i = l, j = mid+1;
        while(i<=mid && j<=h) {
            if(arr[i]<=arr[j]) {
                temp.add(arr[i]);
                i++;
            } else {
                temp.add(arr[j]);
                j++;
                cnt += mid-i+1;
            }
        }

        while(i<=mid) {
            temp.add(arr[i]);
            i++;
        }
        while(j<=h) {
            temp.add(arr[j]);
            j++;
        }

        for(int k = l; k<=h; k++) {
            arr[k] = temp.get(k-l);
        }

        return cnt;
    }
}
