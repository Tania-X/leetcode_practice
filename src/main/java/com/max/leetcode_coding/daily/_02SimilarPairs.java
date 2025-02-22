package com.max.leetcode_coding.daily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
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

}
