package com.max.leetcode_coding.questions.multithreads;

import java.util.concurrent.atomic.AtomicBoolean;

public class SerialPrint {

  private final AtomicBoolean firstDone = new AtomicBoolean(false);

  private final AtomicBoolean secondDone = new AtomicBoolean(false);

  public void first(Runnable printFirst) throws InterruptedException {
    printFirst.run();
    firstDone.set(true);
  }

  public void second(Runnable printSecond) throws InterruptedException {
    while (!firstDone.get()) {
      // do nothing
    }
    printSecond.run();
    secondDone.set(true);
  }

  public void third(Runnable printThird) throws InterruptedException {
    while (!secondDone.get()) {
      // do nothing
    }
    printThird.run();
  }

}
