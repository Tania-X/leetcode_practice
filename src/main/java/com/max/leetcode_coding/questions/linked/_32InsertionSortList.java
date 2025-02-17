package com.max.leetcode_coding.questions.linked;

public class _32InsertionSortList {

  public static void main(String[] args) {
    ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
//    ListNode result = insertionSortList(head);
//    System.out.println("result = " + result);
    ListNode result2 = insertionSortList2(head);
    System.out.println("result2 = " + result2);


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

  // 尝试在原来链表上插入排序，需要维护lastSorted节点
  // 重要：不是维护候选节点的遍历，而是已排序最后一节点的遍历！维护前者可能在候选节点移动后链表成环或者断裂，维护后者则没有这个风险！
  public static ListNode insertionSortList2(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode(-1, head);
    ListNode lastSorted = head;
    while (lastSorted.next != null) {
      ListNode candidate = lastSorted.next;
      if (lastSorted.val < candidate.val) {
        lastSorted = lastSorted.next;
      } else {
        ListNode prev = dummy;
        while (prev.next.val < candidate.val) {
          prev = prev.next;
        }
        ListNode next = candidate.next;
        candidate.next = prev.next;
        prev.next = candidate;
        lastSorted.next = next;
      }
    }
    return dummy.next;
  }

}
