package com.max.leetcode_coding.questions.tree;

public class _16SearchBST {

  // pre-order traversal(but terminated if matched)
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

  // in-order traversal(but terminated if matched)
  public TreeNode searchBST2(TreeNode root, int val) {
    if (root == null) {
      return null;
    }
    TreeNode left = searchBST2(root.left, val);
    if (left != null && left.val == val) {
      return left;
    }
    if (root.val == val) {
      return root;
    }
    return searchBST2(root.right, val);
  }

  // post-order traversal(but terminated if matched)
  public TreeNode searchBST3(TreeNode root, int val) {
    if (root == null) {
      return null;
    }
    TreeNode left = searchBST3(root.left, val);
    if (left != null && left.val == val) {
      return left;
    }
    TreeNode right = searchBST3(root.right, val);
    if (right != null && right.val == val) {
      return right;
    }
    return root.val == val ? root : null;
  }

  // employ property of BST to squeeze cost
  public TreeNode searchBST4(TreeNode root, int val) {
    if (root == null || root.val == val) {
      return root;
    }
    return root.val < val ? searchBST4(root.right, val) : searchBST4(root.left, val);
  }

  // search by iterate
  public TreeNode searchBST5(TreeNode root, int val) {
    while (root != null && root.val != val) {
      root = root.val < val ? root.right : root.left;
    }
    return root;
  }

}
