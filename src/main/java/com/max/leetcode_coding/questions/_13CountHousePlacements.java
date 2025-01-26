package com.max.leetcode_coding.questions;

public class _13CountHousePlacements {

  public static void main(String[] args) {

  }

  public int countHousePlacements(int n) {
    int MOD = 1000_000_001;
    int[] f = new int[n + 1];
    f[0] = 1;
    f[1] = 2;
    for (int i = 2; i <= n; i++) {
      f[i] = (f[i - 2] + f[i - 1]) % MOD;
    }
    return (int) ((long) f[n] * f[n] % MOD);
  }

  private static final int MOD = (int) 1e9 + 7;

  private static final int MX = (int) 1e4 + 1;

  private static final int[] dp = new int[MX];

  static {
    dp[0] = 1;
    dp[1] = 2;
    for (int i = 2; i < MX; i++) {
      dp[i] = dp[i - 2] + dp[i - 1];
    }
  }

  public int countHousePlacements2(int n) {
    return (int)((long) dp[n] * dp[n] % MOD);
  }

}
