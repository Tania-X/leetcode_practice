package com.max.leetcode_coding.questions.tree;

public class _02MinDepth {

  public static void main(String[] args) {

  }

  private static int ans = Integer.MAX_VALUE;

  public static int minDepth(TreeNode root) {
    dfs(root, 0);
    return ans == Integer.MAX_VALUE ? 0 : ans;
  }

  private static void dfs(TreeNode node, int depth) {
    if (node == null) {
      return;
    }
    depth++;
    if (node.left == null && node.right == null) {
      ans = Math.min(ans, depth);
    }
    dfs(node.left, depth);
    dfs(node.right, depth);
  }

}
