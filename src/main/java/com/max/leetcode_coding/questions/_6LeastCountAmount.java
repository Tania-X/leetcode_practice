package com.max.leetcode_coding.questions;

public class _6LeastCountAmount {

  public static void main(String[] args) {

    // 这两组方法之间的差别：在当前状态基础上向前求解还是向后求解

    System.out.println(leastCountAmount(15, 1, 5, 11));
    System.out.println("-----------------");
    System.out.println(leastCountAmount2(15, 1, 5, 11));
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
      throw new IllegalArgumentException("no such result");
    } else {
      return dp[amount];
    }
  }

  public static int leastCountAmount2(int amount, int s, int m, int l) {
    int[] dp = new int[amount + 1];
    dp[0] = 0;
    for (int i = 1; i < dp.length; i++) {
      dp[i] = Integer.MAX_VALUE;
    }
    int[] coins = new int[]{s, m, l};
    for (int i = 1; i <= amount; i++) {
      for(int coin: coins) {
        if (coin + i <= amount) {
          dp[i + coin] = Math.min(dp[i + coin], dp[i] + 1);
        }
      }
      System.out.println("dp[" + i + "] = " + dp[i]);
    }
    if (dp[amount] == Integer.MAX_VALUE) {
      throw new IllegalArgumentException("no such result");
    }
    return dp[amount];
  }

}
