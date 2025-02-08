package com.max.leetcode_coding.questions.sort;

import java.util.Arrays;

public class _11SortArray {

  public static void main(String[] args) {
    int[] result = sortArray(new int[]{2, -3, 1, 4});
    System.out.println("result = " + Arrays.toString(result));

  }

  // m1 归并排序
  public static int[] sortArray(int[] nums) {
    int len = nums.length;
    if (len == 0 || len == 1) {
      return nums;
    }
    int[] temp = new int[len];
    mergerSort(nums, temp, 0, len - 1);
    return nums;
  }

  public static void mergerSort(int[] nums, int[] temp, int l, int r) {
    if (l >= r) {
      return;
    }
    int m = l + (r - l) / 2;
    mergerSort(nums, temp, l, m);
    mergerSort(nums, temp, m + 1, r);
    int pl = l;
    int pr = m + 1;
    int count = 0;
    while (pl <= m && pr <= r) {
      if (nums[pl] <= nums[pr]) {
        temp[count++] = nums[pl++];
      } else {
        temp[count++] = nums[pr++];
      }
    }
    while (pl <= m) {
      temp[count++] = nums[pl++];
    }
    while (pr <= r) {
      temp[count++] = nums[pr++];
    }
    if (r - l + 1 >= 0)
      System.arraycopy(temp, 0, nums, l, r - l + 1);
  }

}
