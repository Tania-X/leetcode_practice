package com.max.leetcode_coding.questions.pointers;

public class _10LengthOfLongestSubstring {

  public static void main(String[] args) {

  }

  public static int lengthOfLongestSubstring(String s) {
    char[] chars = s.toCharArray();
    int n = chars.length;
    if (n < 1) {
      return 0;
    }
    int ans = 0;
    // cnt数组，每一个元素可以根据ASCII码映射
    int[] cnt = new int[128];
    int left = 0;
    for (int right = left; right < n; right++) {
      char c = chars[right];
      cnt[c]++;
      // 这里while循环，便是为了清除当前c加入滑动窗口带来的重复性影响，从前往后一直清空cnt数组，直到c为止
      while (cnt[c] > 1) {
        cnt[chars[left]]--;
        left++;
      }
      ans = Math.max(ans, right - left + 1);
    }
    return ans;
  }

}
