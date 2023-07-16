package org.solutions.tree;


import java.util.*;

public class AllNodesAtKDistance {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Map<TreeNode, List<TreeNode>> adjList = new HashMap<>();
        createParentMap(root, null, adjList);
        Queue<TreeNode> q = new LinkedList();
        List<Integer> ans = new ArrayList();
        Set<TreeNode> seen = new HashSet();
        int c=0;
        q.offer(target);
        seen.add(target);
        while(!q.isEmpty()) {
            int size = q.size();
            if(c==k) {
                while(!q.isEmpty()) {
                    ans.add(q.poll().val);
                }
                return ans;
            }

            for(int i=0; i<size; i++) {
                TreeNode curr = q.poll();
                for(TreeNode neighbour : adjList.getOrDefault(curr, new ArrayList<>())) {
                    if(!seen.contains(neighbour)) {
                        q.offer(neighbour);
                        seen.add(neighbour);
                    }
                }
            }
            c++;
        }

        return ans;
    }

    public static void createParentMap(TreeNode root, TreeNode parent, Map<TreeNode, List<TreeNode>> adjList) {
        if(root==null)
            return;

        if(!adjList.containsKey(root)) {
            List<TreeNode> tempList = adjList.getOrDefault(root, new ArrayList<>());
            if(root.left!=null)
                tempList.add(root.left);
            if(root.right!=null)
                tempList.add(root.right);
            if(parent!=null)
                tempList.add(parent);
            adjList.put(root, tempList);
            createParentMap(root.left, root, adjList);
            createParentMap(root.right, root, adjList);
        }
    }
}
