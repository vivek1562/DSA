package org.solutions.binarySearch;

import java.util.Arrays;

public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = Arrays.stream(piles).max().getAsInt(), mid;
        while(lo<=hi) {
            mid = lo + (hi-lo)/2;
            if(canEat(piles, mid, h)) {
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }
        return lo;
    }

    public static boolean canEat(int[] piles, int k, int h) {
        int time = 0;
        for(int i=0; i<piles.length; i++) {
            time += piles[i]%k!=0 ? (piles[i]/k)+1 : piles[i]/k;
            if(time>h)
                return false;
        }
        return true;
    }
}
