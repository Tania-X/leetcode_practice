package com.max.leetcode_coding.daily;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream {

  private int _ptr;

  private final String[] _stringArray;

  public OrderedStream(int n) {
    _stringArray = new String[n + 2];
    _ptr = 1;
  }

  public List<String> insert(int idKey, String value) {
    if (_stringArray[idKey] != null) {
      throw new IllegalArgumentException();
    }
    _stringArray[idKey] = value;
    List<String> ans = new ArrayList<>();
    while (_stringArray[_ptr] != null) {
      ans.add(_stringArray[_ptr++]);
    }
    return ans;
  }

}
