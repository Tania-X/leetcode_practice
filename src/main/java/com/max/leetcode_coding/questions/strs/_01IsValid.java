package com.max.leetcode_coding.questions.strs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class _01IsValid {

  public static void main(String[] args) {
    boolean result = isValid("()");
    System.out.println("result = " + result);
  }

  public static boolean isValid(String s) {
    Map<Character, Character> map = new HashMap<>();
    map.put('{', '}');
    map.put('[', ']');
    map.put('(', ')');
    Deque<Character> stack = new ArrayDeque<>();
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      if (map.containsKey(c)) {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        char left = stack.pop();
        char counter = map.get(left);
        if (counter != c) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }

}
