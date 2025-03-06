package com.max.leetcode_coding.questions.tree;

public class _17RangeSumBST {

  private int sum = 0;

  public int rangeSumBST(TreeNode root, int low, int high) {
    doRangeSumBST(root, low, high);
    return sum;
  }

  private void doRangeSumBST(TreeNode node, int low, int high) {
    if (node == null) {
      return;
    }
    int x = node.val;
    if (x < low) {
      doRangeSumBST(node.right, low, high);
    } else if (x > high) {
      doRangeSumBST(node.left, low, high);
    } else {
      sum += x;
      doRangeSumBST(node.right, low, high);
      doRangeSumBST(node.left, low, high);
    }
  }

  public int rangeSumBST2(TreeNode root, int low, int high) {
    if (root == null) {
      return 0;
    }
    int x = root.val;
    int sum = x <= high && x >= low ? x : 0;
    if (x < low) {
      return rangeSumBST2(root.right, low, high);
    }
    if (x > high) {
      return rangeSumBST2(root.left, low, high);
    }
    return sum + rangeSumBST2(root.left, low, high) + rangeSumBST2(root.right, low, high);
  }

}
