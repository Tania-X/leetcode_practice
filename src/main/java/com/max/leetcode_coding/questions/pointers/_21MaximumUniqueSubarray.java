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
    Map<Integer, Integer> map = new HashMap<>();
    int left = 0;
    int sum = 0;
    for (int num : nums) {
      sum += num;
      map.merge(num, 1, Integer::sum);
      if (map.get(num) > 1) {
        while (map.get(nums[left]) == 1) {
          sum -= nums[left];
          map.remove(nums[left++]);
        }
        map.merge(num, -1, Integer::sum);
        sum -= nums[left++];
      } else {
        ans = Math.max(sum, ans);
      }
    }
    return ans;
  }

}
