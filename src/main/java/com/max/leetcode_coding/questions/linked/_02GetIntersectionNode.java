package com.max.leetcode_coding.questions.linked;

public class _02GetIntersectionNode {

  public static void main(String[] args) {
    ListNode headC = new ListNode(1, new ListNode(8, new ListNode(4, new ListNode(5))));
    ListNode headA = new ListNode(4, headC);
    ListNode headB = new ListNode(5, new ListNode(6, headC));
    ListNode intersectionNode = getIntersectionNode3(headA, headB);
    System.out.println("intersectionNode = " + intersectionNode);

  }

  // m1 分别接续着遍历A和B链表
  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    ListNode pa = headA;
    ListNode pb = headB;
    while (pa != pb) {
      pa = pa == null ? headB : pa.next;
      pb = pb == null ? headA : pb.next;
    }
    return pa;
  }

  // m2 分别获得A与B的长度，短的链表补足至二者等长，再次遍历即可
  public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    int lenA = getLinkedListLength(headA);
    int lenB = getLinkedListLength(headB);
    int len = lenA - lenB >= 0 ? lenA - lenB : -(lenA - lenB);
    ListNode head1 = headA;
    ListNode head2 = headB;
    if (lenA > lenB) {
      while (--len >= 0) {
        ListNode prev = new ListNode(-1);
        prev.next = head2;
        head2 = prev;
      }
    } else if (lenB > lenA) {
      while (--len >= 0) {
        ListNode prev = new ListNode(-1);
        prev.next = head1;
        head1 = prev;
      }
    }
    while (head1 != null) {
      if (head1 == head2) {
        return head1;
      } else {
        head1 = head1.next;
        head2 = head2.next;
      }
    }
    return null;
  }

  private static int getLinkedListLength(ListNode head) {
    ListNode cur = head;
    int ans = 0;
    while (cur != null) {
      ans++;
      cur = cur.next;
    }
    return ans;
  }

  // m3 遍历A链表，到达末尾时直接后接B链表，构造成寻找环链入环点的题型
  public static ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    ListNode cur = headA;
    while (cur.next != null) {
      cur = cur.next;
    }
    cur.next = headB;
    ListNode fast = headA;
    ListNode slow = headA;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      // 这里要判断的是快指针与慢指针相同的情况去做什么，而不是判断不同的情况去做什么
      if (fast == slow) {
        ListNode start = headA;
        while (start != slow) {
          start = start.next;
          slow = slow.next;
        }
        // 将链表结构断开
        cur.next = null;
        return start;
      }
    }
    // 将链表结构断开
    cur.next = null;
    return null;
  }

}
