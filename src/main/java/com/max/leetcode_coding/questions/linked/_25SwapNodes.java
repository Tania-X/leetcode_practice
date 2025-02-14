package com.max.leetcode_coding.questions.linked;

public class _25SwapNodes {

  public static void main(String[] args) {
    ListNode head = swapNodes(
        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
    System.out.println("head = " + head);

  }

  public static ListNode swapNodes(ListNode head, int k) {
    ListNode prev = head;
    for (int i = k; i > 1; i--) {
      prev = prev.next;
    }
    int firstVal = prev.val;
    ListNode next = prev;
    ListNode cur = head;
    while (next.next != null) {
      next = next.next;
      cur = cur.next;
    }
    int secondVal = cur.val;
    cur.val = firstVal;
    prev.val = secondVal;
    return head;
  }

}
