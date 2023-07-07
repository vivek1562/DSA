package org.solutions;

import java.util.HashMap;
import java.util.Map;

public class MaximizeConfusionOfExam {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        Map<Character, Integer> count = new HashMap<>();
        count.put('T', 0);
        count.put('F', 0);
        int i = 0, j = 0, n = answerKey.length(), answer = Integer.MIN_VALUE;
        while(i<n && j<n) {
            count.put(answerKey.charAt(j), count.get(answerKey.charAt(j))+1);

            while(Math.min(count.get('T'), count.get('F'))>k) {
                count.put(answerKey.charAt(i), count.get(answerKey.charAt(i))-1);
                i++;
            }
            answer = Math.max(answer, j-i+1);
            j++;
        }
        return answer;
    }
}
