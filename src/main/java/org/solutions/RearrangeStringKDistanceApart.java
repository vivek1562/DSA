package org.solutions;

import java.util.*;
import java.util.stream.Collectors;

public class RearrangeStringKDistanceApart {
    public String rearrangeString(String str, int k) {

        if(k == 0) return str;
        int len = str.length();

        Map<Character, Integer> counts = new HashMap<>();
        for(char c : str.toCharArray()){
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(10, (p1, p2) -> {
            if(p1.value != p2.value) return p2.value - p1.value;
            else return  p1.key - p2.key; // to ensure the order of the chars with same count, they should show up in same order.
        });

        pq.addAll(counts.entrySet()
                        .stream()
                        .map(entry -> new Pair(entry.getKey(), entry.getValue()))
                        .collect(Collectors.toList()));

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            List<Pair> tmp = new ArrayList<>();// this is to avoid picking up same char in the same k-segment.
            // example str = aaabbbccd k = 4. This condition would trigger at sb = addarc.
            // There must be d unique characters in the PriorityQueue else it won't be possible to keep them k distance apart.
            int d = Math.min(k, len);
            for(int i=0; i< d; i++){
                if(pq.isEmpty()) return ""; // instead of returning we were adding to wait time in TaskScheduler problem;
                Pair p = pq.poll();
                sb.append(p.key);
                if(--p.value > 0) tmp.add(p);
                len--;
            }
            pq.addAll(tmp);
        }

        return sb.toString();

    }

    class Pair{
        char key;
        int value;
        Pair(char key, int value){
            this.key = key;
            this.value = value;
        }
    };
}
