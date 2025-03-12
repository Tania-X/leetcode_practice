package com.max.leetcode_coding.questions.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _24ThreeSum {

  public static void main(String[] args) {
    List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    int n = nums.length;
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < n - 2; i++) {
      int x = nums[i];
      int j = i + 1;
      int k = n - 1;
      while (j < k) {
        int y = nums[j];
        int z = nums[k];
        int sum = x + y + z;
        if (sum < 0) {
          j++;
        } else if (sum > 0) {
          k--;
        } else {
          ans.add(List.of(x, y, z));
          j++;
          while (j < k && nums[j] == nums[j - 1]) {
            j++;
          }
          k--;
          while (k > j && nums[k] == nums[k + 1]) {
            k--;
          }
        }
      }
    }
    return ans;
  }

}
