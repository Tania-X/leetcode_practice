package com.max.leetcode_coding.questions.dp;

public class _1ClimbingStairs {

  public static void main(String[] args) {
    System.out.println(climbingStairs(5));
  }

  public static int climbingStairs(int n) {
    int l = 0;
    int r = 0;
    int res = 1;
    for (int i = 0; i < n; i++) {
      l = r;
      r = res;
      res = l + r;
    }
    return res;
  }

}
