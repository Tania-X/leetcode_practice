package com.max.leetcode_coding.questions.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {

  public static void main(String[] args) {
    String result = simplifyPath("/../");
    System.out.println("result = " + result);
  }

  public static String simplifyPath(String path) {
    String[] paths = path.split("/");
    Deque<String> stack = new ArrayDeque<>();
    for (String s : paths) {
      if (s.isEmpty() || s.equals(".")) {
        continue;
      }
      if (!s.equals("..")) {
        stack.push(s);
      } else {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      }
    }
    int n = stack.size();
    String[] ans = new String[n];
    for (int i = 0; i < n; i++) {
      ans[n - i - 1] = stack.pop();
    }
    StringBuilder sb = new StringBuilder();
    for (String s : ans) {
      sb.append("/").append(s);
    }
    return sb.toString().isEmpty() ? "/" : sb.toString();
  }

}
