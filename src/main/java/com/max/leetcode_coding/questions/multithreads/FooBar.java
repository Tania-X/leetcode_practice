package com.max.leetcode_coding.questions.multithreads;

import java.util.concurrent.Semaphore;

class Foo {

  public Foo() {

  }

  private final Semaphore semaphore1 = new Semaphore(1);

  private final Semaphore semaphore2 = new Semaphore(0);

  private final Semaphore semaphore3 = new Semaphore(0);

  public void first(Runnable printFirst) throws InterruptedException {
    try {
      semaphore1.acquire();
      // printFirst.run() outputs "first". Do not change or remove this line.
      printFirst.run();
    } finally {
      semaphore2.release();
    }
  }

  public void second(Runnable printSecond) throws InterruptedException {
    try {
      semaphore2.acquire();
      // printSecond.run() outputs "second". Do not change or remove this line.
      printSecond.run();
    } finally {
      semaphore3.release();
    }
  }

  public void third(Runnable printThird) throws InterruptedException {
    try {
      semaphore3.acquire();
      // printThird.run() outputs "third". Do not change or remove this line.
      printThird.run();
    } finally {
      semaphore1.release();
    }

  }
}