package com.max.leetcode_coding.questions.pointers;

import java.util.Arrays;

public class _08MaximumProduct {

  public static void main(String[] args) {

  }

  public static int maximumProduct(int[] nums) {
    int len = nums.length;
    if (len == 3) {
      return nums[0] * nums[1] * nums[2];
    }
    Arrays.sort(nums);
    return Math.max(nums[0] * nums[1] * nums[len - 1], nums[len -3] * nums[len - 2] * nums[len - 1]);
  }

}
