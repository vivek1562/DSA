package org.solutions.twoPointerSlidingWindow;

public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int lMax = height[0], rMax = height[n-1], l = 1, r = n-2, answer = 0;

        while(l<=r) {
            if(lMax<rMax) {
                if(height[l]>lMax)
                    lMax = height[l];
                else
                    answer += lMax - height[l];
                l++;
            } else {
                if(height[r]>rMax)
                    rMax = height[r];
                else
                    answer += rMax - height[r];
                r--;
            }
        }

        return answer;
    }
}
