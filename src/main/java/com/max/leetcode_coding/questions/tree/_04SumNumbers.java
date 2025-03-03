package com.max.leetcode_coding.questions.tree;

public class _04SumNumbers {

  private int ans = 0;

  public int sumNumbers(TreeNode root) {
    doSumNumbers(root, 0);
    return ans;
  }

  private void doSumNumbers(TreeNode node, int cur) {
    if (node == null) {
      return;
    }
    cur = cur * 10 + node.val;
    if (node.left == node.right) {
      ans += cur;
      return;
    }
    doSumNumbers(node.left, cur);
    doSumNumbers(node.right, cur);
  }

}
