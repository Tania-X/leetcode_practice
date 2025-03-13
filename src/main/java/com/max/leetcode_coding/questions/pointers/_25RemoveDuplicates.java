package com.max.leetcode_coding.questions.pointers;

public class _25RemoveDuplicates {

  public static void main(String[] args) {
    int result = removeDuplicates(new int[]{1, 1, 1, 2, 2, 3});
    System.out.println("result = " + result);
  }

  // emulate stack
  public static int removeDuplicates(int[] nums) {
    int n = nums.length;
    int stackSize = 2;
    for (int i = 2; i < n; i++) {
      if (nums[i] != nums[stackSize - 2]) {
        nums[stackSize++] = nums[i];
      }
    }
    return Math.min(n, stackSize);
  }

}
