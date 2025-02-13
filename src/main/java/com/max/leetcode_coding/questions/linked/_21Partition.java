package com.max.leetcode_coding.questions.linked;

public class _21Partition {

  public static void main(String[] args) {


  }

  public static ListNode partition(ListNode head, int x) {
    ListNode dummy1 = new ListNode(-1);
    ListNode dummy2 = new ListNode(-1);
    ListNode smaller = dummy1, bigger = dummy2;
    ListNode cur = head;
    while (cur != null) {
      if (cur.val < x) {
        smaller.next = cur;
        cur = cur.next;
        smaller.next.next = null;
        smaller = smaller.next;
      } else {
        bigger.next = cur;
        cur = cur.next;
        bigger.next.next = null;
        bigger = bigger.next;
      }
    }
    smaller.next = dummy2.next;
    return dummy1.next;
  }

}
