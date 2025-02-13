package com.max.leetcode_coding.questions.linked;

public class _17RemoveNodes {

  public static void main(String[] args) {
    ListNode listNode = removeNodes(
        new ListNode(5, new ListNode(2, new ListNode(13, new ListNode(3, new ListNode(8))))));
    System.out.println("listNode = " + listNode);

  }

  public static ListNode removeNodes(ListNode head) {
    ListNode tail = reverse(head);
    ListNode cur = tail;
    int maxVal = cur.val;
    while (cur.next != null) {
      if (maxVal > cur.next.val) {
        cur.next = cur.next.next;
      } else {
        maxVal = cur.next.val;
        cur = cur.next;
      }
    }
    return reverse2(tail);
  }

  private static ListNode reverse(ListNode head) {
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

  private static ListNode reverse2(ListNode head) {
    ListNode cur = head;
    ListNode dummy = new ListNode(-1);
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = dummy.next;
      dummy.next = cur;
      cur = next;
    }
    return dummy.next;
  }

}
