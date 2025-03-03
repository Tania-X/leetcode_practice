package com.max.leetcode_coding.questions.binarySearch;

public class _06MinEatingSpeed {

  public static void main(String[] args) {
    int ans = minEatingSpeed(new int[]{312884470}, 968709470);
    System.out.println("ans = " + ans);
  }

  public static int minEatingSpeed(int[] piles, int h) {
    int ans = Integer.MAX_VALUE;
    int max = -1;
    for (int pile : piles) {
      max = Math.max(max, pile);
    }
    int left = 0;
    int right = max + 1;
    while (left + 1 < right) {
      int k = left + (right - left) / 2;
      long sum = 0;
      for (int pile : piles) {
        sum += pile / k + (pile % k == 0 ? 0 : 1);
      }
      if (sum > h) {
        left = k;
      } else {
        right = k;
        ans = Math.min(ans, k);
      }
    }
    return ans;
  }

}
