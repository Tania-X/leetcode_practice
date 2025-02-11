package com.max.leetcode_coding.questions.sort;

import java.util.Arrays;

public class _03OddEvenSort {

  public static void main(String[] args) {
    int[] result = sortEvenOdd(new int[]{4, 1, 2, 3});
    System.out.println("result = " + Arrays.toString(result));
  }

  public static int[] sortEvenOdd(int[] nums) {
    int len = nums.length;
    if (len <= 2) {
      return nums;
    }
    int maxOddIdx;
    int maxEvenIdx;
    if (len % 2 == 0) {
      maxOddIdx = len - 1;
      maxEvenIdx = len - 2;
    } else {
      maxOddIdx = len - 2;
      maxEvenIdx = len - 1;
    }
    for (int i = maxEvenIdx; i >= 0; i -= 2) {
      for (int j = 0; j < i; j += 2) {
        if (nums[j] >= nums[i]) {
          swap(nums, i, j);
        }
      }
    }
    for (int i = maxOddIdx; i >= 0; i -= 2) {
      for (int j = 1; j < i; j += 2) {
        if (nums[j] <= nums[i]) {
          swap(nums, i, j);
        }
      }
    }
    return nums;
  }

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}
