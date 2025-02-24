package com.max.leetcode_coding.questions.pointers;

public class _20NumberOfArithmeticSlices {

  public static void main(String[] args) {
    int result = numberOfArithmeticSlices(new int[]{7,7,7,7});
    System.out.println("result = " + result);
  }

  // brute solution
  public static int numberOfArithmeticSlices(int[] nums) {
    int n = nums.length;
    if (n < 3) {
      return 0;
    }
    int ans = 0;
    for (int right = 1; right < n; right++) {
      int left = right - 1;
      while (right + 1 < n && nums[right + 1] - nums[right] == nums[right] - nums[right - 1]) {
        right++;
      }
      ans += (right - left) * (right - left - 1) / 2;
    }
    return ans;
  }

}
