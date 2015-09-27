package org.buaa.nlp.cj.concurrentprogram.theArtOfJavaCurrencyProgram;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * Created by Administrator on 2015/9/24.
 */
public class _5_11_TwinsLockTest {
    final Lock lock = (Lock) new _5_10_TwinsLock();

    class Worker extends Thread {
        public void run() {
            while (true) {
                lock.lock();
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        _5_11_TwinsLockTest twinsLockTest = new _5_11_TwinsLockTest();

        for (int i = 0; i < 10; i++) {
            Worker w = twinsLockTest.new Worker();
            w.setDaemon(true);
            w.start();
        }

        for (int i = 0; i < 10; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println();
        }
    }
}
