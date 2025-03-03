package com.max.leetcode_coding.tree;

public class _01MaxDepth {

  public static void main(String[] args) {

  }

  public static int maxDepth(TreeNode root) {
    // base case
    if (root == null) {
      return 0;
    }
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    return Math.max(left, right) + 1;
  }

}
