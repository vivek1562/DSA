package org.solutions;

import java.util.Arrays;

public class CountAllPossibleRoutes {
    int mod = (int)1e9+7;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        int[][] cache = new int[n][fuel+1];
        Arrays.stream(cache).forEach(row -> Arrays.fill(row, -1));
        return getCount(locations, start, finish, fuel, cache);
    }

    public int getCount(int[] locations, int curr, int finish, int fuel, int[][] cache) {

        if(curr>=locations.length || fuel<0)
            return 0;
        int count = 0;
        if(curr==finish) {
            count += 1;
        }

        if(cache[curr][fuel]!=-1)
            return cache[curr][fuel];

        for(int i=0; i<locations.length; i++) {
            if(i==curr)
                continue;
            count = (count+getCount(locations, i, finish, fuel-Math.abs(locations[curr]-locations[i]), cache))%mod;
        }

        return cache[curr][fuel] = count%mod;
    }

}
