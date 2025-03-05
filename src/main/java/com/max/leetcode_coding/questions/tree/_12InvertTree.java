package com.max.leetcode_coding.questions.tree;

public class _12InvertTree {

  public TreeNode invertTree(TreeNode root) {
    doInvertTree(root);
    return root;
  }

  private void doInvertTree(TreeNode node) {
    if (node == null) {
      return;
    }
    TreeNode tmp = node.left;
    node.left = node.right;
    node.right = tmp;
    doInvertTree(node.left);
    doInvertTree(node.right);
  }

}
