package com.max.leetcode_coding.questions.linked;

public class _36MergeKLists {

  public static void main(String[] args) {

    ListNode[] lists = new ListNode[]{new ListNode(1, new ListNode(4, new ListNode(5))), new ListNode(1, new ListNode(3, new ListNode(4))), new ListNode(2, new ListNode(6))};
    ListNode result = mergeKLists(lists);
    System.out.println("result = " + result);

  }

  public static ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    int len = lists.length;
    return mergeSort(lists, 0, len);
  }

  private static ListNode mergeSort(ListNode[] lists, int left, int right) {
    int dif = right - left;
    if (dif == 1) {
      return lists[left];
    }
    int mid = left + dif / 2;
    ListNode l1 = mergeSort(lists, left, mid);
    ListNode l2 = mergeSort(lists, mid, right);
    return doMergeSort(l1, l2);
  }

  private static ListNode doMergeSort(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode();
    ListNode cur = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        ListNode next = l1.next;
        l1.next = cur.next;
        cur.next = l1;
        l1 = next;
        cur = cur.next;
      } else {
        ListNode next = l2.next;
        l2.next = cur.next;
        cur.next = l2;
        l2 = next;
        cur = cur.next;
      }
    }
    if (l1 != null) {
      cur.next = l1;
    }
    if (l2 != null) {
      cur.next = l2;
    }
    return dummy.next;
  }

}
