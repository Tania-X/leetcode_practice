package com.max.leetcode_coding.questions.linked;

public class _01ReverseLinkedNode {

  public static void main(String[] args) {
    ListNode listNode = new ListNode(1,
        new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
    ListNode result = reverseList(listNode);
    while (result != null) {
      System.out.println("result.val = " + result.val);
      result = result.next;
    }

  }

  // 有头结点的方式（假设这里的`h`是一个头结点，那么必须不断将新的元素插入`h`节点与`h`节点的下一个节点之间）
  // 可以对比`06`解答
  public static ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode pl = head;
    ListNode pr = head;
    ListNode h = new ListNode();
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
