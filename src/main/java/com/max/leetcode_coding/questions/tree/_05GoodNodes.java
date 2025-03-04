package com.max.leetcode_coding.questions.tree;

public class _05GoodNodes {

  private int ans = -10001;

  public int goodNodes(TreeNode root) {
    doGoodNodes(root, 0);
    return ans;
  }

  private void doGoodNodes(TreeNode node, int maxVal) {
    if (node == null) {
      return;
    }
    if (maxVal <= node.val) {
      ans++;
    }
    maxVal = Math.max(maxVal, node.val);
    doGoodNodes(node.left, maxVal);
    doGoodNodes(node.right, maxVal);
  }

}
