package com.max.leetcode_coding.questions.linked;

public class _18MergeInBetween {

  public static void main(String[] args) {


  }

  public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
    ListNode l1 = list1;
    int c = b - a;
    while (a-- > 1) {
      l1 = l1.next;
    }
    ListNode l2 = l1;
    while (c-- > -2) {
      l2 = l2.next;
    }
    l1.next = list2;
    while (list2.next != null) {
      list2 = list2.next;
    }
    list2.next = l2;
    return list1;
  }

}
