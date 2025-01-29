package com.max.leetcode_coding.questions.dp;

import java.util.HashMap;
import java.util.Map;

public class _7TwoSum {

  public static void main(String[] args) {


  }

  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      // 这里有个思维上的惯性：认为在`map`中必须以数组的`index`作为`key`，数值为`value`。实际上反过来完全没问题。
      if (map.containsKey(target - nums[i])) {
        return new int[]{i, map.get(target - nums[i])};
      } else {
        map.put(nums[i], i);
      }
    }
    throw new RuntimeException("no such nums");
  }

}
