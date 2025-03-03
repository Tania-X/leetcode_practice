package com.max.leetcode_coding.questions.binarySearch;

import java.util.Arrays;

public class _03SuccessfulPairs {

  public static void main(String[] args) {
    int[] results = successfulPairs(new int[]{3, 1, 2}, new int[]{8, 5, 8}, 16);
    System.out.println("results = " + Arrays.toString(results));

  }

  public static int[] successfulPairs(int[] spells, int[] potions, long success) {
    int[] pairs = new int[spells.length];
    // 对potions数组排序，从左往右从小到大
    sort(potions);
    int n = potions.length;
    for (int i = 0; i < spells.length; i++) {
      // 找到spells数组当前元素想要`成功`的最小目标值
      long target = success / spells[i] + (success % spells[i] == 0 ? 0 : 1);
      // 对potions数组进行二分查找
      int index = lowerBound(potions, target);
      if (index == n) {
        pairs[i] = 0;
      } else {
        pairs[i] = n - index;
      }
    }
    return pairs;
  }

  public static int lowerBound(int[] nums, long target) {
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

  public static void sort(int[] nums) {
    int n = nums.length;
    int[] sup = new int[n];
    mergeSort(nums, 0, n - 1, sup);
  }

  public static void mergeSort(int[] nums, int left, int right, int[] sup) {
    if (left < right) {
      int mid = left + (right - left) / 2;
      mergeSort(nums, left, mid, sup);
      mergeSort(nums, mid + 1, right, sup);
      doMergeSort(nums, left, mid, right, sup);
    }
  }

  public static void doMergeSort(int[] nums, int left, int mid, int right, int[] sup) {
    int i = left;
    int j = mid + 1;
    int k = 0;
    while (i <= mid && j <= right) {
      if (nums[i] <= nums[j]) {
        sup[k++] = nums[i++];
      } else {
        sup[k++] = nums[j++];
      }
    }
    while (i <= mid) {
      sup[k++] = nums[i++];
    }
    while (j <= right) {
      sup[k++] = nums[j++];
    }
    System.arraycopy(sup, 0, nums, left, k);
  }

}
