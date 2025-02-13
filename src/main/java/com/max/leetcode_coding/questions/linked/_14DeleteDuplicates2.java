package com.max.leetcode_coding.questions.linked;

public class _14DeleteDuplicates2 {

  public static void main(String[] args) {
    ListNode result = deleteDuplicates(new ListNode(1, new ListNode(2,
        new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5))))))));
    System.out.println("result = " + result);

  }

  public static ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode(-1, head);
    ListNode cur = dummy;
    while (cur.next != null && cur.next.next != null) {
      int val = cur.next.val;
      if (cur.next.next.val == val) {
        while (cur.next != null && cur.next.val == val) {
          cur.next = cur.next.next;
        }
      } else {
        cur = cur.next;
      }
    }
    return dummy.next;
  }

}
