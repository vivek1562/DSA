class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length, ans=0;
        Map<Integer, List<Integer>> m = new HashMap<>();
        for(int i=0; i<n; i++) {
            m.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Set<Integer> vis = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis.add(0);
        while(!q.isEmpty()) {
            int sz = q.size();
            while(sz-->0) {
                int curr = q.poll();
                if(curr==n-1)
                    return ans;
                if(curr-1>=0 && !vis.contains(curr-1)) {
                    q.offer(curr-1);
                    vis.add(curr-1);
                }
                if(curr+1<n && !vis.contains(curr+1)) {
                    q.offer(curr+1);
                    vis.add(curr+1);
                }
                for(int i : m.getOrDefault(arr[curr], new ArrayList<>())) {
                    if(!vis.contains(i)) {
                        q.offer(i);
                        vis.add(i);
                    }
                }
                m.remove(arr[curr]);
            }
            ans++;
        }

        return -1;
    }
}