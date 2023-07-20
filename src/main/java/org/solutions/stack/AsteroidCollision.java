package org.solutions.stack;

import java.util.Stack;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> s = new Stack<>();
        int i=1;
        s.push(asteroids[0]);
        while(i<n) {
            int top, curr = asteroids[i], flag=0;
            while(!s.isEmpty()) {
                top = s.peek();
                flag=1;
                if(top>0 && curr<0) {
                    if(Math.abs(top) > Math.abs(curr))
                        curr = top;
                    else if(Math.abs(top) == Math.abs(curr))
                        curr = 0;
                    s.pop();
                } else {
                    if(curr!=0)
                        s.push(curr);
                    break;
                }
            }
            if(flag==0 || s.isEmpty()) {
                if(curr!=0)
                    s.push(curr);
            }
            i++;
        }

        return s.stream().mapToInt(j -> j).toArray();
    }
}
