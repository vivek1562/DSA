package org.solutions.arrays;

import java.util.ArrayList;
import java.util.List;

public class ReversePairs {
    public int reversePairs(int[] arr) {
        return mergeSort(arr, 0, arr.length-1);
    }

    public int mergeSort(int[] arr, int l ,int r) {
        int count = 0;
        if(l>=r)
            return count;
        int mid = l+(r-l)/2;
        count += mergeSort(arr, l ,mid);
        count += mergeSort(arr, mid+1, r);
        count += countPairs(arr, l, mid, r);
        merge(arr, l, mid, r);
        return count;
    }

    public int countPairs(int[] arr, int l , int mid, int r) {
        int c=0, right = mid+1;
        for(int i=l; i<=mid; i++) {
            while(right<=r && (long)arr[i]>(long)2*arr[right]) {
                right++;
            }
            c += right-(mid+1);
        }
        return c;
    }

    public void merge(int[] arr, int l, int mid, int r) {
        List<Integer> temp = new ArrayList<>();
        int k = mid+1, m = l;
        while(m<=mid && k<=r) {
            if(arr[m]>arr[k]) {
                temp.add(arr[k]);
                k++;
            } else {
                temp.add(arr[m]);
                m++;
            }
        }

        while(m<=mid) {
            temp.add(arr[m]);
            m++;
        }
        while(k<=r) {
            temp.add(arr[k]);
            k++;
        }
        for(int i=l; i<=r; i++) {
            arr[i] = temp.get(i-l);
        }
    }
}
