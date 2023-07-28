package org.solutions.binarySearchTree;

public class LcaBst {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if((p.val >= root.val && q.val <= root.val) || (p.val <= root.val && q.val >= root.val))
            return root;
        if(p.val<=root.val)
            return lowestCommonAncestor(root.left, p, q);
        else
            return lowestCommonAncestor(root.right, p, q);
    }
}
