package com.max.leetcode_coding.questions.linked;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

  private static class LinkedCache {

    private int key;

    private int value;

    private LinkedCache prev;

    private LinkedCache next;

    private LinkedCache() {

    }

    private LinkedCache(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  // 由一个HashMap维护查询时间复杂度为o(1)的数据结构，用于直接存储数据
  private final Map<Integer, LinkedCache> cache = new HashMap<>();

  // 由两个dummy节点，维护双向链表的开端与结尾，如此方便在端口执行增删操作，需要考虑与HashMap联动操作
  private final LinkedCache dummyHead = new LinkedCache();
  private final LinkedCache dummyTail = new LinkedCache();

  private final int capacity;

  private int size;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    dummyHead.next = dummyTail;
    dummyTail.prev = dummyHead;
  }

  public int get(int key) {
    LinkedCache node = cache.get(key);
    if (node == null) {
      return -1;
    } else {
      removeNode(node);
      addToHead(node);
      return node.value;
    }
  }

  public void put(int key, int value) {
    LinkedCache node = cache.get(key);
    if (node == null) {
      LinkedCache newNode = new LinkedCache(key, value);
      cache.put(key, newNode);
      addToHead(newNode);
      size++;
      if (size > capacity) {
        LinkedCache deleteNode = dummyTail.prev;
        cache.remove(deleteNode.key);
        removeAtTail();
        size--;
      }
    } else {
      node.value = value;
      cache.put(key, node);
      removeNode(node);
      addToHead(node);
    }
  }

  private void removeAtTail() {
    LinkedCache prev = dummyTail.prev.prev;
    prev.next = dummyTail;
    dummyTail.prev = prev;
  }

  private void removeNode(LinkedCache node) {
    LinkedCache prev = node.prev;
    LinkedCache next = node.next;
    prev.next = next;
    next.prev = prev;
  }

  private void addToHead(LinkedCache node) {
    LinkedCache next = dummyHead.next;
    node.prev = dummyHead;
    node.next = next;
    next.prev = node;
    dummyHead.next = node;
  }

}
