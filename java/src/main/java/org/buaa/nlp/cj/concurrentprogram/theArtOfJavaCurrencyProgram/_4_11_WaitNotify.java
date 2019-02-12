package org.buaa.nlp.cj.concurrentprogram.theArtOfJavaCurrencyProgram;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2015/9/18.
 */
public class _4_11_WaitNotify {
    private static boolean flag = true;
    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(), "wart thread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);


        Thread notifyThread = new Thread(new Notify(), "notify thread");
        notifyThread.start();
    }

    static class Wait implements Runnable {

        @Override
        public void run() {
            // 加锁，拥有lock的monitor
            synchronized (lock) {
                // 当条件不满足时，继续wait,同时释放了lock的锁
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true. wart @ " +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        // 此处wait会释放对象锁
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 当条件满足时，完成工作
                System.out.println(Thread.currentThread() + " flag is false. running @ " +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold hock. notify @ " +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold hock again. notify @ " +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
