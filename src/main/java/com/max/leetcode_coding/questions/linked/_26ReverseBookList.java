package com.max.leetcode_coding.questions.linked;

import java.util.ArrayDeque;
import java.util.Deque;

public class _26ReverseBookList {

  public static void main(String[] args) {

  }

  // 使用栈
  public static int[] reverseBookList(ListNode head) {
    Deque<Integer> stack = new ArrayDeque<>();
    while (head != null) {
      stack.push(head.val);
      head = head.next;
    }
    int len = stack.size();
    int[] ans = new int[len];
    for (int i = 0; i < len; i++) {
      ans[i] = stack.pop();
    }
    return ans;
  }

  // 链表翻转 + 遍历
  public static int[] reverseBookList2(ListNode head) {
    int count = 0;
    ListNode prev = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
      count++;
    }
    int[] ans = new int[count];
    int idx = 0;
    while (prev != null) {
      ans[idx++] = prev.val;
      prev = prev.next;
    }
    return ans;
  }

}
