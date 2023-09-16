class Solution {

    public int minimumEffortPath(int[][] heights) {

        int m = heights.length, n = heights[0].length;
        int[][] dist = new int[m][n];
        int[] dir = new int[]{0, 1, 0, -1, 0};

        for (int i = 0; i < m; i++) 
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0]-b[0]));

        pq.offer(new int[]{0, 0, 0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0], r = curr[1], c = curr[2];
            
            if (r == m - 1 && c == n - 1) 
                return d;

            for(int i = 0; i<dir.length-1; i++) {
                int r1 = r+dir[i], c1 = c+dir[i+1];
                if(r1<m && r1>=0 && c1<n && c1>=0) {
                    int newDist = Math.max(Math.abs(heights[r1][c1]-heights[r][c]), d);
                    if(newDist<dist[r1][c1]) {
                        dist[r1][c1] = newDist;
                        pq.offer(new int[] {newDist, r1, c1});
                    }
                }
            }
        }

        return 0;
    }

}