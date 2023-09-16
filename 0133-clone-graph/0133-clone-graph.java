/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> m = new HashMap<>();

    public Node cloneGraph(Node node) {
        dfs(node);
        return m.get(node);
    }

    void dfs(Node node) {
        if(node==null)
            return;
        if(m.containsKey(node))
            return;
        m.computeIfAbsent(node, k -> new Node(node.val));
        
        for(Node n : node.neighbors) {
            dfs(n);
            m.get(node).neighbors.add(m.get(n));
        }
    }
}