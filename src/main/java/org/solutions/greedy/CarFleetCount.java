package org.solutions.greedy;

import java.util.Arrays;

public class CarFleetCount {
    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] positionTimeArray = new double[n][2];
        for(int i=0; i<n; i++) {
            positionTimeArray[i][0] = position[i];
            positionTimeArray[i][1] = (double) (target-position[i])/speed[i];
        }
        Arrays.sort(positionTimeArray, (a, b) -> Double.compare(a[0], b[0]));

        int fleetCount = 0, i = n-1;
        double prevTime = 0;
        while(i>=0) {
            if(positionTimeArray[i][1]>prevTime) {
                prevTime = positionTimeArray[i][1];
                fleetCount++;
            }
            i--;
        }

        return fleetCount;
    }
}
