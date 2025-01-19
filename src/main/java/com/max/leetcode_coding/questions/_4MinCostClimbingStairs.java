package com.max.leetcode_coding.questions;

public class _4MinCostClimbingStairs {

  public static void main(String[] args) {
    System.out.println(minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
  }

  public static int minCostClimbingStairs(int[] cost) {
    if (cost.length < 2) {
      throw new RuntimeException();
    }
    int len = cost.length;
    int[] dp = new int[len + 1];
    dp[len] = 0;
    dp[len - 1] = cost[len - 1];
    for (int i = len - 2; i >= 0; i--) {
      dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
    }
    for (int i : dp) {
      System.out.println(i);
    }
    return Math.min(dp[0], dp[1]);
  }

}
