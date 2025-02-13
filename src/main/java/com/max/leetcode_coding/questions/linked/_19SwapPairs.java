package com.max.leetcode_coding.questions.linked;

public class _19SwapPairs {

  public static void main(String[] args) {

  }

  public static ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode(-1, head);
    ListNode cur = dummy;
    while (cur.next != null && cur.next.next != null) {
      ListNode tmp = cur.next.next;
      cur.next.next = tmp.next;
      tmp.next = cur.next;
      cur.next = tmp;
      cur = cur.next.next;
    }
    return dummy.next;
  }

}
