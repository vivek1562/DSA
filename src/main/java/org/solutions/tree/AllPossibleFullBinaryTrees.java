package org.solutions.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AllPossibleFullBinaryTrees {
    List<List<TreeNode>> dp;
    public List<TreeNode> allPossibleFBT(int n) {
        dp = new ArrayList<>();
        for(int i=0; i<=n; i++)
            dp.add(new ArrayList<>());
        return recursion(n);
    }

    public List<TreeNode> recursion (int n) {
        if(n%2 == 0)
            return new ArrayList<>();
        if(n==1) {
            return new ArrayList<TreeNode>(Arrays.asList(new TreeNode(0)));
        }

        if(!dp.get(n).isEmpty())
            return dp.get(n);

        List<TreeNode> result = new ArrayList<>();
        for(int i=1; i<n; i+=2) {
            List<TreeNode> left = recursion(i);
            List<TreeNode> right = recursion(n-i-1);
            for(TreeNode l : left) {
                for(TreeNode r : right) {
                    result.add(new TreeNode(0, l , r));
                }
            }
        }

        dp.set(n, result);
        return result;
    }

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
}
