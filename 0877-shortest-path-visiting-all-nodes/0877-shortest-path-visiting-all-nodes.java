class Solution {
    // class Node {
    //     int value;
    //     int mask;
    //     int dist;

    //     Node(int value, int mask, int dist) {
    //         this.value = value;
    //         this.mask = mask;
    //         this.dist = dist;   
    //     }
    // }

    public int shortestPathLength(int[][] graph) {
        
        int ans = 0, n = graph.length;
        Set<Pair<Integer, Integer>> s = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();

        //return if no nodes or [[]] blank only node
        if(n==0 || (n==1 && graph[0].length==0))
            return 0;

        for(int i=0; i<n; i++) {
            q.offer(new int[] {i, 1<<i});
            s.add(new Pair(i, 1<<i));
        }
        
        
        while(!q.isEmpty()) {
            int sz = q.size();
            ans++;
            while(sz-->0) {
                int[] curr = q.poll();
                int currNode = curr[0];
                int mask = curr[1];

                for(int node : graph[currNode]) {
                    int newMask = mask | 1<<node;
                    //if we check for answer after popping i.e. mask of currently popper element then won't need the [[]] case check
                    if(newMask == (1<<n)-1)
                        return ans;

                    if(!s.contains(new Pair(node, newMask))) {
                        q.offer(new int[] {node, newMask});
                        s.add(new Pair(node, newMask));
                    }
                }
            }
        }

        return ans;
    }
}