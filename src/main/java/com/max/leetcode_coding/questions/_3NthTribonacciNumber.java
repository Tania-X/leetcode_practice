package com.max.leetcode_coding.questions;

public class _2NthTribonacciNumber {

  public static void main(String[] args) {
    System.out.println(nthTribonacciNumber(25));
  }

  public static int nthTribonacciNumber(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 1;
    }
    int l = 0;
    int m = 1;
    int r = 1;
    int res = 2;
    for (int i = 0; i < n - 3; i++) {
      l = m;
      m = r;
      r = res;
      res = l + m + r;
    }
    return res;
  }

}
