package com.max.leetcode_coding.questions.linked;

public class _11DeleteDuplicates {

  public static void main(String[] args) {
    ListNode result = deleteDuplicates(new ListNode(1, new ListNode(2, new ListNode(2))));
    System.out.println("result = " + result);
  }

  public static ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode ans = new ListNode(-1, head);
    ListNode pl = ans;
    ListNode pm = ans;
    ListNode pr = head;
    ListNode rev = pl;
    int count = 0;
    while (pr.next != null) {
      pr = pr.next;
      if (pr.val == pm.val) {
        count++;
      } else {
        pm = pr;
        if (count != 0) {
          pl.next = pr;
          rev = pl;
          count = 0;
        } else {
          pl = pl.next;
        }
      }
    }
    if (pl.val == pr.val) {
      pl = rev;
      pl.next = null;
    }
    return ans.next;
  }

}
