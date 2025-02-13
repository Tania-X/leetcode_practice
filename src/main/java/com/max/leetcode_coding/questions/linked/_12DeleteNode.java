package com.max.leetcode_coding.questions.linked;

public class _12DeleteNode {

  public static void main(String[] args) {

  }

  public static void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }

}
