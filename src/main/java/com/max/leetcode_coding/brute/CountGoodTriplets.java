package com.max.leetcode_coding.brute;

public class CountGoodTriplets {

  public static void main(String[] args) {

  }

  public static int countGoodTriplets(int[] arr, int a, int b, int c) {
    int ans = 0;
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
          int x = Math.abs(arr[i] - arr[j]);
          int y = Math.abs(arr[j] - arr[k]);
          int z = Math.abs(arr[i] - arr[k]);
          if (x <= a && y <= b && z <= c) {
            ans++;
          }
        }
      }
    }
    return ans;
  }

}
