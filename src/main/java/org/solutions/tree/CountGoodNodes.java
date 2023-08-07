package org.solutions.tree;

public class CountGoodNodes {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public int goodNodes(TreeNode root) {
        return count(root, Integer.MIN_VALUE);
    }

    public int count(TreeNode root, int currMax) {
        if(root == null) {
            return 0;
        }
        int answer = 0;
        if(root.val < currMax) {
            answer += count(root.left, currMax) + count(root.right, currMax);
            return answer;
        }
        return answer += 1 + count(root.left, root.val) + count(root.right, root.val);
    }
}
