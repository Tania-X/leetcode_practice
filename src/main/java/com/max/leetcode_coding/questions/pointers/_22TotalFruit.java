package com.max.leetcode_coding.questions.pointers;

import java.util.HashMap;
import java.util.Map;

public class _22TotalFruit {

  public static void main(String[] args) {

    int result = totalFruit(new int[]{1, 0, 1, 4, 1, 4, 1, 2, 3});
    System.out.println("result = " + result);

  }

  public static int totalFruit(int[] fruits) {
    int n = fruits.length;
    if (n < 2) {
      return 0;
    }
    int ans = -1;
    int left = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int right = 0; right < n; right++) {
      map.merge(fruits[right], 1, Integer::sum);
      if (map.size() > 2) {
        while (map.merge(fruits[left], -1, Integer::sum) > 0) {
          left++;
        }
        map.remove(fruits[left++], 0);
      }
      ans = Math.max(ans, right - left + 1);
    }
    return ans;
  }

}
