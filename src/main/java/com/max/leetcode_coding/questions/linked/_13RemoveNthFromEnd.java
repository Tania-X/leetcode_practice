package com.max.leetcode_coding.questions.linked;

public class _13RemoveNthFromEnd {

  public static void main(String[] args) {
    ListNode result = removeNthFromEnd(
        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 5);
    System.out.println("result = " + result);
  }

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(-1, head);
    ListNode cur = dummy;
    while (n != 0) {
      cur = cur.next;
      n--;
    }
    ListNode pre = dummy;
    while (cur.next != null) {
      cur = cur.next;
      pre = pre.next;
    }
    pre.next = pre.next.next;
    return dummy.next;
  }

}
