package com.max.leetcode_coding.questions.multithreads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SequencePrintABC {

  public static int round = 0;

  public static void main(String[] args) throws InterruptedException {

    Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();
    int count = 3;

    new Thread(new ConditionInTurnPrintABC(lock, conditionA, conditionB, "A", count, 0)).start();
    new Thread(new ConditionInTurnPrintABC(lock, conditionB, conditionC, "B", count, 1)).start();
    new Thread(new ConditionInTurnPrintABC(lock, conditionC, conditionA, "C", count, 2)).start();

    lock.lock();
    try {
      conditionA.signal();
    } finally {
      lock.unlock();
    }

    Thread.sleep(3 * 1000);

  }

}

class ConditionInTurnPrintABC implements Runnable {

  private final Lock lock;

  private final Condition await;

  private final Condition signal;

  private final String output;

  private final int count;

  private final int weight;

  public ConditionInTurnPrintABC(Lock lock, Condition await, Condition signal, String output,
      int count, int weight) {
    this.lock = lock;
    this.await = await;
    this.signal = signal;
    this.output = output;
    this.count = count;
    this.weight = weight;
  }

  @Override
  public void run() {
    for (int i = 0; i < count; i++) {
      lock.lock();
      try {
        while (SequencePrintABC.round % 3 != weight) {
          await.await();
        }
        System.out.print(output);
        SequencePrintABC.round++;
        signal.signal();
      } catch (InterruptedException e) {
        // do nothing
      } finally {
        lock.unlock();
      }
    }
  }
}
