package com.max.leetcode_coding.questions.multithreads;

import java.util.concurrent.atomic.AtomicBoolean;

public class FooBar {

  private int n;

  private final AtomicBoolean flg = new AtomicBoolean(false);

  public FooBar(int n) {
    this.n = n;
  }

  public void foo(Runnable printFoo) throws InterruptedException {

    for (int i = 0; i < n; i++) {
      synchronized (this) {
        while (flg.get()) {
          this.wait();
        }
        // printFoo.run() outputs "foo". Do not change or remove this line.
        printFoo.run();
        flg.set(true);
        this.notify();
      }
    }
  }

  public void bar(Runnable printBar) throws InterruptedException {

    for (int i = 0; i < n; i++) {
      synchronized (this) {
        while (!flg.get()) {
          this.wait();
        }
        // printBar.run() outputs "bar". Do not change or remove this line.
        printBar.run();
        flg.set(false);
        this.notify();
      }
    }
  }

}
