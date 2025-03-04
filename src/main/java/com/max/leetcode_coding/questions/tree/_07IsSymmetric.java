package com.max.leetcode_coding.questions.tree;

public class _07IsSymmetric {

  public boolean isSymmetric(TreeNode root) {
    return isSameTree(root.left, root.right);
  }

  private boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null || q == null) {
      return p == q;
    }
    return p.val == q.val && isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
  }

}
