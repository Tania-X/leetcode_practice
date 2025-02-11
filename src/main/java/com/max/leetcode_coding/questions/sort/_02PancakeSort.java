package com.max.leetcode_coding.questions.sort;

import java.util.ArrayList;
import java.util.List;

public class _02PancakeSort {

  public static void main(String[] args) {
    List<Integer> integers = pancakeSort(new int[]{3, 2, 4, 1});
    System.out.println("integers = " + integers);

  }

  public static List<Integer> pancakeSort(int[] arr) {
    // 构建与`arr`数组的索引与值反转之后的辅助数组`idxs`
    int len = arr.length;
    int[] idxs = new int[len + 10];
    for (int i = 0; i < len; i++) {
      idxs[arr[i]] = i;
    }
    List<Integer> ans = new ArrayList<>();
    // 翻转
    for (int i = len; i >= 1; i--) {
      int idx = idxs[i];
      if (arr[idx] == i - 1) continue;
      if (idx != 0) {
        ans.add(idx + 1);
        reverse(arr, 0, idx, idxs);
      }
      ans.add(i);
      reverse(arr, 0, i - 1, idxs);
    }
    return ans;
  }

  public static void reverse(int[] arr, int l, int r, int[] idxs) {
    while (l < r) {
      idxs[arr[l]] = r;
      idxs[arr[r]] = l;
      int temp = arr[l];
      arr[l++] = arr[r];
      arr[r--] = temp;
    }
  }

}
