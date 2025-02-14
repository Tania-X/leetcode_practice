package com.max.leetcode_coding.questions.linked;

public class _30DoubleIt {

  public static void main(String[] args) {


  }

  public static ListNode doubleIt(ListNode head) {
    head = reverseList(head);
    int carry = 0;
    ListNode cur = head;
    ListNode prev = null;
    while (cur != null) {
      prev = cur;
      int val = 2* cur.val + carry;
      carry = val / 10;
      val = val % 10;
      cur.val = val;
      cur = cur.next;
    }
    if (carry != 0) {
      prev.next = new ListNode(carry);
    }
    return reverseList(head);
  }

  private static ListNode reverseList(ListNode head) {
    ListNode cur = head;
    ListNode prev = null;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }

}
