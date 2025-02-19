package com.max.leetcode_coding.questions.pointers;

public class _06TriangleNumber {

  public static void main(String[] args) {

  }

  public static int triangleNumber(int[] nums) {
    int len = nums.length;
    if (len < 3) {
      return 0;
    }
    sort(nums);
    int ans = 0;
    // 这里不选i作为遍历点，而选择k，是因为选择i时，满足条件的情况下，并不知道该如何移动j与k
    // 但若选择k，那么nums[k]与nums[i]与nums[j]的和是具有比较性的
    for (int k = 2; k < len; k++) {
      int c = nums[k];
      // 优化：如果最大的a和最大的b之和都小
      if (nums[k - 2] + nums[k - 1] <= c) {
        continue;
      }
      int i = 0;
      int j = k - 1;
      while (i < j) {
        int a = nums[i];
        int b = nums[j];
        if (a + b > c) {
          ans += j - i;
          j--;
        } else {
          i++;
        }
      }
    }
    return ans;
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
