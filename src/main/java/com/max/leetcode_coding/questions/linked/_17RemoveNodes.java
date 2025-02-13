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
    if (head == null || head.next == null) {
      return head;
    }
    ListNode cur = head;
    ListNode ptr = null;
    while (cur.next != null) {
      ListNode tmp = cur.next;
      cur.next = ptr;
      ptr = cur;
      cur = tmp;
    }
    cur.next = ptr;
    return cur;
  }

  private static ListNode reverse2(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode cur = head;
    ListNode dummy = new ListNode(-1);
    while (cur != null) {
      ListNode temp = cur.next;
      cur.next = dummy.next;
      dummy.next = cur;
      cur = temp;
    }
    return dummy.next;
  }

}
