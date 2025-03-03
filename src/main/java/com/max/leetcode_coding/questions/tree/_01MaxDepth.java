package com.max.leetcode_coding.questions.tree;

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

  private static int ans = 0;

  public static int maxDepth2(TreeNode root) {
    dfs(root, 0);
    return ans;
  }

  private static void dfs(TreeNode root, int depth) {
    // base case
    if (root == null) {
      return;
    }
    depth++;
    ans = Math.max(ans, depth);
    dfs(root.left, depth);
    dfs(root.right, depth);
  }

}
