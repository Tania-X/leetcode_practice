package com.max.leetcode_coding.questions.linked;

import java.util.Arrays;

public class _33SplitListToParts {

  public static void main(String[] args) {
    ListNode[] results = splitListToParts(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8,new ListNode(9,new ListNode(10)))))))))), 3);
    System.out.println("results = " + Arrays.toString(results));


  }

  public static ListNode[] splitListToParts(ListNode head, int k) {
    ListNode[] ans = new ListNode[k];
    int listLength = getLinkedListLength(head);
    int height = listLength / k;
    int diff = listLength % k;
    if (diff != 0)  {
      height++;
    }
    int count = 0;
    ListNode cur = head;
    for (int i = 0; i < k; i ++) {
      int localHeight = height;
      if (diff != 0 && count >= diff) {
        localHeight--;
      }
      for (int j = 1; j < localHeight; j++) {
        if (cur != null) {
          cur = cur.next;
        }
      }
      if (cur == null) {
        ans[i] = null;
      } else {
        ListNode next = cur.next;
        cur.next = null;
        ans[i] = head;
        head = next;
        cur = next;
      }
      count++;
    }
    return ans;
  }

  private static int getLinkedListLength(ListNode head) {
    int ans = 0;
    ListNode cur = head;
    while (cur != null) {
      ans++;
      cur = cur.next;
    }
    return ans;
  }

}
