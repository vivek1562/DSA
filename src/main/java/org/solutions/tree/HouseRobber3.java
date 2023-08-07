package org.solutions.tree;

import java.util.HashMap;

public class HouseRobber3 {
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
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> dp = new HashMap<>();
        return helper(root,1,dp);
    }

    public int helper(TreeNode curr, int flag, HashMap<TreeNode, Integer> dp) {

        if(curr==null)
            return 0;
        if(dp.containsKey(curr) && flag==1)
            return dp.get(curr);
        int r,not_r;

        not_r = Math.max(helper(curr.left,1,dp), helper(curr.left,0,dp)) + Math.max(helper(curr.right,1,dp),helper(curr.right,0,dp));

        r = flag == 1 ? curr.val + helper(curr.left,0,dp) + helper(curr.right,0,dp) : -1;

        if(flag == 1)
            dp.put(curr, Math.max(r, not_r));

        return Math.max(r, not_r);
    }
}
