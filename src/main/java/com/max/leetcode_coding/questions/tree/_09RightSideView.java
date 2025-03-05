package com.max.leetcode_coding.questions.tree;

import java.util.ArrayList;
import java.util.List;

public class _09RightSideView {

  private int curMaxDepth = 0;

  private final List<Integer> ans = new ArrayList<>();

  public List<Integer> rightSideView(TreeNode root) {
    doRightSideView(root, 1);
    return ans;
  }

  private void doRightSideView(TreeNode node, int curDepth) {
    // base case
    if (node == null) {
      return;
    }
    if (curDepth > curMaxDepth) {
      ans.add(node.val);
      curMaxDepth++;
    }
    // ensure traverse right side before left side to fulfill right side view requirements
    doRightSideView(node.right, curDepth + 1);
    doRightSideView(node.left, curDepth + 1);
  }

}
