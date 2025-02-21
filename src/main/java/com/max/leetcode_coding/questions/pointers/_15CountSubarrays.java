package com.max.leetcode_coding.questions.pointers;

public class _15CountSubarrays {

  public static void main(String[] args) {
    long result = countSubarrays(
        new int[]{61, 23, 38, 23, 56, 40, 82, 56, 82, 82, 82, 70, 8, 69, 8, 7, 19, 14, 58, 42, 82,
            10, 82, 78, 15, 82}, 2);
    System.out.println("result = " + result);
  }


  public static long countSubarrays(int[] nums, int k) {
    int max = findMaxValue(nums);
    long ans = 0;
    int count = 0;
    int left = 0;
    for (int x : nums) {
      if (x == max) {
        count++;
      }
      while (count == k) {
        if (nums[left++] == max) {
          count--;
        }
      }
      ans += left;
    }
    return ans;
  }

  private static int findMaxValue(int[] nums) {
    int ans = Integer.MIN_VALUE;
    for (int num : nums) {
      ans = Math.max(num, ans);
    }
    return ans;
  }

}
