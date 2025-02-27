package com.max.leetcode_coding.binarySearch;

import java.util.Arrays;

public class _01SearchRange {

  public static void main(String[] args) {
    int[] result = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
    System.out.println("result = " + Arrays.toString(result));
  }

  public static int[] searchRange(int[] nums, int target) {
    int n = nums.length;
    int start = lowerBound3(nums, target);
    if (start == n || nums[start] != target) {
      return new int[]{-1, -1};
    }
    int end = lowerBound3(nums, target + 1) - 1;
    return new int[]{start, end};
  }

  // ( )
  private static int lowerBound(int[] nums, int target) {
    int left = -1;
    int right = nums.length;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] >= target) {
        right = mid + 1;
      } else {
        left = mid;
      }
    }
    return right;
  }

  // [ )
  private static int lowerBound2(int[] nums, int target) {
    int left = 0;
    int right = nums.length;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] >= target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  // [ ]
  private static int lowerBound3(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] >= target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

}
