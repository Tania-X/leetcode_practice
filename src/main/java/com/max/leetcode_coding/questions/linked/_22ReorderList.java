package com.max.leetcode_coding.questions.linked;

public class _22ReorderList {

  public static void main(String[] args) {
    reorderList(
        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
    System.out.println("listNode = " + "test");

  }

  public static void reorderList(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return;
    }
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode rev = slow.next;
    slow.next = null;
    ListNode cur = rev;
    ListNode tail = null;
    while (cur != null) {
      ListNode prev = cur.next;
      cur.next = tail;
      tail = cur;
      cur = prev;
    }
    rev = tail;
    cur = head;
    while (rev != null) {
      ListNode tmp = rev.next;
      rev.next = cur.next;
      cur.next = rev;
      rev = tmp;
      cur = cur.next.next;
    }
  }

}
