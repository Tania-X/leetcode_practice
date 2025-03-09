package com.max.leetcode_coding.situations;

public class SingletonInstance {

  private volatile SingletonInstance instance;

  private SingletonInstance() {
  }

  public SingletonInstance getInstance() {
    if (instance == null) {
      synchronized (SingletonInstance.class) {
        if (instance == null) {
          return new SingletonInstance();
        }
      }
    }
    return instance;
  }

}
