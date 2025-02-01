package com.max.leetcode_coding.questions.linked;

public class _05DetectCycle {

  public static void main(String[] args) {


  }

  public static ListNode detectCycle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    ListNode ptr = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        while (slow != ptr) {
          slow = slow.next;
          ptr = ptr.next;
        }
        return ptr;
      }
    }
    return null;
  }

}
