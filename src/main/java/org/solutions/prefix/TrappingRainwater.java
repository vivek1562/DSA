package org.solutions.prefix;

public class TrappingRainwater {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int temp = 0;
        for(int i=0; i<n; i++) {
            if(height[i]>temp) {
                temp = height[i];
            }
            left[i] = temp;
        }
        temp = 0;
        for(int i=n-1; i>=0; i--) {
            if(height[i]>temp) {
                temp = height[i];
            }
            right[i] = temp;
        }
        int water = 0;
        for(int i=0; i<n; i++) {
            water += Math.max(Math.min(left[i], right[i]) - height[i], 0);
        }
        return water;
    }
}
