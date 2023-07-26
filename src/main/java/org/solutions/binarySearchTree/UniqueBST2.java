package org.solutions.binarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBST2 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode l, TreeNode r) {
          this.val = val;
          left = l;
          right = r;
      }
  }

    public List<TreeNode> generateTrees(int n) {
        return recur(1, n);
    }

    public List<TreeNode> recur(int s, int e) {
        List<TreeNode> answer = new ArrayList<>();
        if(s>e) {
            answer.add(null);
            return answer;
        }
        for(int i=s; i<=e; i++) {
            List<TreeNode> left = recur(s, i-1);
            List<TreeNode> right = recur(i+1, e);
            for(TreeNode l : left)
                for(TreeNode r : right) {
                    TreeNode node = new TreeNode(i, l, r);
                    answer.add(node);
                }
        }
        return answer;
    }

}
