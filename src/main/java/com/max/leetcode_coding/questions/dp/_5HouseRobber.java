package com.max.leetcode_coding.questions.dp;

public class _5HouseRobber {

  public static void main(String[] args) {
    int rob = rob(new int[]{1, 2, 3, 1});
    int rob2 = rob2(new int[]{1, 2, 3, 1});
    if (rob == rob2) {
      System.out.println("yes");
    }
  }

  public static int rob(int[] nums) {
    int len = nums.length;
    if (len == 1) {
      return nums[0];
    }
    if (len == 2) {
      return Math.max(nums[0], nums[1]);
    }

    int[] amounts = new int[len];
    amounts[0] = nums[0];
    amounts[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < len; i++) {
      amounts[i] = Math.max(amounts[i - 2] + nums[i], amounts[i - 1]);
//      System.out.println("amounts[" + i + "] = " + amounts[i]);
    }
    return amounts[len - 1];
  }



  public static int rob2(int[] nums) {
    int len = nums.length;
    if (len == 1) {
      return nums[0];
    }
    if (len == 2) {
      return Math.max(nums[0], nums[1]);
    }
    int l = nums[0];
    int r = Math.max(nums[0], nums[1]);
    int c = Math.max(r, l + nums[2]);
    for (int i = 3; i < nums.length; i++) {
      l = r;
      r = c;
      c = Math.max(r, l + nums[i]);
      System.out.println("c = " + c);
    }
    return c;
  }

}
