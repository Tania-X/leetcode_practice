package com.max.leetcode_coding.questions.linked;

public class _27OddEvenList {

  public static void main(String[] args) {
    ListNode result = oddEvenList(
        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
    System.out.println("result = " + result);

  }

  // 拆成两个链表
  public static ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return head;
    }
    ListNode odd = new ListNode(-1);
    ListNode even = new ListNode(-1);
    ListNode cur = head;
    boolean isOdd = true;
    ListNode oddNext = odd;
    ListNode evenNext = even;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = null;
      if (isOdd) {
        oddNext.next = cur;
        oddNext = oddNext.next;
        isOdd = false;
      } else {
        evenNext.next = cur;
        evenNext = evenNext.next;
        isOdd = true;
      }
      cur = next;
    }
    oddNext.next = even.next;
    return odd.next;
  }

  // 在一个链表中倒腾
  public static ListNode oddEvenList2(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return head;
    }
    ListNode odd = head;
    ListNode even = head.next;
    ListNode evenEnd = even;
    while (odd.next != null && even.next != null) {
      odd.next = even.next;
      odd = odd.next;
      even.next = odd.next;
      even = even.next;
    }
    odd.next = evenEnd;
    return head;
  }

}
