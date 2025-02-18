package com.max.leetcode_coding.questions.pointers;

public class _04ThreeSumClosest {

  public static void main(String[] args) {

    int ans = threeSumClosest(new int[]{1, 3, 4, 7, 8, 9}, 15);
    System.out.println("ans = " + ans);

  }

  public static int threeSumClosest(int[] nums, int target) {
    int len = nums.length;
    if (len < 3) {
      throw new IllegalArgumentException("ERROR INPUT");
    } else if (len == 3) {
      return nums[0] + nums[1] + nums[2];
    }
    sort(nums);
    int ans = 0;
    int diff = Integer.MAX_VALUE;
    for (int i = 0; i < len - 2; i++) {
      int x = nums[i];

      // 优化1
      if (i > 0 && x == nums[i - 1]) {
        continue;
      }

      int j = i + 1;
      int k = len - 1;

      // 优化2
      int sum = x + nums[i + 1] + nums[i + 2];
      int newDiff = 0;
      if (sum > target) {
        newDiff = sum - target;
        if (newDiff < diff) {
          ans = sum;
        }
        break;
      }

      // 优化3
      sum = x + nums[len - 2] + nums[len - 1];
      if (sum < target) {
        newDiff = target - sum;
        if (newDiff < diff) {
          diff = newDiff;
          ans = sum;
        }
        continue;
      }

      while (j < k) {
        int y = nums[j];
        int z = nums[k];
        sum = x + y + z;
        if (sum > target) {
          newDiff = sum - target;
          if (newDiff < diff) {
            diff = newDiff;
            ans = sum;
          }
          k--;
        } else if (sum < target) {
          newDiff = target - sum;
          if (newDiff < diff) {
            diff = newDiff;
            ans = sum;
          }
          j++;
        } else {
          return sum;
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
