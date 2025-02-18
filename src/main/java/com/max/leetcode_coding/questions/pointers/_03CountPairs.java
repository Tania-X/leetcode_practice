package com.max.leetcode_coding.questions.pointers;

import java.util.ArrayList;
import java.util.List;

public class _03CountPairs {

  public static void main(String[] args) {
    int result = countPairs(new ArrayList<>(List.of(-1, 1, 2, 3, 1)), 2);
    System.out.println("result = " + result);
  }

  public static int countPairs(List<Integer> nums, int target) {
    if (nums.size() == 1) {
     throw new IllegalArgumentException("INPUT ERROR");
    }
    sort(nums);
    int ans = 0;
    int len = nums.size();
    int left = 0;
    while (left < len - 1) {
      int right = left + 1;
      while (right < len && nums.get(left) + nums.get(right) < target) {
        ans++;
        right++;
      }
      left++;
    }
    return ans;
  }

  private static void sort(List<Integer> nums) {
    int size = nums.size();
    int[] sup = new int[size];
    mergeSort(nums, 0, size - 1, sup);
  }

  private static void mergeSort(List<Integer> nums, int left, int right, int[] sup) {
    if (left < right) {
      int mid = left + (right - left) / 2;
      mergeSort(nums, left, mid, sup);
      mergeSort(nums, mid + 1, right, sup);
      doMergeSort(nums, left, mid, right, sup);
    }
  }

  private static void doMergeSort(List<Integer> nums, int left, int mid, int right, int[] sup) {
    int k = 0;
    int i = left;
    int j = mid + 1;
    while (i <= mid && j <= right) {
      if (nums.get(i) <= nums.get(j)) {
        sup[k++] = nums.get(i++);
      } else {
        sup[k++] = nums.get(j++);
      }
    }
    while (i <= mid) {
      sup[k++] = nums.get(i++);
    }
    while (j <= right) {
      sup[k++] = nums.get(j++);
    }
    for (int l = 0; l < k; l++) {
      nums.set(left++, sup[l]);
    }
  }

}
