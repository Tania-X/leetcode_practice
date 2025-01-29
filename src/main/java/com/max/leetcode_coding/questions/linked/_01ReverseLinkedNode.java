package com.max.leetcode_coding.questions.linked;

public class _01ReverseLinkedNode {

  public static void main(String[] args) {
    _01ListNode listNode = new _01ListNode(1,
        new _01ListNode(2, new _01ListNode(3, new _01ListNode(4, new _01ListNode(5, null)))));
    _01ListNode result = reverseList(listNode);
    while (result != null) {
      System.out.println("result.val = " + result.val);
      result = result.next;
    }

  }

  static class _01ListNode {

    int val;
    _01ListNode next;

    _01ListNode() {
    }

    _01ListNode(int val) {
      this.val = val;
    }

    _01ListNode(int val, _01ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  // 头插法
  public static _01ListNode reverseList(_01ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    _01ListNode pl = head;
    _01ListNode pr = head;
    _01ListNode h = new _01ListNode();
    while (pr.next != null) {
      pr = pr.next;
      pl.next = h.next;
      h.next = pl;
      pl = pr;
    }
    pl.next = h.next;
    h.next = pl;
    return h.next;
  }

}
