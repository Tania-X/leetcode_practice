package com.max.leetcode_coding.situations;

import java.util.concurrent.locks.ReentrantLock;

public class CodeDeadLock {

  public static void main(String[] args) {
    ReentrantLock lock1= new ReentrantLock();
    ReentrantLock lock2= new ReentrantLock();

    new Thread(new CustomWork(lock1, lock2)).start();
    new Thread(new CustomWork(lock2, lock1)).start();

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }


  public static class CustomWork implements Runnable {

  private ReentrantLock lock1;
  private ReentrantLock lock2;

    public CustomWork(ReentrantLock lock1, ReentrantLock lock2) {
      this.lock1 = lock1;
      this.lock2 = lock2;
    }

    @Override
    public void run() {
      synchronized (lock1) {
        System.out.println("we have lock 1");
        try {
          System.out.println("current thread is: "  + Thread.currentThread().getName());
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        synchronized (lock2) {
          System.out.println("we have lock 2");
        }
      }
    }
  }

}
