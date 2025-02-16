package com.max.leetcode_coding.questions.linked;

public class _32InsertionSortList {

  public static void main(String[] args) {
    ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
    ListNode result = insertionSortList(head);
    System.out.println("result = " + result);


  }

  // 利用了新的链表
  public static ListNode insertionSortList(ListNode head) {
    ListNode dummy = new ListNode();
    while (head != null) {
      ListNode cur = dummy;
      while (cur.next != null) {
        if (cur.next.val > head.val) {
          ListNode next = head.next;
          head.next = cur.next;
          cur.next = head;
          head = next;
          break;
        } else {
          cur = cur.next;
        }
      }
      if (cur.next == null) {
        ListNode next = head.next;
        head.next = null;
        cur.next = head;
        head = next;
      }
    }
    return dummy.next;
  }

  // 尝试在原来链表上插入排序

}
