package com.max.leetcode_coding.questions.linked;

public class _20RotateRight {

  public static void main(String[] args) {
    ListNode listNode = rotateRight(
        new ListNode(0, new ListNode(1, new ListNode(2))), 4);
    System.out.println("listNode = " + listNode);
  }

  public static ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null || k == 0) {
      return head;
    }
    // mod k; here len starts at 1, not 0
    int len = 1;
    ListNode cur = head;
    while (cur.next != null) {
      cur = cur.next;
      len++;
    }
    k = k % len;
    // split and combine
    int split = len - k;
    if (split == len) {
      return head;
    }
    cur.next = head;
    while (split-- > 0) {
      cur = cur.next;
    }
    ListNode ans = cur.next;
    cur.next = null;
    return ans;
  }

}
