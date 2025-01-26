package com.max.leetcode_coding.questions;

public class _12DeleteAndEarn {

  public static void main(String[] args) {
    System.out.println(deleteAndEarn(new int[]{2,2,3,3,3,4}));

  }

  public static int deleteAndEarn(int[] nums) {
    int[] dp = new int[10001];
    int max = 0;
    for (int num : nums) {
      dp[num] += num;
      max = Math.max(num, max);
    }
    for (int i = 2; i <= max; i++) {
      dp[i] = Math.max(dp[i - 2] + dp[i], dp[i - 1]);
    }
    return dp[max];
  }

}
