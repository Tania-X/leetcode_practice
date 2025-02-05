package com.max.leetcode_coding.questions.linked;

import java.util.ArrayDeque;
import java.util.Deque;

public class _09AddTwoNumbers {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9)));
    ListNode l2 = new ListNode(9);
//    ListNode result = addTwoNumbers(l1, l2);
    ListNode result2 = addTwoNumbers2(l1, l2);
//    System.out.println("result = " + result);
    System.out.println("result2 = " + result2);

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
        nextBit = false;
      }
    } else if (la == null) {
      nextBit = dealTails(lb, nextBit, ptr);
    }
    else {
      nextBit = dealTails(la, nextBit, ptr);
    }
    if (nextBit) {
      ptr = result;
      while (ptr.next != null) {
        ptr = ptr.next;
      }
      ptr.next = new ListNode(1);
    }
    // 将结果链表反转
    return reverseAndCount(result.next);
  }

  private static boolean dealTails(ListNode curr, boolean nextBit, ListNode ptr) {
    ptr.next = curr;
    while (ptr.next != null) {
      ptr.next.val = nextBit ? ptr.next.val + 1 : ptr.next.val;
      if (ptr.next.val >= 10) {
        ptr.next.val -= 10;
        nextBit = true;
      } else {
        nextBit = false;
      }
      ptr = ptr.next;
    }
    return nextBit;
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

  // 使用栈+头插法实现，简单多了
  public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    Deque<ListNode> stack1 = new ArrayDeque<>();
    Deque<ListNode> stack2 = new ArrayDeque<>();
    while (l1 != null) {
      stack1.push(l1);
      l1 = l1.next;
    }
    while (l2 != null) {
      stack2.push(l2);
      l2 = l2.next;
    }
    int carry = 0;
    ListNode result = new ListNode(-1);
    while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
      int val1 = stack1.isEmpty() ? 0 : stack1.pop().val;
      int val2 = stack2.isEmpty() ? 0 : stack2.pop().val;
      int val = val1 + val2 + carry;
      carry = val / 10;
      val = val % 10;
      ListNode cur = new ListNode(val);
      cur.next = result.next;
      result.next = cur;
    }
    return result.next;
  }

}
