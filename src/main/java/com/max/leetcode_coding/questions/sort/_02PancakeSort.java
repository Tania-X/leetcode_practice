package com.max.leetcode_coding.questions.sort;

import java.util.ArrayList;
import java.util.List;

public class _02PancakeSort {

  public static void main(String[] args) {
    List<Integer> result1 = pancakeSort(new int[]{3, 2, 4, 1});
    System.out.println("result1 = " + result1);
    List<Integer> result2 = pancakeSort2(new int[]{3, 2, 4, 1});
    System.out.println("result2 = " + result2);
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

  public static List<Integer> pancakeSort2(int[] arr) {
    // 以`arr`数组为基准，从后往前遍历，每次循环都确定该位置的结果
    int len = arr.length;
    List<Integer> ans = new ArrayList<>();
    for (int i = len; i >= 1; i--) {
      int idx = 0;
      for (int j = 0; j < i; j++) {
        if (arr[idx] > arr[j]) {
          continue;
        }
        idx = j;
      }
      if (idx == i - 1) continue;
      doReverse(arr, idx);
      doReverse(arr, i - 1);
      // 此处注意，要收集的是要翻转的子数组的长度，而不是要翻转的子数组的最后一位的索引
      ans.add(idx + 1);
      ans.add(i);
    }
    return ans;
  }

  private static void doReverse(int[] arr, int i) {
    int l = 0;
    int r = i;
    while (l < r) {
      int temp = arr[l];
      arr[l++] = arr[r];
      arr[r--] = temp;
    }
  }

}
