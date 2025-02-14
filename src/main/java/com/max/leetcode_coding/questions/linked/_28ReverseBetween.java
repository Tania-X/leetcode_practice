package com.max.leetcode_coding.questions.linked;

public class _28ReverseBetween {

  public static void main(String[] args) {

  }

  public static ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode dummy = new ListNode(-1, head);
    ListNode cur = dummy;
    for (int i = 1; i < left; i++) {
      cur = cur.next;
    }
    ListNode p0 = cur;
    cur = p0.next;
    ListNode prev = null;
    for (int i = 0; i < right - left + 1; i++) {
      ListNode nxt = cur.next;
      cur.next = prev;
      prev = cur;
      cur = nxt;
    }
    p0.next.next = cur;
    p0.next = prev;
    return dummy.next;
  }

}
