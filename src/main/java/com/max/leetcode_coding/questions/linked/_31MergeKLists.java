package com.max.leetcode_coding.questions.linked;

public class _31MergeKLists {

  public static void main(String[] args) {

    ListNode[] lists = new ListNode[]{new ListNode(1, new ListNode(4, new ListNode(5))), new ListNode(1, new ListNode(3, new ListNode(4))), new ListNode(2, new ListNode(6))};
    ListNode result = mergeKLists(lists);
    System.out.println("result = " + result);


  }

  public static ListNode mergeKLists(ListNode[] lists) {
    int len = lists.length;
    if (len == 0) {
      return null;
    }
    ListNode ans = lists[0];
    for (int i = 1; i < len; i++) {
      ListNode cur = lists[i];
      ans = mergeTwoLists(ans, cur);
    }
    return ans;
  }

  private static ListNode mergeTwoLists(ListNode p0, ListNode pi) {
    ListNode dummy = new ListNode();
    ListNode cur = dummy;
    while (p0 != null && pi != null) {
      ListNode next;
      if (p0.val <= pi.val) {
        next = p0.next;
        p0.next = null;
        cur.next = p0;
        p0 = next;
      } else {
        next = pi.next;
        pi.next = null;
        cur.next = pi;
        pi = next;
      }
      cur = cur.next;
    }
    if (p0 == null) {
      cur.next = pi;
    }
    if (pi == null) {
      cur.next = p0;
    }
    return dummy.next;
  }

}
