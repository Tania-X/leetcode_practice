package com.max.leetcode_coding.questions.pointers;

public class _14LongestOnes {

  public static void main(String[] args) {

    int result = longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
    System.out.println("result = " + result);

  }

  public static int longestOnes(int[] nums, int k) {
    int n = nums.length;
    int ans = 0;
    int count = 0;
    int left = 0;
    for (int right = 0; right < n; right++) {
      if (nums[right] == 0) {
        count++;
        if (count > k) {
          while (nums[left] == 1) {
            left++;
          }
          left++;
          count--;
        }
      }
      ans = Math.max(ans, right - left + 1);
    }
    return ans;
  }

}
