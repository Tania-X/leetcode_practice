package com.max.leetcode_coding.questions.dp;

public class _10CountGoodStrings {

  public static void main(String[] args) {
    System.out.println(countGoodStrings(10, 10, 10, 2));

  }

  public static int countGoodStrings(int low, int high, int zero, int one) {
    int MOD = 1_000_000_007;
    int[] dp = new int[high + 1];
    dp[0] = 1;
    int ans = 0;
    for (int i = 1; i <= high; i++) {
      if (i >= zero) {
        dp[i] = dp[i - zero];
      }
      if (i >= one) {
        dp[i] = (dp[i] + dp[i - one]) % MOD;
      }
      if (i >= low) {
        ans = (ans + dp[i]) % MOD;
      }
    }
    return ans;
  }

}
