package com.max.leetcode_coding.questions.dp;

public class _11CountNumbersOfTexts {

  public static void main(String[] args) {



  }

    private static final int MOD = 1_000_000_007;
    private static final int MX = 100_001;
    private static final int[] f = new int[MX];
    private static final int[] g = new int[MX];

  static {
    f[0] = g[0] = 1;
    f[1] = g[1] = 1;
    f[2] = g[2] = 2;
    f[3] = g[3] = 4;
    for (int i = 4; i < MX; i++) {
      f[i] = (f[i - 1] + f[i - 2] + f[i - 3]) % MOD;
      g[i] = (g[i - 1] + g[i - 2] + g[i - 3] + g[i - 4]) % MOD;
    }
  }

  public int countTexts(String pressedKeys) {
    int len = pressedKeys.length();
    int count = 0;
    long ans = 1;
    for (int i = 0; i < len; i++) {
      char c = pressedKeys.charAt(i);
      count++;
      if (i == pressedKeys.length() - 1 || c != pressedKeys.charAt(i + 1)) {
        ans = ans * ((c == '7' || c == '9') ? g[count] : f[count]) % MOD;
        count = 0;
      }
    }
    return (int) ans;
  }

}
