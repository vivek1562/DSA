class Solution {
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> email2id = new HashMap<>();
        UnionFind disjointSet = new UnionFind(accounts.size());

        //create a map where each email has a link to its parent and we merge the parents using disjoint set union
        for(int i=0; i<accounts.size(); i++) {
            List<String> emails = accounts.get(i);
            for(int j=1; j<emails.size(); j++) {
                if(email2id.containsKey(emails.get(j))) {
                    disjointSet.union(email2id.get(emails.get(j)), i);
                } else {
                    email2id.put(emails.get(j), i);
                }
            }
        }

        Map<Integer, Set<String>> person2emails = new HashMap<>(); //map of person id mapped to lis of their emails
        for(String email : email2id.keySet()) {
            Integer id = disjointSet.find(email2id.get(email));
            person2emails.computeIfAbsent(id, k -> new TreeSet<>()).add(email);
        }
        
        for(Integer personId : person2emails.keySet()) {
            LinkedList<String> list = new LinkedList<>(person2emails.get(personId));
            list.addFirst(accounts.get(personId).get(0));
            ans.add(list);
        }

        return ans;
    }

    public class UnionFind {
        int[] par;

        UnionFind(int size) {
            par = new int[size];
            for(int i=0; i<size; i++)
                par[i] = i;
        }
        
        int find(int node) {
            if(par[node]==node)
                return node;
            return par[node] = find(par[node]);
        }

        void union(int a, int b) {
            int parA = find(a);
            int parB = find(b);
            if(parA!=parB) {
                par[parA] = parB;
            }
        }
    }
}