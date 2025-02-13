package com.max.leetcode_coding.questions.linked;

import java.util.HashSet;
import java.util.Set;

public class _16ModifiedList {

  public static void main(String[] args) {
    int[] nums = new int[]{9, 2, 5};
    ListNode head = new ListNode(2, new ListNode(10, new ListNode(9)));
    ListNode listNode = modifiedList(nums, head);
    System.out.println("listNode = " + listNode);

  }

  // 如果不将`nums`数组转化为`set`，会超时，O(n^2) > O(n + m)
  public static ListNode modifiedList(int[] nums, ListNode head) {
    ListNode dummy = new ListNode(-1, head);
    ListNode cur = dummy;
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    while (cur.next != null) {
      if (set.contains(cur.next.val)) {
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
      }
    }
    return dummy.next;
  }

}
