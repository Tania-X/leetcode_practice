package com.max.leetcode_coding.questions.pointers;

import java.util.Arrays;

public class _01TwoSum {

  public static void main(String[] args) {
    int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
    System.out.println("result = " + Arrays.toString(result));
  }

  public static int[] twoSum(int[] numbers, int target) {
    int len = numbers.length;
    int left = 0;
    int right = len - 1;
    while (left < right) {
      if (numbers[left] + numbers[right] > target) {
        right--;
      } else if (numbers[left] + numbers[right] < target) {
        left++;
      } else {
        return new int[]{++left, ++right};
      }
    }
    throw new IllegalArgumentException("INPUT ERROR");
  }

}
