package com.max.leetcode_coding.questions.linked;

public class _25SwapNodes {

  public static void main(String[] args) {
    ListNode head = swapNodes(
        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
    System.out.println("head = " + head);
    ListNode head2 = new ListNode(55,
        new ListNode(60,
            new ListNode(78,
                new ListNode(53,
                    new ListNode(93,
                        new ListNode(37,
                            new ListNode(31,
                                new ListNode(4,
                                    new ListNode(61,
                                        new ListNode(11,
                                            new ListNode(13,
                                                new ListNode(51,
                                                    new ListNode(34,
                                                        new ListNode(83,
                                                            new ListNode(24,
                                                                new ListNode(96,
                                                                    new ListNode(5,
                                                                        new ListNode(77,
                                                                            new ListNode(1,
                                                                                new ListNode(67))))))))))))))))))));

    head2 = swapNodes2(head2, 1);
    System.out.println("head2 = " + head2);

  }

  public static ListNode swapNodes(ListNode head, int k) {
    ListNode prev = head;
    for (int i = k; i > 1; i--) {
      prev = prev.next;
    }
    int firstVal = prev.val;
    ListNode next = prev;
    ListNode cur = head;
    while (next.next != null) {
      next = next.next;
      cur = cur.next;
    }
    int secondVal = cur.val;
    cur.val = firstVal;
    prev.val = secondVal;
    return head;
  }

  public static ListNode swapNodes2(ListNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode(-1, head);
    // k可能越过链表的中点，这个情况下需要选择k的对称点作为k值
    int len = getLinkedListLength(head);
    if (k > len - k) {
      k = len - k + 1;
    }
    ListNode prev = dummy;
    ListNode prevLeft = head;
    for (int i = k; i > 1; i--) {
      prev = prev.next;
      prevLeft = prevLeft.next;
    }
    ListNode next = prevLeft;
    ListNode cur = dummy;
    ListNode curRight = head;
    while (next.next != null) {
      next = next.next;
      cur = cur.next;
      curRight = curRight.next;
    }
    ListNode curNext = curRight.next;
    // 相邻的特例
    if (prevLeft.next == curRight) {
      prev.next = curRight;
      curRight.next = prevLeft;
      prevLeft.next = curNext;
    }
    // 要交换的节点为同一节点的特例排除，直接结束
    else if (prevLeft != curRight) {
      prev.next = curRight;
      curRight.next = prevLeft.next;
      cur.next = prevLeft;
      prevLeft.next = curNext;
    }
    return dummy.next;
  }

  private static int getLinkedListLength(ListNode head) {
    int count = 0;
    while (head != null) {
      head = head.next;
      count++;
    }
    return count;
  }

}
