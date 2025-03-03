package com.max.leetcode_coding.questions.binarySearch;

public class _02MaximumCount {

  public static void main(String[] args) {
    int i = maximumCount(new int[]{-2, -1, -1, 1, 2, 3});
  }

  public static int maximumCount(int[] nums) {
    int negLen = 0, posLen = 0;
    int maxNeg = lowerBound(nums, 0) - 1;
    if (maxNeg >= 0 && nums[maxNeg] < 0) {
      negLen = maxNeg + 1;
    }
    int maxPos = lowerBound(nums, 1);
    if (maxPos != nums.length && nums[maxPos] > 0) {
      posLen = nums.length - 1 - maxPos + 1;
    }
    return Math.max(negLen, posLen);
  }

  // [ )
  public static int lowerBound(int[] nums, int target) {
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

}
