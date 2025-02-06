package com.max.leetcode_coding.questions.linked;

public class _03SortList {

  public static void main(String[] args) {
    ListNode listNode = sortList(
        new ListNode(3, new ListNode(-1, new ListNode(2, new ListNode(4)))));
    System.out.println("listNode = " + listNode);

  }

  // 自顶向下的做法
  public static ListNode sortList(ListNode head) {
    // 递归的退出条件
    if (head == null || head.next == null) {
      return head;
    }
    // 使用快慢指针，找到链表的中点，并断开
    ListNode head2 = findMid(head);
    // 分治
     head = sortList(head);
     head2 = sortList(head2);
    // 给两个单调不递减链表排序
    return mergeLists(head, head2);
  }

  private static ListNode mergeLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(111);
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    ListNode curr = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        // 或者直接写成`curr.next = l1;`
        curr.next = new ListNode(l1.val);
        l1 = l1.next;
      } else {
        curr.next = new ListNode(l2.val);
        l2 = l2.next;
      }
      curr = curr.next;
    }
    if (l1 == null) {
      curr.next = l2;
    }
    if (l2 == null) {
      curr.next = l1;
    }
    return dummy.next;
  }

  private static ListNode findMid(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    /*
      递归方法需要注意findMid方法里的while循环条件，
      按之前寻找中间点的的条件fast && fast->next，
      只有两个结点的情况下会导致无限递归，然后栈溢出
     */
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    ListNode head2 = slow.next;
    slow.next = null;
    return head2;
  }

}
