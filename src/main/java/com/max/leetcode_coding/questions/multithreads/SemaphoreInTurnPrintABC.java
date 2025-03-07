package com.max.leetcode_coding.questions.multithreads;

import java.util.concurrent.Semaphore;

public class SemaphoreInTurnPrintABC {

  public static void main(String[] args) throws InterruptedException {

    Semaphore semaphoreA = new Semaphore(1);
    Semaphore semaphoreB = new Semaphore(0);
    Semaphore semaphoreC = new Semaphore(0);
    int count = 10;

    new Thread(new PrintCharacter(semaphoreA, semaphoreB, "A", count)).start();
    new Thread(new PrintCharacter(semaphoreB, semaphoreC, "B", count)).start();
    new Thread(new PrintCharacter(semaphoreC, semaphoreA, "C", count)).start();

    Thread.sleep(3 * 1000);

  }

}

class PrintCharacter implements Runnable {

  private final Semaphore acquire;

  private final Semaphore release;

  private final String character;

  private final int count;

  public PrintCharacter(Semaphore acquire, Semaphore release, String character, int count) {
    this.acquire = acquire;
    this.release = release;
    this.character = character;
    this.count = count;
  }

  @Override
  public void run() {
    for (int i = 0; i < count; i++) {
      try {
        acquire.acquire();
      } catch (InterruptedException e) {
        System.out.println("e = " + e);
      }
      System.out.print(character);
      release.release();
    }
  }
}
