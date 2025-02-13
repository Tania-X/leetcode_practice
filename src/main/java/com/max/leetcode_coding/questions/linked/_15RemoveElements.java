package com.max.leetcode_coding.questions.linked;

public class _15RemoveElements {

  public static void main(String[] args) {


  }

  public static ListNode removeElements(ListNode head, int val) {
    if (head == null) {
      return null;
    }
    ListNode dummy = new ListNode(-1, head);
    ListNode cur = dummy;
    while (cur.next != null) {
      if (cur.next.val == val) {
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
      }
    }
    return dummy.next;
  }

}
