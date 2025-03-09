package com.max.leetcode_coding.questions.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _19ClosestNodes {

  private int left = -1;

  private int right = -1;

  public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
    List<List<Integer>> ans = new ArrayList<>();
    for (Integer query : queries) {
      left = -1;
      right = -1;
      int[] result = figureResult(root, query);
      ans.add(List.of(result[0], result[1]));
    }
    return ans;
  }

  private int[] figureResult(TreeNode node, Integer target) {
    int[] ans = new int[]{left, right};
    if (node == null) {
      ans[0] = Math.max(left, -1);
      ans[1] = Math.max(right, -1);
      return ans;
    }
    int x = node.val;
    if (x == target) {
      ans[0] = x;
      ans[1] = x;
      return ans;
    } else if (x < target) {
      left = x;
      return figureResult(node.right, target);
    } else {
      right = x;
      return figureResult(node.left, target);
    }
  }

}
