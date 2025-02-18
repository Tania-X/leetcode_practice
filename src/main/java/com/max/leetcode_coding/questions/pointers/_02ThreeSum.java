package com.max.leetcode_coding.questions.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _02ThreeSum {

  public static void main(String[] args) {
    int[] source = new int[]{-1, 0, 1, 2, -1, -4};
    List<List<Integer>> lists = threeSum(source);
    System.out.println("lists = " + lists);
  }

  public static List<List<Integer>> threeSum(int[] nums) {
//    sort(nums);
    Arrays.sort(nums);
    int len = nums.length;
    List<List<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < len - 2; i++) {
      int x = nums[i];
      // 跳过重复数字
      if (i - 1 >=0 && x == nums[i - 1]) {
        continue;
      }
      int j = i + 1;
      int k = len - 1;
      while (j < k) {
        int y = nums[j];
        int z = nums[k];
        if (x + y + z > 0) {
          k--;
        } else if (x + y + z < 0) {
          j++;
        } else {
          ans.add(List.of(x, y, z));
          j++;
          // 跳过重复数字
          while (j < k && nums[j] == nums[j - 1]) {
            j++;
          }
          k--;
          // 跳过重复数字
          while (k > j && nums[k] == nums[k + 1]) {
            k--;
          }

        }
      }
    }
    return ans;
  }

  private static void sort(int[] nums) {
    int len = nums.length;
    mergeSort(nums, 0, len - 1);
  }

  private static void mergeSort(int[] nums, int left, int right) {
    if (left < right) {
      int mid = left + (right - left) / 2;
      mergeSort(nums, left, mid);
      mergeSort(nums, mid + 1, right);
      doMergeSort(nums, left, right);
    }

  }

  private static void doMergeSort(int[] nums, int left, int right) {
    int[] sup = new int[nums.length];

  }

}
