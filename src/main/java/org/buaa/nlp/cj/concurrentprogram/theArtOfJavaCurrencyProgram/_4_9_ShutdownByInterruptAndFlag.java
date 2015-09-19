package org.buaa.nlp.cj.concurrentprogram.theArtOfJavaCurrencyProgram;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2015/9/18.
 */
public class _4_9_ShutdownByInterruptAndFlag {
    public static class Runner implements Runnable {
        private long i;
        private volatile boolean on = true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("count i = " + i);
        }

        public void cancel() {
            on = false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();

        TimeUnit.SECONDS.sleep(1);
        // 通过线程中断使线程终止
        countThread.interrupt();

        Runner two = new Runner();
        countThread = new Thread(two, "countThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        // 通过设置标志位使线程终止
        two.cancel();
    }
}
