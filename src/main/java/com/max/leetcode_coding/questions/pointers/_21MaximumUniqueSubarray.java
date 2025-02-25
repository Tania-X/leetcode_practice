package com.max.leetcode_coding.questions.pointers;

import java.util.HashMap;
import java.util.Map;

public class _21MaximumUniqueSubarray {

  public static void main(String[] args) {
    int result = maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6});
    System.out.println("result = " + result);

  }

  public static int maximumUniqueSubarray(int[] nums) {
    int ans = 0;
    int n = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    int left = 0;
    int sum = 0;
    for (int right = 0; right < n; right++) {
      map.merge(nums[right], 1, Integer::sum);
      sum += nums[right];
      while (map.get(nums[right]) > 1) {
        sum -= nums[left];
        map.merge(nums[left], -1, Integer::sum);
        left++;
      }
      ans = Math.max(ans, sum);
    }
    return ans;
  }

}
