package com.max.leetcode_coding.questions.recurrence;

public class YhTriangle {

  public static void main(String[] args) {
    int m = 5;
    int n = 3;
    int result = yhTriangle(m, n);
    System.out.println("result = " + result);

    int result2 = yhTriangle2(m, n);
    System.out.println("result2 = " + result2);

    int result3 = yhTriangle3(m, n);
    System.out.println("result3 = " + result3);
  }

  public static int yhTriangle(int m, int n) {
    if (n == 1 || m == n) {
      return 1;
    }
    return yhTriangle(m - 1, n - 1) + yhTriangle(m - 1, n);
  }

  private static int[][] memo;

  public static int yhTriangle2(int m, int n) {
    memo = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        memo[i][j] = -1;
      }
    }
    return dfs(m - 1, n - 1);
  }

  private static int dfs(int i, int j) {
    if (j == 0 || i == j) {
      return 1;
    }
    if (memo[i][j] != -1) {
      return memo[i][j];
    }
    return memo[i][j] = dfs(i - 1, j - 1) + dfs(i - 1, j);
  }

  public static int yhTriangle3(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0 || j == i) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
        }
      }
    }
    return dp[m - 1][n - 1];
  }

}
