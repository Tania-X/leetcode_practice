package com.max.leetcode_coding.questions.linked;

import java.util.ArrayDeque;
import java.util.Deque;

public class _23IsPalindrome {

  public static void main(String[] args) {
    ListNode head = new ListNode(1, new ListNode(2, new ListNode(2)));
    boolean palindrome = isPalindrome(head);
    System.out.println("palindrome = " + palindrome);
    boolean palindrome2 = isPalindrome2(head);
    System.out.println("palindrome = " + palindrome2);

  }

  // 借助栈实现，空间复杂度为o(n)，需要断开链表，反而复杂
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

  // 不考虑断开，空间复杂度为o(1)，无论长度为奇数还是偶数
  public static boolean isPalindrome2(ListNode head) {
    ListNode mid = findMid(head);
    ListNode head2 = reverse(mid);
    while (head2 != null) {
      if (head2.val != head.val) {
        return false;
      }
      head = head.next;
      head2 = head2.next;
    }
    return true;
  }

  private static ListNode reverse(ListNode head) {
    ListNode cur = head;
    ListNode tail = null;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = tail;
      tail = cur;
      cur = next;
    }
    return tail;
  }

  private static ListNode findMid(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

}
