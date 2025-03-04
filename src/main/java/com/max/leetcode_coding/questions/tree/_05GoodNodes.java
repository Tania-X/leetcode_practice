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

  public int goodNodes2(TreeNode root) {
    return doGoodNodes2(root, -10001);
  }

  private int doGoodNodes2(TreeNode node, int maxVal) {
    if (node == null) {
      return 0;
    }
    int left = doGoodNodes2(node.left, Math.max(node.val, maxVal));
    int right = doGoodNodes2(node.right, Math.max(node.val, maxVal));
    return left + right + (maxVal <= node.val ? 1 : 0);
  }

}
