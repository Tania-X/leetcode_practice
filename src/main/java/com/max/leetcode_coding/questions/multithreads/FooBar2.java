package com.max.leetcode_coding.questions.multithreads;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.LockSupport;

public class FooBar2 {

  public static void main(String[] args) {
    FooBar2 job = new FooBar2(3);
    new Thread(() -> {
      try {
        job.foo(() -> System.out.print("foo"));
      } catch (InterruptedException e) {
        // do nothing
      }
    }).start();

    new Thread(() -> {
      try {
        job.bar(() -> System.out.print("bar"));
      } catch (InterruptedException e) {
        // do nothing
      }
    }).start();
  }

  private int n;

  public FooBar2(int n) {
    this.n = n;
  }

  private boolean flg = false;

  private final Map<Integer, Thread> map = new ConcurrentHashMap<>();

  public void foo(Runnable printFoo) throws InterruptedException {
    map.putIfAbsent(0, Thread.currentThread());
    for (int i = 0; i < n; i++) {
      while (flg) {
        LockSupport.park();
      }
      // printFoo.run() outputs "foo". Do not change or remove this line.
      printFoo.run();
      flg = true;
      LockSupport.unpark(map.get(1));
    }
  }

  public void bar(Runnable printBar) throws InterruptedException {
    map.putIfAbsent(1, Thread.currentThread());
    for (int i = 0; i < n; i++) {
      while (!flg) {
        LockSupport.park();
      }
      // printBar.run() outputs "bar". Do not change or remove this line.
      printBar.run();
      flg = false;
      LockSupport.unpark(map.get(0));
    }
  }

}
