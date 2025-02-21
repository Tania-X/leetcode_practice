package com.max.leetcode_coding.questions.pointers;

public class _11NumSubarrayProductLessThanK {

  public static void main(String[] args) {
    int result = numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100);
    System.out.println("result = " + result);

  }

  public static int numSubarrayProductLessThanK(int[] nums, int k) {
    int n = nums.length;
    if (k <= 1) {
      return 0;
    }
    int ans = 0;
    int prod = 1;
    int left = 0;
    for (int right = left; right < n; right++) {
      prod *= nums[right];
      while (prod >= k) {
        prod /= nums[left++];
      }
      ans += right -left + 1;
    }
    return ans;
  }

}
