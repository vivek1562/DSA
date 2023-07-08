package org.solutions;

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> m = new HashMap<>();
        for(char task : tasks) {
            m.put(task, m.getOrDefault(task, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->(b-a));
        pq.addAll(m.values());

        int answer = 0;
        while(!pq.isEmpty()) {
            int time=0;
            List<Integer> tempQ = new ArrayList<>();
            for(int i=0; i<n+1; i++) {
                if(!pq.isEmpty()) {
                    tempQ.add(pq.poll()-1);
                    time++;
                }
            }
            for(int toBeDone : tempQ) {
                if(toBeDone != 0)
                    pq.add(toBeDone);
            }
            answer += pq.isEmpty() ? time : n+1;
        }

        return answer;
    }
}
