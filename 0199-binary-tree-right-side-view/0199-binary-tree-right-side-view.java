/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> ans = new ArrayList<>();
    Set<Integer> vis = new HashSet<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    public void dfs(TreeNode root, int level) {
        if(root==null)
            return;

        if(!vis.contains(level)) {
            ans.add(root.val);
            vis.add(level);
        }

        dfs(root.right, level+1);
        dfs(root.left, level+1);
    }
}