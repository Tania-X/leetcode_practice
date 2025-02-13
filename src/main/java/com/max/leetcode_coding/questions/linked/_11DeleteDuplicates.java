package com.max.leetcode_coding.questions.linked;

public class _11DeleteDuplicates {

  public static void main(String[] args) {
    ListNode result = deleteDuplicates(new ListNode(1, new ListNode(2, new ListNode(2))));
    System.out.println("result = " + result);
  }

  public static ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode cur = head;
    while (cur.next != null) {
      if (cur.val == cur.next.val) {
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
      }
    }
    return head;
  }

}
