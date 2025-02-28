package com.max.leetcode_coding.questions.pointers;

import java.util.ArrayList;
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

}
