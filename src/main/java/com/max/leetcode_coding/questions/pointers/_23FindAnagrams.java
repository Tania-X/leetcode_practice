package com.max.leetcode_coding.questions.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _23FindAnagrams {

  public static void main(String[] args) {
    List<Integer> anagrams = findAnagrams("abaacbabc", "abc");
    System.out.println("anagrams = " + anagrams);
  }

  public static List<Integer> findAnagrams(String s, String p) {
    List<Integer> ans = new ArrayList<>();
    Map<Character, Integer> pattern = new HashMap<>();
    char[] source = s.toCharArray();
    for (int i = 0; i < p.length(); i++) {
      pattern.merge(p.charAt(i), 1, Integer::sum);
    }
    Map<Character, Integer> var = new HashMap<>();
    int left = 0;
    for (int right = 0; right < source.length; right++) {
      var.merge(source[right], 1, Integer::sum);
      if (cover(pattern, var)) {
        while (left <= right && cover(pattern, var) && !pattern.equals(var)) {
          var.merge(source[left], -1, Integer::sum);
          if (var.get(source[left]) == 0) {
            var.remove(source[left]);
          }
          left++;
        }
        if (pattern.equals(var)) {
          ans.add(left);
        }
      }
    }
    return ans;
  }

  private static boolean cover(Map<Character, Integer> pattern, Map<Character, Integer> var) {
    for (Character c : pattern.keySet()) {
      if (!var.containsKey(c) || pattern.get(c) > var.get(c)) {
        return false;
      }
    }
    return true;
  }

  // 定长的滑动窗口
  public static List<Integer> findAnagrams2(String s, String p) {
    int n = s.length();
    List<Integer> ans = new ArrayList<>();
    int[] sArray = new int[26];
    int[] pArray = new int[26];
    char[] chars = p.toCharArray();
    char[] source = s.toCharArray();
    for (char c : chars) {
      pArray[c - 'a']++;
    }
    for (int right = 0; right < n; right++) {
      sArray[source[right] - 'a']++;
      int left = right - p.length() + 1;
      // 窗口长度不足则跳过
      if (left < 0) {
        continue;
      }
      if (Arrays.equals(pArray, sArray)) {
        ans.add(left);
      }
      // 窗口左侧移出
      sArray[source[left] - 'a']--;
    }
    return ans;
  }

}
