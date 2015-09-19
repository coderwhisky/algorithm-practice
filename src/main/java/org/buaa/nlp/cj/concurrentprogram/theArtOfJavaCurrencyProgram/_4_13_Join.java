package org.buaa.nlp.cj.concurrentprogram.theArtOfJavaCurrencyProgram;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2015/9/18.
 */
public class _4_13_Join {

    public static void main(String[] args) throws InterruptedException {
        String str = "hello";
        str += ' a';
        int strlen = str.length();
        str = 100;
        str = str +100;
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " terminate.");
    }

    static class Domino implements Runnable {
        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " terminated. /?");
        }
    }
}
