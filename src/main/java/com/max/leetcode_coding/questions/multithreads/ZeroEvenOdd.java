package com.max.leetcode_coding.questions.multithreads;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {

  public static void main(String[] args) throws InterruptedException {
    ZeroEvenOdd job = new ZeroEvenOdd(2);
    IntConsumer printer = System.out::print;

    new Thread(() -> {
      try {
        job.zero(printer);
      } catch (InterruptedException e) {
        System.out.println("e = " + e);
      }
    }).start();

    new Thread(() -> {
      try {
        job.odd(printer);
      } catch (InterruptedException e) {
        System.out.println("e = " + e);
      }
    }).start();

    new Thread(() -> {
      try {
        job.even(printer);
      } catch (InterruptedException e) {
        System.out.println("e = " + e);
      }
    }).start();

    Thread.sleep(3 * 1000);
  }

  private int n;

  private final Semaphore semaphoreZero = new Semaphore(1);

  private final Semaphore semaphoreOdd = new Semaphore(0);

  private final Semaphore semaphoreEven = new Semaphore(0);

  public ZeroEvenOdd(int n) {
    this.n = n;
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void zero(IntConsumer printNumber) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      semaphoreZero.acquire();
      printNumber.accept(0);
      if (i % 2 == 0) {
        semaphoreOdd.release();
      } else {
        semaphoreEven.release();
      }
    }
  }

  public void even(IntConsumer printNumber) throws InterruptedException {
    for (int i = 2; i <= n; i += 2) {
      try {
        semaphoreEven.acquire();
        printNumber.accept(i);
      } finally {
        semaphoreZero.release();
      }
    }
  }

  public void odd(IntConsumer printNumber) throws InterruptedException {
    for (int i = 1; i <= n; i += 2) {
      try {
        semaphoreOdd.acquire();
        printNumber.accept(i);
      } finally {
        semaphoreZero.release();
      }
    }
  }

}
