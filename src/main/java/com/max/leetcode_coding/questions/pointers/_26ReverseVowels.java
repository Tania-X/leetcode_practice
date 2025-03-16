package com.max.leetcode_coding.questions.pointers;

import java.util.Set;

public class _26ReverseVowels {

  private static final Set<Character> VOWEL_SET = Set.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');

  public String reverseVowels(String s) {
    int n = s.length();
    char[] ans = s.toCharArray();
    int left = 0;
    int right = n - 1;
    while (left < right) {
      if (VOWEL_SET.contains(ans[left]) && VOWEL_SET.contains(ans[right])) {
        swap(ans, left++, right--);
      } else if (!VOWEL_SET.contains(ans[left])) {
        left++;
      } else if (!VOWEL_SET.contains(ans[right])) {
        right--;
      }
    }
    return new String(ans);
  }

  private void swap(char[] chars, int left, int right) {
    char c = chars[left];
    chars[left] = chars[right];
    chars[right] = c;
  }

}
