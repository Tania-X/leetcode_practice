package com.max.leetcode_coding.questions.pointers;

public class _17MinOperations {

  public static void main(String[] args) {
    int result = minOperations(new int[]{1, 1, 4, 2, 3}, 5);
    System.out.println("result = " + result);

  }

  public static int minOperations(int[] nums, int x) {
    int n = nums.length;
    int ans = Integer.MAX_VALUE;
    int left = 0;
    int sum = nums[left];
    // 考虑如何去设计这个while循环，找到最长左前缀
    while (left < n - 1 && sum + nums[left + 1] <= x) {
      left++;
      sum += nums[left];
    }
    if (sum == x) {
      ans = left + 1;
    }
    if (left == n - 1 && sum < x) {
      return -1;
    }
    int right = n - 1;
    // 这里要调试边界条件
    while (left >= -1) {
      while (sum < x && right >= 0) {
        sum += nums[right--];
      }
      if (sum == x) {
        ans = Math.min(ans, left + n - right);
      }
      if (left < 0) {
        break;
      }
      sum -= nums[left--];
    }
    return ans == Integer.MAX_VALUE ? -1 : ans;
  }

}
