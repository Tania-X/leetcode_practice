package com.max.leetcode_coding.questions.pointers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _05FourSum {

  public static void main(String[] args) {

    List<List<Integer>> lists = fourSum(new int[]{2, 2, 2, 2, 2}, 8);
    System.out.println("lists = " + lists);


  }

  public static List<List<Integer>> fourSum(int[] nums, int target) {
    int len = nums.length;
    Set<List<Integer>> ans = new HashSet<>();
    if (len < 4) {
      return new ArrayList<>(ans);
    }
    sort(nums);
    for (int i = 0; i < len - 3; i++) {
      long x = nums[i];
      for (int j = i + 1; j < len - 2; j++) {
        long y = nums[j];
        int k = j + 1;
        int l = len - 1;
        while (k < l) {
          long z = nums[k];
          long w = nums[l];
          long sum = x + y + z + w;
          if (sum > target) {
            l--;
          } else if (sum < target) {
            k++;
          } else {
            ans.add(List.of((int) x, (int) y, (int) z, (int) w));
            k++;
            while (k < l && nums[k] == nums[k - 1]) {
              k++;
            }
            l--;
            while (l > k && nums[l] == nums[l + 1]) {
              l--;
            }
          }
        }
      }
    }
    return new ArrayList<>(ans);
  }

  private static void sort(int[] nums) {
    int len = nums.length;
    int[] sup = new int[len];
    mergeSort(nums, 0, len - 1, sup);
  }

  private static void mergeSort(int[] nums, int left, int right, int[] sup) {
    if (left < right) {
      int mid = left + (right - left) / 2;
      mergeSort(nums, left, mid, sup);
      mergeSort(nums, mid + 1, right, sup);
      doMergeSort(nums, left, mid, right, sup);
    }
  }

  private static void doMergeSort(int[] nums, int left, int mid, int right, int[] sup) {
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
