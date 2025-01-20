package com.max.leetcode_coding.questions;

public class _6LeastCountAmount {

  public static void main(String[] args) {
    System.out.println(leastCountAmount(15, 1, 5, 11));
  }

  public static int leastCountAmount(int amount, int s, int m, int l) {
    int[] dp = new int[amount + 1];
    int[] coins = new int[]{s, m, l};
    for (int i = 1; i < dp.length; i++) {
      dp[i] = Integer.MAX_VALUE;
    }
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        if (i - coin >= 0) {
          dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
        }
      }
      System.out.println("dp[" + i + "] = " + dp[i]);
    }
    if (dp[amount] == Integer.MAX_VALUE) {
      throw new RuntimeException("can't redeem");
    } else {
      return dp[amount];
    }
  }

}
