package com.max.leetcode_coding.questions.tree;

public class _08IsBalanced {

  public boolean isBalanced(TreeNode root) {
    return doIsBalanced(root, 0) != -1;
  }

  private int doIsBalanced(TreeNode node, int depth) {
    // base case
    if (node == null) {
      return 0;
    }
    depth++;
    int left = doIsBalanced(node.left, depth);
    if (left == -1) {
      return -1;
    }
    int right = doIsBalanced(node.right, depth);
    if (right == -1 || Math.abs(right - left) > 1) {
      return -1;
    }
    return Math.max(left, right) + 1;
  }

}
