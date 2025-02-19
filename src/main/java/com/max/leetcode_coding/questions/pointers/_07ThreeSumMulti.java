package com.max.leetcode_coding.questions.pointers;

public class _07ThreeSumMulti {

  public static void main(String[] args) {

    int result = threeSumMulti(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8);
    System.out.println("result = " + result);

  }

  public static int threeSumMulti(int[] arr, int target) {
    int len = arr.length;
    if (len < 3) {
      return 0;
    }
    int MOD = 1_000_000_000 + 7;
    sort(arr);
    int ans = 0;
    for (int i = 0; i < len - 2; i++) {
      int x = arr[i];
      int j = i + 1;
      int k = len - 1;
      while (j < k) {
        int sum = x + arr[j] + arr[k];
        if (sum > target) {
          k--;
        } else if (sum < target) {
          j++;
        } else {
          if (arr[j] != arr[k]) {
            int yCount = 1;
            int zCount = 1;
            while (j < k - 1 && arr[j] == arr[j + 1]) {
              yCount++;
              j++;
            }
            while (k > j + 1 && arr[k] == arr[k - 1]) {
              zCount++;
              k--;
            }
            ans = (yCount * zCount + ans) % MOD;
            j++;
            k--;
          } else {
            ans = (ans + (k - j + 1) * (k - j) / 2) % MOD;
            break;
          }
        }
      }
    }
    return ans % MOD;
  }

  public static void sort(int[] arr) {
    int len = arr.length;
    int[] sup = new int[len];
    mergeSort(arr, 0, len - 1, sup);
  }

  public static void mergeSort(int[] arr, int left, int right, int[] sup) {
    if (left < right) {
      int mid = left + (right - left) / 2;
      mergeSort(arr, left, mid, sup);
      mergeSort(arr, mid + 1, right, sup);
      doMergeSort(arr, left, mid, right, sup);
    }
  }

  public static void doMergeSort(int[] arr, int left, int mid, int right, int[] sup) {
    int i = left;
    int j = mid + 1;
    int k = 0;
    while (i <= mid && j <= right) {
      if (arr[i] <= arr[j]) {
        sup[k++] = arr[i++];
      } else {
        sup[k++] = arr[j++];
      }
    }
    while (i <= mid) {
      sup[k++] = arr[i++];
    }
    while (j <= right) {
      sup[k++] = arr[j++];
    }
    System.arraycopy(sup, 0, arr, left, k);
  }


}
