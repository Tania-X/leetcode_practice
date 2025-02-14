package com.max.leetcode_coding.questions.linked;

public class _24PairSum {

  public static void main(String[] args) {
    int sum = pairSum(new ListNode(4, new ListNode(2, new ListNode(2, new ListNode(3)))));
    System.out.println("sum = " + sum);

  }

  public static int pairSum(ListNode head) {
    int maxSum = 0;
    ListNode head2 = divide(head);
    while (head2 != null) {
      maxSum = Math.max(maxSum, head.val + head2.val);
      head = head.next;
      head2 = head2.next;
    }
    return maxSum;
  }

  private static ListNode divide(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode prev = null;
    ListNode cur = slow;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }

}
