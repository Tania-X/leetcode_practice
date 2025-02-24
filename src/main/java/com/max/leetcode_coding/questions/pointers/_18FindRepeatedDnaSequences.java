package com.max.leetcode_coding.questions.pointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _18FindRepeatedDnaSequences {

  public static void main(String[] args) {
    List<String> result = findRepeatedDnaSequences("AAAAAAAAAAA");
    System.out.println("result = " + result);
  }

  public static List<String> findRepeatedDnaSequences(String s) {
    Set<String> ans = new HashSet<>();
    int n = s.length();
    if (n < 10) {
      return new ArrayList<>(ans);
    }
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i <= n - 10; i++) {
      map.merge(s.substring(i, i + 10), 1, Integer::sum);
    }
    for (int i = 0; i <= n - 10; i++) {
      if (map.get(s.substring(i, i + 10)) >= 2) {
        ans.add(s.substring(i, i + 10));
      }
    }
    return new ArrayList<>(ans);
  }

}
