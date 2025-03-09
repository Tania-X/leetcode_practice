package com.max.leetcode_coding.questions.multithreads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class H2O {

  private final Lock lock = new ReentrantLock();

  private final Condition condition1 = lock.newCondition();

  private final Condition condition2 = lock.newCondition();

  private int charCount = 0;

  public H2O() {

  }

  public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
    lock.lock();
    try {
      while (charCount % 3 == 0) {
        condition1.await();
      }
      // releaseHydrogen.run() outputs "H". Do not change or remove this line.
      releaseHydrogen.run();
      charCount++;
      if (charCount % 3 == 2) {
        condition1.signal();
      } else {
        condition2.signal();
      }
    } finally {
      lock.unlock();
    }
  }

  public void oxygen(Runnable releaseOxygen) throws InterruptedException {
    lock.lock();
    try {
      while (charCount % 3 != 0) {
        condition2.await();
      }
      // releaseOxygen.run() outputs "O". Do not change or remove this line.
      releaseOxygen.run();
      charCount++;
      condition1.signal();
    } finally {
      lock.unlock();
    }
  }

}
