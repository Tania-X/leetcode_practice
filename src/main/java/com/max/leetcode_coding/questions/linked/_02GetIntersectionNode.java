package com.max.leetcode_coding.questions.linked;

public class _02GetIntersectionNode {

  public static void main(String[] args) {


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

}
