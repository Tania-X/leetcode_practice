package com.max.leetcode_coding.questions.pointers;

public class _13LongestSemiRepetitiveSubstring {

  public static void main(String[] args) {
    int result = longestSemiRepetitiveSubstring("52233");
    System.out.println("result = " + result);
  }

  public static int longestSemiRepetitiveSubstring(String s) {
    int n = s.length();
    if (n <= 2) {
      return n;
    }
    int ans = 1;
    int left = 0;
    int repeat = 0;
    for (int right = left + 1; right < n; right++) {
      if (s.charAt(right) == s.charAt(right - 1)) {
        repeat++;
      }
      if (repeat > 1) {
        while (s.charAt(left) != s.charAt(left + 1)) {
          left++;
        }
        left++;
        repeat--;
      }
      ans = Math.max(ans, right - left + 1);
    }
    return ans;
  }

}
