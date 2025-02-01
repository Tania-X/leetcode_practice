package com.max.leetcode_coding.questions.linked;

public class _06ReverseList {

  public static void main(String[] args) {


  }

  // 没有头结点的方式
  // 可以对比`01`节点
  public static ListNode reverseList(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }

}
