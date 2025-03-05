package com.max.leetcode_coding.questions.tree;

public class _15IsBST {

  // pre-order traversal
  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean isValidBST(TreeNode node, long left, long right) {
    if (node == null) {
      return true;
    }
    int x = node.val;
    return x < right && x > left && isValidBST(node.left, left, x) && isValidBST(node.right, x, right);
  }

}
