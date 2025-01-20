package com.max.leetcode_coding.daily;

public class _1FindClosestNumber {

  public static void main(String[] args) {
    System.out.println(findClosestNumber(new int[]{-4, -2, 1, 4, 8}));

  }

  public static int findClosestNumber(int[] nums) {
    int positive = 100001;
    int negative = -100001;
    for (int num : nums) {
      if (num >= 0) {
        if (num < positive) {
          positive = num;
        }
      } else {
        if (num > negative) {
          negative = num;
        }
      }
    }
    if (positive == 100001 && negative == -100001) {
      throw new RuntimeException();
    } else if (positive == 100001) {
      return negative;
    } else if (negative == -100001) {
      return positive;
    } else {
      if (positive + negative <= 0) {
        return positive;
      } else {
        return negative;
      }
    }
  }

  public static int findClosestNumber2(int[] nums) {
    int distance = Math.abs(nums[0]);
    int result = nums[0];
    for (int num : nums) {
      if (Math.abs(num) < distance) {
        distance = Math.abs(num);
        result = num;
      } else if (Math.abs(num) == distance) {
        result = Math.max(num, result);
      } else {
        // do nothing
      }
    }
    return result;
  }

}
