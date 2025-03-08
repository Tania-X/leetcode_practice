package com.max.leetcode_coding.questions.multithreads;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz {

  public static void main(String[] args) throws InterruptedException {
    FizzBuzz job = new FizzBuzz(15);
    IntConsumer numberPrinter = System.out::print;
    new Thread(() -> {
      try {
        job.fizz(() -> System.out.print("fizz"));
      } catch (InterruptedException e) {
        System.out.println("e = " + e);
      }
    }, "fizz").start();
    new Thread(() -> {
      try {
        job.buzz(() -> System.out.print("buzz"));
      } catch (InterruptedException e) {
        System.out.println("e = " + e);
      }
    }, "buzz").start();
    new Thread(() -> {
      try {
        job.fizzbuzz(() -> System.out.print("fizzbuzz"));
      } catch (InterruptedException e) {
        System.out.println("e = " + e);
      }
    }, "fizzbuzz").start();
    new Thread(() -> {
      try {
        job.number(numberPrinter);
      } catch (InterruptedException e) {
        System.out.println("e = " + e);
      }
    }, "number").start();
  }

  private final Semaphore fizz = new Semaphore(0);

  private final Semaphore buzz = new Semaphore(0);

  private final Semaphore fizzBuzz = new Semaphore(0);

  private final Semaphore number = new Semaphore(1);

  private int n;

  public FizzBuzz(int n) {
    this.n = n;
  }

  // printFizz.run() outputs "fizz".
  public void fizz(Runnable printFizz) throws InterruptedException {
    for (int i = 3; i <= n; i += 3) {
      // avoid the situation where fizz and fizzbuzz execute their acquire code simultaneously, which potentially causes threads running
      if (i % 5 != 0) {
        try {
          fizz.acquire();
          printFizz.run();
        } finally {
          number.release();
        }
      }
    }
  }

  // printBuzz.run() outputs "buzz".
  public void buzz(Runnable printBuzz) throws InterruptedException {
    for (int i = 5; i <= n; i += 5) {
      // avoid the situation where buzz and fizzbuzz execute their acquire code simultaneously, which potentially causes threads running
      if (i % 3 != 0) {
        try {
          buzz.acquire();
          printBuzz.run();
        } finally {
          number.release();
        }
      }
    }
  }

  // printFizzBuzz.run() outputs "fizzbuzz".
  public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
    for (int i = 15; i <= n; i += 15) {
      try {
        fizzBuzz.acquire();
        printFizzBuzz.run();
      } finally {
        number.release();
      }
    }
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void number(IntConsumer printNumber) throws InterruptedException {
    for (int i = 1; i <= n; i++) {
      number.acquire();
      if (i % 3 == 0 && i % 5 == 0) {
        fizzBuzz.release();
      } else if (i % 3 == 0) {
        fizz.release();
      } else if (i % 5 == 0) {
        buzz.release();
      } else {
        printNumber.accept(i);
        number.release();
      }
    }
  }

}
