package org.solutions.queue;

import java.util.PriorityQueue;

public class KClosestToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0]*b[0]+b[1]*b[1], a[0]*a[0]+a[1]*a[1]));
        for(int[] p : points) {
            pq.add(p);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.toArray(new int[k][]);
    }
}
