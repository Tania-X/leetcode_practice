package com.max.leetcode_coding.daily;

public class Allocator {

  private final int[] mArray;

  public Allocator(int n) {
    mArray = new int[n];
  }

  public int allocate(int size, int mID) {
    int left = 0;
    int n = mArray.length;
    while (left + size - 1 < n) {
      int right = left;
      while (right < left + size && mArray[right] == 0) {
        right++;
      }
      if (right != left + size) {
        left = right + 1;
      } else {
        while (right > left) {
          mArray[--right] = mID;
        }
        return left;
      }
    }
    return -1;
  }

  public int freeMemory(int mID) {
    int ans = 0;
    for (int i = 0; i < mArray.length; i++) {
      if (mArray[i] == mID) {
        mArray[i] = 0;
        ans++;
      }
    }
    return ans;
  }

}
