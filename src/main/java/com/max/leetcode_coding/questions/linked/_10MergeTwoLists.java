package com.max.leetcode_coding.questions.linked;

public class _10MergeTwoLists {

  public static void main(String[] args) {

    ListNode result = mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))), new ListNode(1, new ListNode(3, new ListNode(4))));
    System.out.println("result = " + result);

  }

  public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null) {
      return list2;
    }
    if (list2 == null) {
      return list1;
    }
    ListNode result = new ListNode(-111);
    ListNode temp = result;
    while (list1 != null && list2 != null) {
      if (list1.val <= list2.val) {
        temp.next = list1;
        list1 = list1.next;
      } else {
        temp.next = list2;
        list2 = list2.next;
      }
      temp = temp.next;
    }
    if (list1 == null) {
      temp.next = list2;
    }
    if (list2 == null) {
      temp.next = list1;
    }
    return result.next;
  }

}
