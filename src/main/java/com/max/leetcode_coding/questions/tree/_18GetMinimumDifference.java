package com.max.leetcode_coding.questions.tree;

public class _18GetMinimumDifference {

  private int ans = Integer.MAX_VALUE;

  private int pre = Integer.MIN_VALUE / 2;

  public int getMinimumDifference(TreeNode root) {
    dfs(root);
    return ans;
  }

  // in-order traversal works best
  private void dfs(TreeNode node) {
    if (node == null) {
      return;
    }
    dfs(node.left);
    int x = node.val;
    ans = Math.min(ans, x - pre);
    pre = x;
    dfs(node.right);
  }

}
