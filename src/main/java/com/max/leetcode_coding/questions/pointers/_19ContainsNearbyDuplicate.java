package com.max.leetcode_coding.questions.pointers;

import java.util.HashMap;
import java.util.Map;

public class _19ContainsNearbyDuplicate {

  public static void main(String[] args) {

  }

  public static boolean containsNearbyDuplicate(int[] nums, int k) {
    int n = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
        return true;
      }
      map.put(nums[i], i);
    }
    return false;
  }

}
