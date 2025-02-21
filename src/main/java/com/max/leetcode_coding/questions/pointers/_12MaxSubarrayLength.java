package com.max.leetcode_coding.questions.pointers;

import java.util.HashMap;
import java.util.Map;

public class _12MaxSubarrayLength {

  public static void main(String[] args) {

    int result = maxSubarrayLength(new int[]{1, 2, 2, 1, 3}, 1);
    System.out.println("result = " + result);

  }

  public static int maxSubarrayLength(int[] nums, int k) {
    int n = nums.length;
    int ans = 0;
    Map<Integer, Integer> map = new HashMap<>();
    int left = 0;
    for (int right = left; right < n; right++) {
      int x = nums[right];
      map.merge(x, 1, Integer::sum);
      while (map.get(x) > k) {
        map.merge(nums[left++], -1, Integer::sum);
      }
      ans = Math.max(ans, right - left + 1);
    }
    return ans;
  }

}
