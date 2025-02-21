package com.max.leetcode_coding.questions.pointers;

public class _09MinSubArrayLen {

  public static void main(String[] args) {
    int result = minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
    System.out.println("result = " + result);
    int result2 = minSubArrayLen2(7, new int[]{2, 3, 1, 2, 4, 3});
    System.out.println("result2 = " + result2);
  }

  public static int minSubArrayLen(int target, int[] nums) {
    int n = nums.length;
    int ans = Integer.MAX_VALUE;
    int sum = 0;
    int left = 0;
    for (int right = left; right < n; right++) {
      sum += nums[right];
      while (sum - nums[left] >= target) {
        sum -= nums[left];
        left++;
      }
      if (sum >= target) {
        ans = Math.min(ans, right - left + 1);
      }
    }
    return ans == Integer.MAX_VALUE ? 0 : ans;
  }

  public static int minSubArrayLen2(int target, int[] nums) {
    int n = nums.length;
    int ans = Integer.MAX_VALUE;
    int sum = 0;
    int left = 0;
    for (int right = left; right < n; right++) {
      sum += nums[right];
      while (sum >= target) {
        ans = Math.min(ans, right - left + 1);
        sum -= nums[left++];
      }
    }
    return ans == Integer.MAX_VALUE ? 0 : ans;
  }

}
