class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visBus = new HashSet<>();
        Map<Integer, List<Integer>> m = new HashMap<>();

        int j=0;
        for(int[] route : routes) {
            for(int i=0; i<route.length; i++) {
                m.computeIfAbsent(route[i], k -> new ArrayList<>());
                m.get(route[i]).add(j);
            }
            j++;
        }
        
        if(source==target)
            return 0;

        q.offer(new int[]{source, 0});

        while(!q.isEmpty()) {
            int sz = q.size();
            while(sz-->0) {
                int[] curr = q.poll();
                if(curr[0]==target)
                    return curr[1];
                for(int bus : m.get(curr[0])) {
                    if(visBus.contains(bus))
                        continue;
                    visBus.add(bus);
                    for(int nbr : routes[bus]) {
                        q.offer(new int[]{nbr, curr[1]+1});
                    }
                }
            }
        }

        return -1;
    }
}