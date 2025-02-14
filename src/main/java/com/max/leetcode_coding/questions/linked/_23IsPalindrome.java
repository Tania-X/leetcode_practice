package com.max.leetcode_coding.questions.linked;

import java.util.ArrayDeque;
import java.util.Deque;

public class _23IsPalindrome {

  public static void main(String[] args) {
    boolean palindrome = isPalindrome(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(1)))));
    System.out.println("palindrome = " + palindrome);

  }

  public static boolean isPalindrome(ListNode head) {
    Deque<Integer> stack = new ArrayDeque<>();
    ListNode mid = findMiddleNode(head, stack);
    while (mid != null) {
      if (stack.pop() != mid.val) {
        return false;
      }
      mid = mid.next;
    }
    return true;
  }

  private static ListNode findMiddleNode(ListNode head, Deque<Integer> stack) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      stack.push(slow.val);
      slow = slow.next;
      fast = fast.next.next;
    }
    if (fast != null) {
      slow = slow.next;
    }
    return slow;
  }

}
