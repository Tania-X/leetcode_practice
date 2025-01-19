package com.max.leetcode_coding.questions;

public class _2FibonacciNumber {

  public static void main(String[] args) {
    System.out.println(fibonacciNumber(5));
  }

  public static int fibonacciNumber(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    int l = 0;
    int r = 0;
    int res = 1;
    for (int i = 0; i < n - 1; i++) {
      l = r;
      r = res;
      res = l + r;
    }
    return res;
  }

}
