package com.max.leetcode_coding.questions.linked;

public class _29ReverseKGroup {

  public static void main(String[] args) {

    ListNode result = reverseKGroup(
        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
    System.out.println("result = " + result);

  }

  public static ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode(-1, head);
    ListNode nxt = dummy.next;
    int count = 0;
    ListNode p0 = dummy;
    // 也可以先遍历head链表，计算其长度，在while循环里，每循环一次减去一次k
    while (nxt != null) {
      nxt = nxt.next;
      if (++count == k) {
        count = 0;
        ListNode cur = p0.next;
        ListNode prev = null;
        for (int i = 0; i < k; i++) {
          ListNode next = cur.next;
          cur.next = prev;
          prev = cur;
          cur = next;
        }
        // 该节点需要暂存为下一次循环的p0指针
        ListNode next = p0.next;
        p0.next.next = cur;
        p0.next = prev;
        p0 = next;
      }
    }
    return dummy.next;
  }

}
