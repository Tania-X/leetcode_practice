package com.max.leetcode_coding.daily;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _02SimilarPairs {

  public static void main(String[] args) {

  }


  public static int similarPairs(String[] words) {
    int ans = 0;
    List<Set<Character>> list = new ArrayList<>();
    for (String word : words) {
      char[] charArray = word.toCharArray();
      Set<Character> set = new HashSet<>();
      for (char c : charArray) {
        set.add(c);
      }
      list.add(set);
    }
    for (int i = 0; i < list.size(); i++) {
      for (int j = i + 1; j < list.size(); j++) {
        if (list.get(i).equals(list.get(j))) {
          ans++;
        }
      }
    }
    return ans;
  }

  public static int similarPairs2(String[] words) {
    int ans = 0;
    Map<Set<Character>, Integer> map = new HashMap<>();
    for (String word : words) {
      char[] charArray = word.toCharArray();
      Set<Character> set = new HashSet<>();
      for (char c : charArray) {
        set.add(c);
      }
      map.merge(set, 1, Integer::sum);
    }
    Collection<Integer> values = map.values();
    for (Integer value : values) {
      ans += value * (value - 1) / 2;
    }

    return ans;
  }

}
