package com.max.leetcode_coding.questions.linked;

public class _01ReverseLinkedNode {

  public static void main(String[] args) {
    ListNode listNode = new ListNode(1,
        new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
    ListNode result = reverseList(listNode);
    while (result != null) {
      System.out.println("result.val = " + result.val);
      result = result.next;
    }

  }

  public static ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode pl = head;
    ListNode pr = head;
    ListNode h = new ListNode();
    while (pr.next != null) {
      pr = pr.next;
      pl.next = h.next;
      h.next = pl;
      pl = pr;
    }
    pl.next = h.next;
    h.next = pl;
    return h.next;
  }

}
