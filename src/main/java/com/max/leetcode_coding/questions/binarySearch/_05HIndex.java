package com.max.leetcode_coding.questions.binarySearch;

public class _05HIndex {

  public static void main(String[] args) {

    int i = hIndex(new int[]{1});
    System.out.println("i = " + i);

  }

  public static int hIndex(int[] citations) {
    int ans = 0;
    int atc = 0;
    int n = citations.length;
    while (atc <= citations[n - 1]) {
      int start = lowerBound(citations, atc);
      if (n - start < atc) {
        break;
      } else {
        ans = atc;
        atc++;
      }
    }
    return ans;
  }

  public static int lowerBound(int[] nums, int target) {
    int left = -1;
    int right = nums.length;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] >= target) {
        right = mid;
      } else {
        left = mid;
      }
    }
    return right;
  }

}
