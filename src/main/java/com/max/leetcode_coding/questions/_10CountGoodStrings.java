package com.max.leetcode_coding.questions;

public class _10CountGoodStrings {

  public static void main(String[] args) {
    System.out.println(countGoodStrings(10, 10, 10, 2));

  }

  public static int countGoodStrings(int low, int high, int zero, int one) {
    int MOD = 1_000_000_007;
    int[] dp = new int[high + 1];
    dp[0] = 1;
    for (int i = 1; i < high; i++) {
      if (i>= zero && i >= one) {
        dp[i] = (dp[i - zero] + dp[i - one]);
      } else if (i >= zero) {
        dp[i] += dp[i - zero];
      } else if (i >= one) {
        dp[i] = dp[i - one];
      }
    }
    for (int i = 0; i <= high; i++) {
      System.out.println("dp[" + i + "] = " + dp[i]);
    }
    int result = 0;
    for (int i = low; i <= high; i++) {
      result += dp[i];
    }
    return result % MOD;
  }

}
