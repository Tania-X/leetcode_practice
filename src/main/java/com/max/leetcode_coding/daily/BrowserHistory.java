package com.max.leetcode_coding.daily;

import java.util.ArrayList;
import java.util.List;

class BrowserHistory {

  private final List<String> browserPages;

  private int cur;

  public BrowserHistory(String homepage) {
    browserPages = new ArrayList<>();
    browserPages.add(homepage);
    cur = 0;
  }

  public void visit(String url) {
    while (cur + 1 < browserPages.size()) {
      browserPages.remove(browserPages.get(cur + 1));
    }
    browserPages.add(url);
    cur++;
  }

  public String back(int steps) {
    cur = Math.max(cur - steps, 0);
    return browserPages.get(cur);
  }

  public String forward(int steps) {
    cur = Math.min(cur + steps, browserPages.size() - 1);
    return browserPages.get(cur);
  }
}
