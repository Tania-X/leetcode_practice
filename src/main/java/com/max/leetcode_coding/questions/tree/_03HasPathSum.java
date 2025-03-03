package com.max.leetcode_coding.questions.tree;

public class _03HasPathSum {

  public boolean hasPathSum(TreeNode root, int targetSum) {
    return dfs(root, targetSum);
  }

  private boolean dfs(TreeNode node, int target) {
    if (node == null) {
      return false;
    }
    if (node.left == node.right) {
      return target == node.val;
    }
    return dfs(node.left, target - node.val) || dfs(node.right, target - node.val);
  }

}
