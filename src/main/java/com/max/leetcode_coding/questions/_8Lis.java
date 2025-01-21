package com.max.leetcode_coding.questions;

import java.util.ArrayList;
import java.util.List;

public class _8Lis {

  public static void main(String[] args) {
    System.out.println(lis(new int[]{1,5,3,4,6,9,7,8}));
    System.out.println("=======");
    System.out.println(lengthOfLIS(new int[]{1,5,3,4,6,9,7,8}));

  }

  public static int lis(int[] nums) {
    int len = nums.length;
    if (len == 1) {
      return 1;
    }
    int[] dp = new int[len];
    for (int i : dp) {
      dp[i] = 1;
    }
    for (int i = 1; i < len; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }
    int result = dp[0];
    for (int r : dp) {
      System.out.println(r);
      result = Math.max(result, r);
    }
    System.out.println("-----");
    return result;
  }


  public static int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    List<Integer> tails = new ArrayList<>();

    for (int num : nums) {
      int left = 0, right = tails.size();

      // 二分查找找到合适的位置
      while (left < right) {
        int mid = left + (right - left) / 2;
        if (tails.get(mid) < num) {
          left = mid + 1;
        } else {
          right = mid;
        }
      }

      // 如果没有找到合适位置，添加新的元素
      if (left == tails.size()) {
        tails.add(num);
      } else {
        tails.set(left, num);
      }
    }

    return tails.size();  // 最终tails数组的大小即为LIS的长度
  }

}
