package org.solutions.stack;
;

import javafx.util.Pair;

import java.util.Stack;

public class DailyTemperaturesStack {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length, i;
        int[] answer = new int[n];
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        i = n-1;
        while(i>=0) {
            while(!stack.isEmpty() && stack.peek().getKey() <= temperatures[i]) {
                stack.pop();
            }
            answer[i] = !stack.isEmpty() && stack.peek().getKey() > temperatures[i] ? stack.peek().getValue() - i : 0;
            stack.push(new Pair<>(temperatures[i], i));
            i--;
        }
        return answer;
    }
}
