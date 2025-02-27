package com.max.leetcode_coding.binarySearch;

import java.util.Arrays;

public class _04CountFairPairs {

  public static void main(String[] args) {

  }

  // 其实不需要复制数组，下面的解答更好
  public static long countFairPairs(int[] nums, int lower, int upper) {
    long ans = 0;
    int[] sup = new int[nums.length];
    System.arraycopy(nums, 0, sup, 0, sup.length);
    Arrays.sort(sup);
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] * 2 >= lower && nums[i] * 2 <= upper) {
        count++;
      }
      int start = lowerBound(sup, lower - nums[i]);
      int end = lowerBound(sup, upper - nums[i] + 1) - 1;
      if (end >= start) {
        ans += end - start + 1;
      }
    }
    return ans / 2 - count;
  }

  public static int lowerBound(int[] nums, int target) {
    int left = -1;
    int right = nums.length;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] >= target) {
        right = mid;
      } else {
        left = mid;
      }
    }
    return right;
  }

  public static long countFairPairs2(int[] nums, int lower, int upper) {
    long ans = 0;
    Arrays.sort(nums);
    for (int j = 0; j < nums.length; j++) {
      // 保证 i < j
      int start = lowerBound(nums, j, lower - nums[j]);
      int end = lowerBound(nums, j, upper - nums[j] + 1) - 1;
      ans += end - start + 1;
    }
    return ans;
  }

  public static int lowerBound(int[] nums, int right, int target) {
    int left = -1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] >= target) {
        right = mid;
      } else {
        left = mid;
      }
    }
    return right;
  }

}
