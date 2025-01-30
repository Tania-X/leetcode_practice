package com.max.leetcode_coding.questions.linked;

public class _02GetIntersectionNode {

  public static void main(String[] args) {


  }

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

}
