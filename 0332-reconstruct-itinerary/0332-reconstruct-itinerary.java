class Solution {

    LinkedList<String> ans;
    Map<String, PriorityQueue<String>> m;

    public List<String> findItinerary(List<List<String>> tickets) {
        ans = new LinkedList<>();
        m = new HashMap<>();
        for(List<String> t : tickets) {
            m.computeIfAbsent(t.get(0), k -> new PriorityQueue<>()).add(t.get(1));
        }
        dfs("JFK");
        return ans;
    }

    public void dfs(String key) {
        PriorityQueue<String> pq = m.get(key);
        while(pq != null && !pq.isEmpty()){
            String v = pq.poll();
            dfs(v);
        }
        ans.addFirst(key);
    }

}