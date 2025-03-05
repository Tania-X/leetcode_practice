package com.max.leetcode_coding.questions.tree;

public class _15IsBST {

  // pre-order traversal
  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean isValidBST(TreeNode node, long left, long right) {
    if (node == null) {
      return true;
    }
    int x = node.val;
    return x < right && x > left && isValidBST(node.left, left, x) && isValidBST(node.right, x,
        right);
  }

  private long pre = Long.MIN_VALUE;

  // in-order traversal
  public boolean isValidBST2(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (!isValidBST2(root.left) || root.val <= pre) {
      return false;
    }
    pre = root.val;
    return isValidBST2(root.right);
  }

  // post-order traversal
  public boolean isValidBST3(TreeNode root) {
    return dfs(root)[1] != Long.MAX_VALUE;
  }

  private long[] dfs(TreeNode node) {
    // attention here: we return such an array in order that the caller knows it's null, and it quickly works through
    if (node == null) {
      return new long[]{Long.MAX_VALUE, Long.MIN_VALUE};
    }
    long[] left = dfs(node.left);
    long[] right = dfs(node.right);
    int x = node.val;
    if (x <= left[1] || x >= right[0]) {
      return new long[]{Long.MIN_VALUE, Long.MAX_VALUE};
    }
    return new long[]{Math.min(left[0], x), Math.max(right[1], x)};
  }

}
