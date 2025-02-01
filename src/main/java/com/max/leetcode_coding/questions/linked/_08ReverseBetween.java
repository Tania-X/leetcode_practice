package com.max.leetcode_coding.questions.linked;

public class _08ReverseBetween {

  public static void main(String[] args) {


  }

  public static ListNode reverseBetween(ListNode head, int left, int right) {
    if (left == right) {
      return head;
    }
    ListNode start = new ListNode();
    start.next = head;
    ListNode pl = start;
    int count = 0;
    while (count != left - 1) {
      pl = pl.next;
      count++;
    }
    ListNode pr = pl.next;
    ListNode ptr = pr;
    while (count < right) {
      ListNode temp = ptr.next;
      ptr.next = pl.next;
      pl.next = ptr;
      pr.next = temp;
      ptr = temp;
      count++;
    }
    return start.next;
  }

}
