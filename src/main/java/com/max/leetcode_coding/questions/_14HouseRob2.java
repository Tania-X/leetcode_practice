package com.max.leetcode_coding.questions;

public class _14HouseRob2 {

  public static void main(String[] args) {

    System.out.println(houseRob2(new int[]{1,2,3,1}));
    System.out.println("-------");
    System.out.println(houseRob22(new int[]{1,2,3,1}));
  }

  public static int houseRob2(int[] nums) {
    int len = nums.length;
    if (len == 1) {
      return nums[0];
    } else if (len == 2) {
      return Math.max(nums[0], nums[1]);
    }
    int dontChoose0 = robNotChoose0(nums);
    int choose0 = robChoose0(nums);
    return Math.max(choose0 + nums[0], dontChoose0);
  }

  private static int robNotChoose0(int[] nums) {
    int len = nums.length;
    if (len == 3) {
      return Math.max(nums[2], nums[1]);
    }
    int[] dp = new int[len + 1];
    dp[1] = nums[1];
    dp[2] = Math.max(nums[2], nums[1]);
    for (int i = 3; i < len; i++) {
      dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
    }
    return dp[len - 1];
  }

  private static int robChoose0(int[] nums) {
    int len = nums.length;
    if (len == 3) {
      return 0;
    } else if (len == 4) {
      return nums[2];
    } else if (len == 5) {
      return Math.max(nums[2], nums[3]);
    }
    int[] dp = new int[len + 1];
    dp[2] = nums[2];
    dp[3] = Math.max(nums[2], nums[3]);
    for (int i = 4; i < len; i++) {
      dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
    }
    return dp[len - 2];
  }

  public static int houseRob22(int[] nums) {
    int len = nums.length;
    if (len == 1) {
      return nums[0];
    } else if (len == 2) {
      return Math.max(nums[0], nums[1]);
    }
    return Math.max(doHouseRob22(nums, 1, len), nums[0] + doHouseRob22(nums, 2, len - 1));
  }

  private static int doHouseRob22(int[] nums, int start, int end) {
    int f1 = 0;
    int f2 = 0;
    int newF = 0;
    for (int i = start; i < end; i++) {
      f1 = f2;
      f2 = newF;
      newF = Math.max(f1 + nums[i], f2);
    }

    return newF;
  }

}
