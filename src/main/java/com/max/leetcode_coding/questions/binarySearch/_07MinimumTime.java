package com.max.leetcode_coding.questions.binarySearch;

public class _07MinimumTime {

  public static void main(String[] args) {
    long l = minimumTime(new int[]{5, 10, 10}, 9);
    System.out.println("l = " + l);
  }

  public static long minimumTime(int[] time, int totalTrips) {
    long right = -1;
    for (int j : time) {
      right = Math.max(right, j);
    }
    right *= totalTrips;
    long ans = right;
    long left = 0;
    while (left + 1 < right) {
      long t = left + (right - left) / 2;
      long sum = 0;
      for (int j : time) {
        sum += t / j;
      }
      if (sum >= totalTrips) {
        right = t;
        ans = Math.min(t, ans);
      } else {
        left = t;
      }
    }
    return ans;
  }

}
