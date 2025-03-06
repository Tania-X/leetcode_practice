package com.max.leetcode_coding.questions.tree;

public class _16SearchBST {

  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) {
      return null;
    }
    int x = root.val;
    if (x == val) {
      return root;
    }
    TreeNode left = searchBST(root.left, val);
    return left == null ? searchBST(root.right, val) : left;
  }

}
