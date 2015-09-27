package org.buaa.nlp.cj.concurrentprogram.theArtOfJavaCurrencyProgram;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by whisky-yonk on 9/21/2015.
 */
public class _4_18_ConnectionPoolTest {
    static _4_16_ConnectionPool pool = new _4_16_ConnectionPool(10);
    // 保证所有 ConnectionRunner 能同时开始
    static CountDownLatch start = new CountDownLatch(1);
    // main 线程将会等待所有 ConnectionRunner 结束后才能继续运行
    static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 100;
        end = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count, got, notGot), "connectionRunnerThread");
            thread.start();
        }
        start.countDown();
        end.await();
        System.out.println("total invoke: " + threadCount * count);
        System.out.println("get connection: " + got);
        System.out.println("not get connection: " + notGot);
    }

    static class ConnectionRunner implements Runnable {
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (count > 0) {
                try {
                    // 从线程池获取连接，如果 1000ms 内无法获取到，将返回null
                    // 分别统计连接获取的数量 got 和未获取到的数量 notGot
                    Connection connection = pool.fetchConnection(1000);
                    if (connection != null) {
                        try {
                            connection.createStatement();
                            connection.commit();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    } else {
                        notGot.incrementAndGet();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    count--;
                }
            }
            end.countDown();
        }
    }
}
