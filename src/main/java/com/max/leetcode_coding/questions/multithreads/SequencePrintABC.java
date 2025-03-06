package com.max.leetcode_coding.questions.multithreads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SequencePrintABC {

  public static void main(String[] args) throws InterruptedException {

    new Thread(new PrintA()).start();
    new Thread(new PrintB()).start();
    new Thread(new PrintC()).start();

    lock.lock();
    try {
      conditionA.signal();
    } finally {
      lock.unlock();
    }

//    Thread.sleep(3 * 1000);

  }

  private static final int n = 8;

  private static int x = 0;

  private static final Lock lock = new ReentrantLock();

  private static final Condition conditionA = lock.newCondition();

  private static final Condition conditionB = lock.newCondition();

  private static final Condition conditionC = lock.newCondition();

  static class PrintA implements Runnable {

    @Override
    public void run() {
      while (x <= n) {
        lock.lock();
        try {
          while (x % 3 != 0) {
            conditionA.await();
          }
          if (x > n) {
            break;
          }
          System.out.print("A");
          x++;
          System.out.print("x = " + x);
          conditionB.signal();
        } catch (Exception e) {
          System.out.println("e = " + e);
        } finally {
          lock.unlock();
        }
      }
    }
  }

  static class PrintB implements Runnable {

    @Override
    public void run() {
      while (x <= n) {
        lock.lock();
        try {
          // B的位置提前终止
          if (x >= n) {
            break;
          }
          while (x % 3 != 1) {
            conditionB.await();
          }
          System.out.print("B");
          x++;
          System.out.print("x = " + x);
          conditionC.signal();
        } catch (Exception e) {
          System.out.println("e = " + e);
        } finally {
          lock.unlock();
        }
      }
    }
  }

  static class PrintC implements Runnable {

    @Override
    public void run() {
      while (x <= n) {
        lock.lock();
        try {
          while (x % 3 != 2) {
            conditionC.await();
          }
          if (x > n) {
            break;
          }
          System.out.print("C");
          x++;
          System.out.print("x = " + x);
          conditionA.signal();
        } catch (Exception e) {
          System.out.println("e = " + e);
        } finally {
          lock.unlock();
        }
      }
    }
  }

}
