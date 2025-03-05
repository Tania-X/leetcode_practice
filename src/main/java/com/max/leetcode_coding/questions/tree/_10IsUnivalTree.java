package com.max.leetcode_coding.questions.tree;

public class _10IsUnivalTree {

  public boolean isUnivalTree(TreeNode root) {
    return doIsUnivalTree(root.left, root.val) && doIsUnivalTree(root.right, root.val);
  }

  private boolean doIsUnivalTree(TreeNode node, int uniVal) {
    if (node == null) {
      return true;
    }
    return node.val == uniVal && doIsUnivalTree(node.left, uniVal) && doIsUnivalTree(node.right, uniVal);
  }
}
