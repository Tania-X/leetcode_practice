package com.max.leetcode_coding.questions.tree;

public class _04SumNumbers {

  private int ans = 0;

  public int sumNumbers(TreeNode root) {
    doSumNumbers(root, 0);
    return ans;
  }

  private void doSumNumbers(TreeNode root, int cur) {
    if (root == null) {
      return;
    }
    cur = cur * 10 + root.val;
    if (root.left == root.right) {
      ans += cur;
      return;
    }
    doSumNumbers(root.left, cur);
    doSumNumbers(root.right, cur);
  }

}
