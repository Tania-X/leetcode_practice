package com.max.leetcode_coding.questions;

public class _9CombinationSum4 {

  public static void main(String[] args) {
    System.out.println(combinationSum4(new int[]{1,2,3}, 4));

  }

  public static int combinationSum4(int[] nums, int target) {
    int[] dp = new int[target + 1];
    dp[0] = 1;
    int len = dp.length;
    for (int i = 1; i < len; i++) {
      for (int num : nums) {
        if (i - num >= 0) {
          dp[i] += dp[i - num];
        }
      }
    }
    return dp[target];
  }

}
