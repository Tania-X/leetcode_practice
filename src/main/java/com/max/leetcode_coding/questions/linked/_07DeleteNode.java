package com.max.leetcode_coding.questions.linked;

public class _07DeleteNode {

  public static void main(String[] args) {


  }

  public static ListNode deleteNode(ListNode head, int val) {
    if (head.val == val) {
      return head.next;
    }
    ListNode pl = head;
    ListNode pr = head;
    while (pr.next != null) {
      pr = pr.next;
      if (pr.val != val) {
        pl = pl.next;
      } else {
        pl.next = pr.next;
        pr.next = null;
        return head;
      }
    }
    return null;
  }

}
