package com.max.leetcode_coding.questions.sort;

import java.util.Arrays;
import java.util.Random;

public class _01SortArray {

  public static void main(String[] args) {
    int[] result = sortArray(new int[]{2, -3, 1, 4});
    System.out.println("result = " + Arrays.toString(result));
    int[] result2 = sortArray2(new int[]{2, -3, 1, 4});
    System.out.println("result2 = " + Arrays.toString(result2));

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
    if (r - l + 1 >= 0) {
      System.arraycopy(temp, 0, nums, l, r - l + 1);
    }
  }

  // m2 快速排序（为啥超时？）
  public static int[] sortArray2(int[] nums) {
    int len = nums.length;
    if (len == 0 || len == 1) {
      return nums;
    }
    randomizedQuickSort(nums, 0, len - 1);
    return nums;
  }

  private static void randomizedQuickSort(int[] nums, int l, int r) {
    if (l < r) {
      int pos = randomizedPartition(nums, l, r);
      randomizedQuickSort(nums, l, pos - 1);
      randomizedQuickSort(nums, pos + 1, r);
    }
  }

  private static int randomizedPartition(int[] nums, int l, int r) {
    int i = new Random().nextInt(r - l + 1) + l;
    swap(nums, r, i);
    return partition(nums, l, r);
  }

  private static int partition(int[] nums, int l, int r) {
    int pivot = nums[r];
    int i = l - 1;
    for (int j = l; j <= r - 1; j++) {
      if (nums[j] <= pivot) {
        swap(nums, ++i, j);
      }
    }
    swap(nums, i + 1, r);
    return i + 1;
  }

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}
