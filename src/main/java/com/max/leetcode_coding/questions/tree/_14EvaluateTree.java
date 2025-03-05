package com.max.leetcode_coding.questions.tree;

public class _14EvaluateTree {

  public boolean evaluateTree(TreeNode root) {
    if (root.left == root.right) {
      return root.val != 0;
    }
    if (root.val == 2) {
      return evaluateTree(root.left) || evaluateTree(root.right);
    } else {
      return evaluateTree(root.left) && evaluateTree(root.right);
    }
  }

}
