package com.max.leetcode_coding.questions.linked;

public class _09AddTwoNumbers {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
    ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
    ListNode result = addTwoNumbers(l1, l2);
    System.out.println("result = " + result);

  }

  // solve the problem by reversing the list
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    // 将`l1`与`l2`反转
    ListNode la = reverseAndCount(l1);
    ListNode lb = reverseAndCount(l2);
    // 从左往后，`l1`与`l2`元素，一位一位相加，往后加一
    boolean nextBit = false;
    ListNode result = new ListNode(-1, null);
    ListNode ptr = result;
    while (la != null && lb != null) {
      int newVal = la.val + lb.val + (nextBit ? 1 : 0);
      if (newVal >= 10) {
        newVal -= 10;
        nextBit = true;
      } else {
        nextBit = false;
      }
      ptr.next = new ListNode(newVal, null);
      ptr = ptr.next;
      la = la.next;
      lb = lb.next;
    }
    if (la == null && lb == null) {
      if (nextBit) {
        ptr.next = new ListNode(1);
      }
    } else if (la == null) {
      ptr.next = lb;
      lb.val = nextBit ? lb.val + 1 : lb.val;
    }
    else {
      ptr.next = la;
      la.val = nextBit ? la.val + 1 : la.val;
    }
    // 将该更长的链表反转
    return reverseAndCount(result.next);
  }

  private static ListNode reverseAndCount(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode temp = null;
    ListNode pl = head;
    ListNode pr = head;
    while (pr.next != null) {
      pr = pr.next;
      pl.next = temp;
      temp = pl;
      pl = pr;
    }
    pr.next = temp;
    return pr;
  }

}
