package com.max.leetcode_coding.questions.linked;

public class _31MergeKLists {

  public static void main(String[] args) {

    ListNode[] lists = new ListNode[]{new ListNode(1, new ListNode(4, new ListNode(5))), new ListNode(1, new ListNode(3, new ListNode(4))), new ListNode(2, new ListNode(6))};
    ListNode result = mergeKLists(lists);
    System.out.println("result = " + result);

    ListNode result2 = mergeKLists2(lists);
    System.out.println("result2 = " + result2);


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

  public static ListNode mergeKLists2(ListNode[] lists) {
    int len = lists.length;
    if (len == 0) {
      return null;
    }
    return mergeTwoLists(lists, 0, len);
  }

  private static ListNode mergeTwoLists(ListNode[] lists, int l, int r) {
    int m = r - l;
    if (m == 1) {
      return lists[l];
    }
    ListNode l1 = mergeTwoLists(lists, l, l + m / 2);
    ListNode l2 = mergeTwoLists(lists, l + m / 2, r);
    return doMergeTwoList(l1, l2);
  }

  private static ListNode doMergeTwoList(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode();
    ListNode cur = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        cur.next = l1;
        l1 = l1.next;
      } else {
        cur.next = l2;
        l2 = l2.next;
      }
      cur = cur.next;
    }
    if (l1 == null) {
      cur.next = l2;
    }
    if (l2 == null) {
      cur.next = l1;
    }
    return dummy.next;
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
