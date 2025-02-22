package com.max.leetcode_coding.questions.pointers;

public class _16CountSubarrays {

  public static void main(String[] args) {
    long result = countSubarrays(new int[]{2, 1, 4, 3, 5}, 10);
    System.out.println("result = " + result);

  }

  public static long countSubarrays(int[] nums, long k) {
    long ans = 0;
    int n = nums.length;
    int left = 0, right = 0;
    long sum = 0;
    while (right < n) {
      sum += nums[right];
      while ( sum * (right - left +1) >= k) {
        sum -= nums[left++];
      }
      ans += right - left + 1;
      right++;
    }
    return ans;
  }

}
