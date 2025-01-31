package com.max.leetcode_coding.questions.linked;

public class _04HasCycle {

  public static void main(String[] args) {

  }

  public static boolean hasCycle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        return true;
      }
    }
    return false;
  }

}
